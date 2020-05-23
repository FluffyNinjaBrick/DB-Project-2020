package com.example.northwind.dao;

// simple interface declaring what a data access object should be able to do

import com.example.northwind.model.*;

import java.util.List;

public interface NorthwindDao {

    // ==========  PRODUCT  ========== //
    int addProduct(Product product, int category_id);
    List<Product> getAllProducts();


    // ==========  CATEGORY  ========== //
    int addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryByID(int id);


    // ==========  CUSTOMER  ========== //
    int addCustomer(Customer customer);
    List<Customer> getAllCustomers();


    // ==========  SHIPPER  ========== //
    int addShipper(Shipper shipper);
    List<Shipper> getAllShippers();


}
