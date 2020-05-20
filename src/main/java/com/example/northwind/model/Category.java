package com.example.northwind.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CategoryID;
    private String CategoryName;
    private String Description;
    @OneToMany
    @JoinColumn(name = "CategoryID")
    List<Product> Products = new ArrayList<>();

    public Category(){}
    public Category(@JsonProperty("name") String categoryName, @JsonProperty("description") String description){
        this.CategoryName = categoryName;
        this.Description = description;
    }

    public void addProductToList(Product product){
        Products.add(product);
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }
}
