package com.company.database;

import java.sql.SQLException;

public class Connect {

    public static void open() {
        try {
            Connector.connect();
            Connector.getStatement();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
