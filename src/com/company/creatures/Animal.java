package com.company.creatures;

import com.company.database.Connector;
import com.company.devices.Saleable;

import java.io.File;
import java.sql.*;

public abstract class Animal implements Saleable, Feedable {

    final static Double MIN_WEIGHT = 2.0;
    final static Double DEFAULT_FOOD_WEIGHT = 1.0;

    final public String species;
    public Boolean isAlive = true;
    public String name;
    File pic;
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
        if (this.species == "dog") {
            feed(2.0);
        } else if (this.species == "cat") {
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

    public String toString() {
        return this.species + " " + this.name + " isAlive: " + this.isAlive;
    }


    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {

    }

    public void save() throws SQLException {
        String sql = "insert into animal (species, name, weight)" +
                " values ('" + this.species + "', '" + this.name + "', " + this.weight + ")";
        Connector.executeSql(sql);
    }
}
