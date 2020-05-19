package com.example.northwind.dao;

// simple interface declaring what a data access object should be able to do

import com.example.northwind.model.Product;

import java.util.List;

public interface NorthwindDao {

    int addProduct(Product product);

    List<Product> getAllProducts();

}
