package com.example.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public Product(@JsonProperty("name") String name) {
        this.name = name;
    }
    public Product(){};

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
