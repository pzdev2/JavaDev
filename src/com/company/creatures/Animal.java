package com.company.creatures;

import com.company.database.Connector;
import com.company.devices.Saleable;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Animal implements Saleable, Feedable {

    final static Double MIN_WEIGHT = 2.0;
    final static Double DEFAULT_FOOD_WEIGHT = 1.0;

    final public String species;
    public Boolean isAlive = true;
    public String name;
    private Double weight;

    public Animal(String species) {
        this.species = species;
    }

    public Animal(String species, String name, Double weight) {
        this.species = species;
        this.name = name;
        this.weight = weight;
    }

    public void feed() {
        if (this.species.equals("dog")) {
            feed(2.0);
        } else if (this.species.equals("cat")) {
            feed(0.5);
        } else if (this instanceof FarmAnimal) {
            feed(5.0);
        } else {
            feed(DEFAULT_FOOD_WEIGHT);
        }
    }

    public void feed(double foodWeight) {
        if (this.isAlive) {
            this.weight += foodWeight;
            System.out.println("thx for food");
        } else {
            System.out.println("too late");
        }
    }


    public void takeForAWalk() {
        if (this.isAlive) {
            this.weight--;
            System.out.println("thx for a walk, bro");
            if (this.weight < MIN_WEIGHT) {
                this.isAlive = false;
            }
        } else {
            System.out.println("go for jail");
            System.out.println("nice");
        }
    }

    public Double getWeight() {
        return weight;
    }

    void setWeight(Double newWeight) {
        this.weight = newWeight;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {

    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static List<Animal> findAll() {
        List<Animal> animalList = new LinkedList<>();
        String getAnimals = "select * from animal;";
        try {
            ResultSet animals = Connector.executeQuery(getAnimals);

            while (animals.next()) {
                String species = animals.getString("species");
                String name = animals.getString("name");
                Double weight = animals.getDouble("weight");
                animalList.add(new Animal(species, name, weight));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return animalList;
    }

}
