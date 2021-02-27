package com.company;

import com.company.creatures.Animal;
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

        var zdzichu = new Human("Zdzisław", "Jarzyna", 5000.00);
        var puszek = new Animal("Cat", "Puszek", 11.45);

        try {
            zdzichu.save();
            puszek.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
