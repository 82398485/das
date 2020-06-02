package com.ppdai.das.core.task;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import com.ppdai.das.client.Hints;
import com.ppdai.das.core.HintEnum;
import com.ppdai.das.core.DasConfigureFactory;
import com.ppdai.das.core.DasException;
import com.ppdai.das.core.DasLogger;
import com.ppdai.das.core.ErrorCode;
import com.ppdai.das.core.LogContext;
import com.ppdai.das.core.ResultMerger;
import com.ppdai.das.core.client.DalResultCallback;

/**
 * Common reuqest executor that support execute request that is of pojo or 
 * sql in single, all or multiple shards
 * 
 * @author jhhe
 */
public class SqlRequestExecutor {
	private static AtomicReference<ExecutorService> serviceRef = new AtomicReference<>();
	
	public static final String MAX_POOL_SIZE = "maxPoolSize";
	public static final String KEEP_ALIVE_TIME = "keepAliveTime";
	
	// To be consist with default connection max active size
	public static final int DEFAULT_MAX_POOL_SIZE = 500;

	public static final int DEFAULT_KEEP_ALIVE_TIME = 10;
	
	private DasLogger logger = DasConfigureFactory.getLogger();
	
	private final static String NA = "N/A";
	        
	public static void init(String maxPoolSizeStr, String keepAliveTimeStr){
		if(serviceRef.get() != null) {
			return;
		}
		
		synchronized (SqlRequestExecutor.class) {
			if(serviceRef.get() != null) {
				return;
			}
			
			int maxPoolSize = DEFAULT_MAX_POOL_SIZE;
			if(maxPoolSizeStr != null) {
				maxPoolSize = Integer.parseInt(maxPoolSizeStr);
			}
			
			int keepAliveTime = DEFAULT_KEEP_ALIVE_TIME;
            if(keepAliveTimeStr != null) {
				keepAliveTime = Integer.parseInt(keepAliveTimeStr);
			}
			
            ThreadPoolExecutor executer = new ThreadPoolExecutor(maxPoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
                AtomicInteger atomic = new AtomicInteger();
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "DalRequestExecutor-Worker-" + this.atomic.getAndIncrement());
                }
            });
            executer.allowCoreThreadTimeOut(true);
            
            serviceRef.set(executer);
		}
	} 
	
	public static void shutdown() {
		if (serviceRef.get() == null) {
			return;
		}
		
		synchronized (SqlRequestExecutor.class) {
			if (serviceRef.get() == null) {
				return;
			}
			
			serviceRef.get().shutdown();
			serviceRef.set(null);
		}
	}

	public <T> T execute(final SqlRequest<T> request, final boolean nullable) throws SQLException {
	    // We don't support asynchronized execution
		return internalExecute(request, nullable);
	}

	private <T> T internalExecute(SqlRequest<T> request, boolean nullable) throws SQLException {
		T result = null;
		Throwable error = null;
		Hints hints = request.getHints();

		LogContext logContext = logger.start(request);
		
		try {
			request.validate();
			
			if(request.isCrossShard()) {
				result = crossShardExecute(logContext, hints, request);
			} else {
				result = nonCrossShardExecute(logContext, hints, request);
			}

			if(result == null && !nullable) {
				throw new DasException(ErrorCode.AssertNull);
			}

			request.endExecution();
		} catch (Throwable e) {
			error = e;
		}
		
		logger.end(logContext, error);
		
		handleCallback(hints, result, error);
		if(error != null) {
			throw DasException.wrap(error);
		}
		
		return result;
	}

	private <T> T nonCrossShardExecute(LogContext logContext, Hints hints, SqlRequest<T> request) throws Exception {
        logContext.setSingleTask(true);
	    Callable<T> task = new RequestTaskWrapper<T>(NA, request.createTask(), logContext);
		return task.call();
	}
	
	private <T> T crossShardExecute(LogContext logContext, Hints hints, SqlRequest<T> request) throws Exception {
        Map<String, Callable<T>> tasks = request.createTasks();
        logContext.setShards(tasks.keySet());

        boolean isSequentialExecution = hints.is(HintEnum.sequentialExecution);
        logContext.setSeqencialExecution(isSequentialExecution);
        
        ResultMerger<T> merger = request.getMerger();
        
	    logger.startCrossShardTasks(logContext, isSequentialExecution);
		
		T result = null;
		Throwable error = null;

		try {
            result = isSequentialExecution?
            		seqncialExecute(hints, tasks, merger, logContext):
            		parallelExecute(hints, tasks, merger, logContext);

        } catch (Throwable e) {
            error = e;
        }
		
		logger.endCrossShards(logContext, error);

		if(error != null) {
			throw DasException.wrap(error);
		}
		
		return result;

	}

	private <T> void handleCallback(final Hints hints, T result, Throwable error) {
		DalResultCallback qc = (DalResultCallback)hints.get(HintEnum.resultCallback);
		if (qc == null) {
			return;
		}
		
		if(error == null) {
			qc.onResult(result);
		} else {
			qc.onError(error);
		}
	}

	private <T> T parallelExecute(Hints hints, Map<String, Callable<T>> tasks, ResultMerger<T> merger, LogContext logContext) throws SQLException {
		Map<String, Future<T>> resultFutures = new HashMap<>();
		
		for(final String shard: tasks.keySet()) {
			resultFutures.put(shard, serviceRef.get().submit(new RequestTaskWrapper<T>(shard, tasks.get(shard), logContext)));
		}

		for(Map.Entry<String, Future<T>> entry: resultFutures.entrySet()) {
			try {
				merger.addPartial(entry.getKey(), entry.getValue().get());
			} catch (Throwable e) {
			    DasException.handleError("There is error during parallel execution: ", e);
			}
		}
		
		return merger.merge();
	}

	private <T> T seqncialExecute(Hints hints, Map<String, Callable<T>> tasks, ResultMerger<T> merger, LogContext logContext) throws SQLException {
		for(final String shard: tasks.keySet()) {
			try {
				merger.addPartial(shard, new RequestTaskWrapper<T>(shard, tasks.get(shard), logContext).call());
			} catch (Throwable e) {
			    DasException.handleError("There is error during sequential execution: ", e);
			}
		}
		
		return merger.merge();
	}
	
	public static int getPoolSize() {
	    ThreadPoolExecutor executer = (ThreadPoolExecutor)serviceRef.get();
	    if (serviceRef.get() == null) {
			return 0;
		}
	    
	    return executer.getPoolSize();
	}
}