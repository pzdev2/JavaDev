package com.company;

import com.company.creatures.Human;
import com.company.creatures.Pet;
import com.company.database.Connect;
import com.company.database.Connector;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connect.open();

        var hamster = new Pet("Hamster", "Sara", 0.98);
        var human = new Human("Human", "Jan", "Kowalski", 200.00);

//        try {
//            hamster.save();
//            human.save();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        String selAnimal = "select * from animal;";
        String selHuman = "select * from human;";
        try {
            ResultSet rsAnimal = Connector.executeQuery(selAnimal);
            ResultSet rsHuman = Connector.executeQuery(selHuman);


            while (rsAnimal.next()) {
                String species = rsAnimal.getString(2);
                String name = rsAnimal.getString(3);
                Double weight = rsAnimal.getDouble(4);
                System.out.println("species: " + species + " name: " + name + " weight: " + weight);
            }
            System.out.println("==================");

            while (rsHuman.next()) {
                String firstName = rsHuman.getString("first_name");
                String lastName = rsHuman.getString("last_name");
                System.out.println("First name: " + firstName);
                System.out.println("Last name: " + lastName);
                System.out.println("-----------------------");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
