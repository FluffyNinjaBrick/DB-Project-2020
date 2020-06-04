package com.example.northwind.dao;

import com.example.northwind.model.*;

import java.util.List;

public interface NorthwindDao {

    // ==========  PRODUCT  ========== //
    int addProduct(Product product, int category_id);
    List<Product> getAllProducts();
    Product getProductById(int id);
    void deleteProductById(int id);

    // ==========  CATEGORY  ========== //
    int addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryByID(int id);
    void deleteCategoryById(int id);


    // ==========  CUSTOMER  ========== //
    int addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);


    // ==========  SHIPPER  ========== //
    int addShipper(Shipper shipper);
    List<Shipper> getAllShippers();
    Shipper getShipperById(int id);


    // ==========  ORDER  ========== //
    int addOrder(OrderWrapper o);
    int addOrderDetails(OrderDetails d);
    List<Order> getAllOrders();
    Order getOrder(int id);
    int cancelOrder(int order_id);

    // ======  ORDER DETAILS  ====== //
    List<OrderDetails> getAllOrderDetails();
    List<OrderDetails> getOrderDetailsByOrderId(int id);
}
