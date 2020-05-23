package com.example.northwind.dao;

import com.example.northwind.model.Category;
import com.example.northwind.model.Customer;
import com.example.northwind.model.Product;
import com.example.northwind.model.Shipper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.cj.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// this is where the most will need to be done. This is where we'll be implementing add the DB access methods

@Repository("HibernateAccess") // repository here meaning a class that stored data in a DB
public class HibernateAccess implements NorthwindDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public int addProduct(Product product, int category_id) {
        Category category = em.find(Category.class, category_id);
        em.persist(product);
        category.addProduct(product);
        return 0;
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public int addCategory(Category category) {
        em.persist(category);
        return 0;
    }

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public Category getCategoryByID(int category_id) {
        return em.find(Category.class, category_id);
    }

    @Override
    @Transactional
    public int addCustomer(Customer customer) {
        return 0;
    }

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public int addShipper(Shipper shipper) {
        em.persist(shipper);
        return 0;
    }

    @Override
    @Transactional
    public List<Shipper> getAllShippers() {
        return em.createQuery("FROM Shipper").getResultList();
    }
}
