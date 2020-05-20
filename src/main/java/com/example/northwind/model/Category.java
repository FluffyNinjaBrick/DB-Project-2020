package com.example.northwind.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String CategoryName;
    private String Description;
    @OneToMany(mappedBy = "ProductCategory",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    Set<Product> Products;

    public Category(){Products = new HashSet<Product>();}
    public Category(@JsonProperty("name") String categoryName, @JsonProperty("description") String description){
        this.CategoryName = categoryName;
        this.Description = description;
        Products = new HashSet<Product>();
    }

    public void addProductToList(Product product){
        Products.add(product);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return new ArrayList<Product>(Products);
    }

    public void setProducts(List<Product> products) {
        Products = new HashSet<Product>(products);
    }
}
