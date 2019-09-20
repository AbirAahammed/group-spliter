package com.splitit.persistence;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccessor {
    private static org.apache.log4j.Logger logger = Logger.getLogger(DBAccessor.class);
    public String dbUrl;
    public String dbUSerName;
    public String key;

    public DBAccessor(String dbUrl, String dbUSerName, String pass) {
        this.dbUrl = dbUrl;
        this.dbUSerName = dbUSerName;
        this.key = pass;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUSerName() {
        return dbUSerName;
    }

    public void setDbUSerName(String dbUSerName) {
        this.dbUSerName = dbUSerName;
    }

    public String getPass() {
        return key;
    }

    public void setPass(String pass) {
        this.key = pass;
    }


    public Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            logger.error(e);
        }
        return DriverManager.getConnection(dbUrl,dbUSerName, key);
    }

    public ResultSet execute(Connection con, String script) throws SQLException{
        Statement stmt=con.createStatement();
        return stmt.executeQuery(script);
    }
}
