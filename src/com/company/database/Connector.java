package com.company.database;

import com.company.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {

    private static Connection CONN;

    public static void connect() throws SQLException {
        CONN = DriverManager.getConnection(Configuration.URL, Configuration.USER, Configuration.PASSWORD);
    }

    public static Statement getStatement() throws SQLException {
        return CONN.createStatement();
    }

    public static void executeSql(String sql) throws SQLException {

        CONN.createStatement().execute(sql);
    }
}
