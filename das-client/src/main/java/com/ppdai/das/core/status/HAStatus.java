package com.ppdai.das.core.status;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

import com.ppdai.das.core.enums.DatabaseCategory;

public class HAStatus extends BaseStatus implements HAStatusMBean {

	private volatile boolean enabled = false;

	private volatile int retryCount = 1;

	private volatile Set<Integer> sqlservercodes = new HashSet<Integer>();

	private volatile Set<Integer> mysqlcodes = new HashSet<Integer>();
	
	public HAStatus() {
		sqlservercodes = DatabaseCategory.SqlServer.getDefaultErrorCodes();
		mysqlcodes = DatabaseCategory.MySql.getDefaultErrorCodes();
	}
	
	@Override
    public boolean isEnabled() {
		return enabled;
	}

	@Override
    public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		changed();
	}

	@Override
    public int getRetryCount() {
		return retryCount;
	}

	@Override
    public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
		changed();
	}
	
	@Override
    public String getSqlserverErrorCodes() {
		return StringUtils.join(sqlservercodes, ',');
	}
	
	@Override
    public void setSqlserverErrorCodes(String sqlserverErrorCodes) {
		sqlservercodes = parseErrorCodes(sqlserverErrorCodes);
		changed();
	}

	@Override
    public String getMysqlErrorCodes() {
		return StringUtils.join(mysqlcodes, ',');
	}
	
	@Override
    public void setMysqlErrorCodes(String mysqlErrorCodes) {
		mysqlcodes = parseErrorCodes(mysqlErrorCodes);
		changed();
	}

	public Set<Integer> getSqlservercodes() {
		return sqlservercodes;
	}

	public Set<Integer> getMysqlcodes() {
		return mysqlcodes;
	}
	
	private Set<Integer> parseErrorCodes(String codes){
		Set<Integer> temp = new TreeSet<Integer>();
		String[] tokens = codes.split(",");
		for (String code : tokens) {
			temp.add(Integer.valueOf(code));
		}
		return temp;
	}
}
