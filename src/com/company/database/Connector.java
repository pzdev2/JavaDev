package com.company.database;

import com.company.Configuration;

import java.sql.*;

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

    public static ResultSet executeQuery(String sql) throws SQLException {
        return getStatement().executeQuery(sql);
    }
}
