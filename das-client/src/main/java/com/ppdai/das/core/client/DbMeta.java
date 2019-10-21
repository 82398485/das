package com.ppdai.das.core.client;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ppdai.das.core.LogEntry;
import com.ppdai.das.core.configure.DataSourceConfigure;
import com.ppdai.das.core.configure.DataSourceConfigureLocator;
import com.ppdai.das.core.configure.DataSourceConfigureLocatorManager;
import com.ppdai.das.core.datasource.DataSourceLocator;
import com.ppdai.das.core.enums.DatabaseCategory;

public class DbMeta {
    private static Pattern hostRegxPattern = null;
    private DataSourceConfigureLocator configureLocator = DataSourceConfigureLocatorManager.getInstance();

    private String databaseName;
    private DatabaseCategory dbCategory;
    private String dataBaseKeyName;
    private String userName;
    private String url;
    private String host;

    static {
        String regEx = "(?<=://)[\\w\\-_]+(\\.[\\w\\-_]+)+(?=[,|:|;])";
        hostRegxPattern = Pattern.compile(regEx);
    }

    private DbMeta(Connection conn, String realDbName, DatabaseCategory dbCategory) throws SQLException {
        dataBaseKeyName = realDbName;
        this.dbCategory = dbCategory;

        try {
            DatabaseMetaData meta = conn.getMetaData();
            databaseName = conn.getCatalog();
            url = meta.getURL();
            host = parseHostFromDBURL(url);

            userName = null;
            if(configureLocator == null) {
                userName = DataSourceLocator.getDataSourceConfigure(realDbName).getUserName();
            }else {
                userName = configureLocator.getDataSourceConfigure(realDbName).getUserName();
            }
        } catch (Throwable e) {
        }
    }

    public void populate(LogEntry entry) {
        entry.setDatabaseName(databaseName);
        entry.setServerAddress(host);
        entry.setDbUrl(url);
        entry.setUserName(userName);
        entry.setDataBaseKeyName(dataBaseKeyName);
    }

    public static DbMeta createIfAbsent(String realDbName, DatabaseCategory dbCategory, Connection conn)
            throws SQLException {
        return new DbMeta(conn, realDbName, dbCategory);
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getDataBaseKeyName() {
        return dataBaseKeyName;
    }

    public DatabaseCategory getDatabaseCategory() {
        return dbCategory;
    }

    private String parseHostFromDBURL(String url) {
        Matcher m = hostRegxPattern.matcher(url);
        String host = "NA";
        while (m.find()) {
            host = m.group();
            break;
        }
        return host;
    }

}
