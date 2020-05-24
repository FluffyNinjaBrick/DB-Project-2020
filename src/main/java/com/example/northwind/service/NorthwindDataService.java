package com.example.northwind.service;

import com.example.northwind.dao.NorthwindDao;
import com.example.northwind.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

    @Transactional
    public Product getProductById(int product_id) { return dao.getProductById(product_id); }

    @Transactional
    public void deleteProductById(int product_id) { dao.deleteProductById(product_id); }


    // ==========  CATEGORY  ========== //

    @Transactional
    public int addCategory(Category category) { return dao.addCategory(category); }

    @Transactional
    public List<Category> getAllCategories() { return dao.getAllCategories(); }

    @Transactional
    public Category getCategoryByID(int category_id) {
        return dao.getCategoryByID(category_id);
    }

    @Transactional
    public void deleteCategoryById(int category_id) { dao.deleteCategoryById(category_id);}


    // ==========  CUSTOMER  ========== //

    @Transactional
    public List<Customer> getAllCustomers() { return dao.getAllCustomers(); }

    @Transactional
    public int addCustomer(Customer c) { return dao.addCustomer(c); }

    @Transactional
    public Customer getCustomerById(int customer_id) { return dao.getCustomerById(customer_id); }



    // ==========  SHIPPER  ========== //

    @Transactional
    public List<Shipper> getAllShippers() { return dao.getAllShippers(); }

    @Transactional
    public int addShipper(Shipper s) { return dao.addShipper(s); }

    @Transactional
    public Shipper getShipperById(int shipper_id) { return dao.getShipperById(shipper_id); }



    // ==========  ORDER  ========== //

    public int addOrder(Order o) { return dao.addOrder(o); }
    public int addOrderDetails(OrderDetails d) { return dao.addOrderDetails(d); }

}
