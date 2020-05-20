package com.example.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;
    private int QuantityPerUnit;
    private double UnitPrice;
    private int UnitInStock;
    private int UnitsOnOrder;


    public Product(@JsonProperty("name") String name,@JsonProperty("category") Category category, @JsonProperty("quantityPerUnit") int quantityPerUnit,
                   @JsonProperty("unitPrice") double unitPrice, @JsonProperty("unitInStock") int unitInStock,@JsonProperty("unitsOnOrder") int unitsOnOrder) {
        this.name = name;
        this.category = category;
        this.QuantityPerUnit = quantityPerUnit;
        this.UnitPrice = unitPrice;
        this.UnitInStock = unitInStock;
        this.UnitsOnOrder = unitsOnOrder;
    }

    public Product(){};

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public int getUnitInStock() {
        return UnitInStock;
    }

    public int getUnitsOnOrder() {
        return UnitsOnOrder;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
