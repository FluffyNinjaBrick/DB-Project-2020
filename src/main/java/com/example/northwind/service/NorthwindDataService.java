package com.example.northwind.service;

import com.example.northwind.dao.NorthwindDao;
import com.example.northwind.model.Category;
import com.example.northwind.model.Customer;
import com.example.northwind.model.Product;
import com.example.northwind.model.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// this is an intermediary between the DAO and the rest controller. We probably won't use it much since we only have
// one DAO, but if we had more this is where we'd pick the DAO

@Service
public class NorthwindDataService {

    private final NorthwindDao dao;

    @Autowired
    public NorthwindDataService(@Qualifier("HibernateAccess") NorthwindDao dao) {
        this.dao = dao;
    }


    // ==========  PRODUCT  ========== //

    @Transactional
    public int addProduct(Product p, int category_id) { return dao.addProduct(p, category_id); }

    @Transactional
    public List<Product> getAllProducts() { return dao.getAllProducts(); }



    // ==========  CATEGORY  ========== //

    @Transactional
    public int addCategory(Category category) { return dao.addCategory(category); }

    @Transactional
    public List<Category> getAllCategories() { return dao.getAllCategories(); }

    @Transactional
    public Category getCategoryByID(int category_id) {
        return dao.getCategoryByID(category_id);
    }



    // ==========  CUSTOMER  ========== //

    @Transactional
    public List<Customer> getAllCustomers() { return dao.getAllCustomers(); }

    @Transactional
    public int addCustomer(Customer c) { return dao.addCustomer(c); }



    // ==========  SHIPPER  ========== //

    @Transactional
    public List<Shipper> getAllShippers() { return dao.getAllShippers(); }

    @Transactional
    public int addShipper(Shipper s) { return dao.addShipper(s); }



}
