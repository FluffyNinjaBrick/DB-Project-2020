package com.example.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private int QuantityPerUnit;
    private double UnitPrice;
    private int UnitInStock;
    private int UnitsOnOrder;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName ="id", nullable = false)
    private Category ProductCategory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<OrderDetails> details;

    public Product(){ this.details = new HashSet<>();};
    public Product(@JsonProperty("name") String name,@JsonProperty("category") Category category, @JsonProperty("quantityPerUnit") int quantityPerUnit,
                   @JsonProperty("unitPrice") double unitPrice, @JsonProperty("unitInStock") int unitInStock,@JsonProperty("unitsOnOrder") int unitsOnOrder) {
        this.name = name;
        this.ProductCategory = category;
        this.QuantityPerUnit = quantityPerUnit;
        this.UnitPrice = unitPrice;
        this.UnitInStock = unitInStock;
        this.UnitsOnOrder = unitsOnOrder;
        this.details = new HashSet<>();
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return ProductCategory;
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
        this.ProductCategory = category;
    }

    public void setQuantityPerUnit(int quantityPerUnit) {
        QuantityPerUnit = quantityPerUnit;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public void setUnitInStock(int unitInStock) {
        UnitInStock = unitInStock;
    }

    public void setUnitsOnOrder(int unitsOnOrder) {
        UnitsOnOrder = unitsOnOrder;
    }

    public void setProductCategory(Category productCategory) {
        ProductCategory = productCategory;
    }
}
