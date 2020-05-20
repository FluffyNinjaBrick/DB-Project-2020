package com.example.northwind.dao;

import com.example.northwind.model.Category;
import com.example.northwind.model.Customer;
import com.example.northwind.model.Product;
import com.example.northwind.model.Shipper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.cj.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// this is where the most will need to be done. This is where we'll be implementing add the DB access methods

@Repository("HibernateAccess") // repository here meaning a class that stored data in a DB
public class HibernateAccess implements NorthwindDao {

    @Override
    public int addProduct(Product product) {
        System.out.println("Everything hooked up correctly");
        // TODO - this is where the actual DB logic is gonna go,
        //  for now I'm just doing the API so I'm leaving this blank

        return 0;
    }

    @Override
    public List<Product> getAllProducts() {
        //TODO - as above
        List<Product> list = new ArrayList<>();
        Category category = new Category("meat", "not for vegans");
        list.add(new Product("Cheese",category, 15, 2.5,5, 20));
        return list;
    }

    @Override
    public int addCategory(Category category) {


        return 0;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public int addCustomer(Customer customer) {
        return 0;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public int addShipper(Shipper shipper) {
        return 0;
    }

    @Override
    public List<Shipper> getAllShippers() {
        return null;
    }
}
