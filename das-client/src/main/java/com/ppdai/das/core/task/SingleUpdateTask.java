package com.ppdai.das.core.task;

import java.sql.SQLException;
import java.util.*;

import com.ppdai.das.client.Hints;
import com.ppdai.das.client.Parameter;
import com.ppdai.das.core.DasException;
import com.ppdai.das.core.ErrorCode;
import com.ppdai.das.core.UpdatableEntity;

public class SingleUpdateTask<T> extends TaskAdapter<T> implements SingleTask<T> {
	public static final String TMPL_SQL_UPDATE = "UPDATE %s SET %s WHERE %s";
	
	@Override
	public int execute(Hints hints, Map<String, ?> fields, T rawPojo) throws SQLException {
		if (fields.size() == 0) {
            throw new DasException(ErrorCode.ValidateFieldCount);
        }
		Map<String, ?> pks = getPrimaryKeys(fields);
		
		Object version = getVersion(fields);
		
		Map<String, ?> filted = null;
		
		if(rawPojo instanceof UpdatableEntity) {
            filted = filterUpdatableEntity(hints, fields, getUpdatedColumns(rawPojo));
        } else {
            filted = filterNullColumns(hints, fields);
        }
		
		// If there is no columns changed, we will not perform update
		if(filted.size() == 0) {
            return 0;
        }
		
		String updateSql = buildUpdateSql(getTableName(hints, fields), filted, hints);

		List<Parameter> parameters = new ArrayList<>();
		addParameters(parameters, filted);
		addParameters(parameters, pks);
		addVersion(parameters, version);
		
		return client.update(updateSql, parameters, hints.setFields(fields));
	}

	private Object getVersion(Map<String, ?> fields) throws DasException {
		if(!hasVersion) {
            return null;
        }

		Object version = fields.get(parser.getVersionColumn());
		if(version == null) {
            throw new DasException(ErrorCode.ValidateVersion);
        }

		return version;
	}
	
	private Map<String, ?> filterNullColumns(Hints hints, Map<String, ?> fields) throws DasException {
		Map<String, Object> filted = new LinkedHashMap<>();
		
		Set<String> updatableColumns = filterColumns(hints);
			
		// Remove null value when hints is not DalHintEnum.updateNullField or
		// primary key or not updatable
		for (String column : parser.getColumnNames()) {
			if ((fields.get(column) == null && !hints.isUpdateNullField())
					|| isPrimaryKey(column) || !updatableColumns.contains(column)) {
                continue;
            }
			
			filted.put(column, fields.get(column));
		}
		
		return filted;
	}
	
	private Map<String, ?> filterUpdatableEntity(Hints hints, Map<String, ?> fields, Set<String> updatedColumns) throws DasException {
		Map<String, Object> filted = new LinkedHashMap<>();
		Set<String> updatableColumns = filterColumns(hints);
			
		// Dirty flag is not set but need to update
		// primary key or not updatable
		for (String column : parser.getColumnNames()) {
			if (!updatedColumns.contains(column) && !hints.isUpdateUnchangedField() || 
					isPrimaryKey(column) || !updatableColumns.contains(column)) {
                continue;
            }
			
			filted.put(column, fields.get(column));
		}
		
		return filted;
	}
	
	private String buildUpdateSql(String tableName, Map<String, ?> fields, Hints hints) {
		String columns = String.format(
				combine(TMPL_SET_VALUE, fields.size(), COLUMN_SEPARATOR),
				quote(fields.keySet()));

		if(isVersionUpdatable) {
            columns += COLUMN_SEPARATOR + setVersionValueTmpl;
        }

		return String.format(TMPL_SQL_UPDATE, tableName, columns, updateCriteriaTmpl);
	}
	
	private void addVersion(List<Parameter> parameters, Object version) throws DasException {
		if(!hasVersion) {
            return;
        }
		
		addParameter(parameters, parameters.size() + 1, parser.getVersionColumn(), version);
	}
}
