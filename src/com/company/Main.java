package com.company;

import com.company.creatures.Animal;
import com.company.database.Connector;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            Connector.connect();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Animal.findAll().forEach(System.out::println);
    }
}
