package com.example.northwind.dao;

// simple interface declaring what a data access object should be able to do

import com.example.northwind.model.*;

import java.util.List;

public interface NorthwindDao {

    int addProduct(Product product, int category_id);
    List<Product> getAllProducts();

    int addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryByID(int id);

    int addCustomer(Customer customer);
    List<Customer> getAllCustomers();

    int addShipper(Shipper shipper);
    List<Shipper> getAllShippers();


}
