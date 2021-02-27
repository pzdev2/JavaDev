package com.company;

import com.company.creatures.Human;
import com.company.database.Connector;
import com.company.devices.Car;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Car> cars = new HashMap<>();

        cars.put("Maluch", new Car(2010, "Fiat", "126p", "red", 10000.00));
        cars.put("Rekin", new Car(2020, "BMW", "E21", "black", 100000.00));
        cars.put("Jazz", new Car(2011, "Honda", "Jazz", "red", 20000.00));
        cars.put("Ceed", new Car(2021, "Kia", "Ceed", "white", 50000.00));

        cars.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Car>comparingByKey())
                .forEach(System.out::println);
    }
}
