package com.company;

import com.company.creatures.Human;
import com.company.database.Connector;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            Connector.connect();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Human.findAllHumans().forEach(System.out::println);
    }
}
