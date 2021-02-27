package com.company.database;

import java.sql.*;

public class Connector {

    private static final String USER = System.getenv("db_user");
    private static final String PASSWORD = System.getenv("db_pass");
    private static final String URL = System.getenv("db_url");

    private static Connection CONN;

    public static void connect() throws SQLException {
        CONN = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Statement getStatement() throws SQLException {
        return CONN.createStatement();
    }

    public static void executeSql(String sql) throws SQLException {
        getStatement().execute(sql);
    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        return getStatement().executeQuery(sql);
    }
}
