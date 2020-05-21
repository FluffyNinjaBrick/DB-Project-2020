package com.example.northwind.dao;

import com.example.northwind.model.Category;
import com.example.northwind.model.Customer;
import com.example.northwind.model.Product;
import com.example.northwind.model.Shipper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.cj.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// this is where the most will need to be done. This is where we'll be implementing add the DB access methods

@Repository("HibernateAccess") // repository here meaning a class that stored data in a DB
public class HibernateAccess implements NorthwindDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int addProduct(Product product, int category_id) {
        // TODO - this is where the actual DB logic is gonna go,
        //  for now I'm just doing the API so I'm leaving this blank
        System.out.println("hello");
        Category category = em.find(Category.class,category_id);
        product.setCategory(category);
        System.out.println(category);
        //em.persist(product);
        //em.persist(category);
        return 0;
    }

    @Override
    public List<Product> getAllProducts() {
        return em.createQuery("FROM Product ").getResultList();
    }

    @Override
    public int addCategory(Category category) {
        em.persist(category);
        return 0;
    }

    @Override
    public List<Category> getAllCategories() {
        return em.createQuery("FROM Category").getResultList();
    }

    @Override
    public int addCustomer(Customer customer) {
        em.persist(customer);
        return 0;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return em.createQuery("FROM Customer").getResultList();
    }

    @Override
    public int addShipper(Shipper shipper) {
        em.persist(shipper);
        return 0;
    }

    @Override
    public List<Shipper> getAllShippers() {
        return em.createQuery("FROM Shipper").getResultList();
    }
}
