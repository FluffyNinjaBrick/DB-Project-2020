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

    public int addProduct(Product p, int category_id) { return dao.addProduct(p, category_id); }
    public List<Product> getAllProducts() { return dao.getAllProducts(); }
    public Product getProductById(int product_id) { return dao.getProductById(product_id); }
    public void deleteProductById(int product_id) { dao.deleteProductById(product_id); }


    // ==========  CATEGORY  ========== //

    public int addCategory(Category category) { return dao.addCategory(category); }
    public List<Category> getAllCategories() { return dao.getAllCategories(); }
    public Category getCategoryByID(int category_id) {
        return dao.getCategoryByID(category_id);
    }
    public void deleteCategoryById(int category_id) { dao.deleteCategoryById(category_id);}


    // ==========  CUSTOMER  ========== //

    public List<Customer> getAllCustomers() { return dao.getAllCustomers(); }
    public int addCustomer(Customer c) { return dao.addCustomer(c); }
    public Customer getCustomerById(int customer_id) { return dao.getCustomerById(customer_id); }


    // ==========  SHIPPER  ========== //

    public List<Shipper> getAllShippers() { return dao.getAllShippers(); }
    public int addShipper(Shipper s) { return dao.addShipper(s); }
    public Shipper getShipperById(int shipper_id) { return dao.getShipperById(shipper_id); }


    // ==========  ORDER  ========== //

    public int addOrder(OrderWrapper wrapper) { return dao.addOrder(wrapper); }
    public int addOrderDetails(OrderDetails d) { return dao.addOrderDetails(d); }
    public List<Order> getAllOrders() { return dao.getAllOrders(); }
    public Order getOrder(int order_id) { return dao.getOrder(order_id); }
    public int cancelOrder(int order_id) { return dao.cancelOrder(order_id); }

    public List<OrderDetails> getAllOrderDetails(){ return dao.getAllOrderDetails();}
    public List<OrderDetails> getOrderDetailsByOrderId(int order_id){ return dao.getOrderDetailsByOrderId(order_id);}

}
