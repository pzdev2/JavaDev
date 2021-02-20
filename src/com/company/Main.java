package com.company;

import com.company.creatures.Pet;
import com.company.database.Connect;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connect.open();

        var hamster = new Pet("Hamster", "Sara", 0.98);
        try {
            hamster.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
