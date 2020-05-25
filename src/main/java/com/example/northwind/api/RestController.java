package com.example.northwind.api;

import com.example.northwind.model.*;
import com.example.northwind.service.NorthwindDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final NorthwindDataService dataService;

    @Autowired
    public RestController(NorthwindDataService dataService) {
        this.dataService = dataService;
    }



    // ==========  PRODUCT  ========== //

    @PostMapping("/product/{category_id}")
    public void addProduct(@RequestBody Product p, @PathVariable int category_id) {
        p.setCategory(dataService.getCategoryByID(category_id));
        dataService.addProduct(p, category_id);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() { return dataService.getAllProducts(); }

    @GetMapping("/product/{product_id}")
    public Product getProductById(@PathVariable int product_id) { return dataService.getProductById(product_id);}

    @DeleteMapping("/product/{product_id}")
    public void deleteProductById(@PathVariable int product_id) { dataService.deleteProductById(product_id); }


    // ==========  CATEGORY  ========== //

    @PostMapping("/category")
    public void addCategory(@RequestBody Category c) { dataService.addCategory(c); }

    @GetMapping("/category")
    public List<Category> getAllCategories() { return dataService.getAllCategories(); }

    @GetMapping("/category/{category_id}")
    public Category getCategoryByID(@PathVariable int category_id) { return dataService.getCategoryByID(category_id); }

    @DeleteMapping("/category/{category_id}")
    public void deleteCategoryById(@PathVariable int category_id) { dataService.deleteCategoryById(category_id);}


    // ==========  CUSTOMER  ========== //

    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer c) { dataService.addCustomer(c); }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() { return dataService.getAllCustomers(); }

    @GetMapping("/customer/{customer_id}")
    public Customer getCustomerById(@PathVariable int customer_id) { return dataService.getCustomerById(customer_id); }


    // ==========  SHIPPER  ========== //

    @PostMapping("/shipper")
    public void addShipper(@RequestBody Shipper s) { dataService.addShipper(s); }

    @GetMapping("/shipper")
    public List<Shipper> getAllShippers() { return dataService.getAllShippers(); }

    @GetMapping("/shipper/{shipper_id}")
    public Shipper getShipperById(@PathVariable int shipper_id) { return dataService.getShipperById(shipper_id);}


    // ==========  ORDER  ========== //

    @PostMapping("/order")
    public void addOrder(@RequestBody OrderWrapper wrapper) {
        // persist the order so that it gains an ID
        Order o = wrapper.getOrder();
        o.setCustomer(dataService.getCustomerById(wrapper.getCustomerID()));
        o.setShipper(dataService.getShipperById(wrapper.getShipperID()));
        dataService.addOrder(o);

        // add the missing data to the products
        List<Integer> products = wrapper.getProducts();
        List<OrderDetails> details = wrapper.getDetails();
        Product curr_product;
        OrderDetails curr_details;
        for (int i = 0; i < products.size(); i++) {
            curr_product = dataService.getProductById(products.get(i));
            curr_details = details.get(i);
            curr_details.setProduct(curr_product);
            curr_details.setUnitPrice(curr_product.getUnitPrice());
            curr_details.setOrder(o);
            curr_details.setId(new OrderDetail_ID(o.getId(), curr_product.getId()));
        }

        // persist all the order details
        for(OrderDetails d: details) dataService.addOrderDetails(d);
    }

    @GetMapping("/order")
    public List<Order> getAllOrders() { return dataService.getAllOrders();}

    @GetMapping("/order/{order_id}")
    public Order getOrder(@PathVariable int order_id) { return dataService.getOrder(order_id); }

    @PostMapping("/order/{order_id}/cancel")
    public void cancelOrder(@PathVariable int order_id) {
        dataService.cancelOrder(order_id);
    }


    // ==========  ORDER DETAILS  ========== //

    @GetMapping("/orderDetails")
    public List<OrderDetails> getAllOrderDetails() { return dataService.getAllOrderDetails(); }

    @GetMapping("/orderDetails/{order_id}")
    public List<OrderDetails> getOrderDetailsByOrderId(@PathVariable int order_id) {
        return dataService.getOrderDetailsByOrderId(order_id);
    }

    @PostMapping("/orderDetails/{order_id}/{product_id}")
    public void addOrderDetailToOrder(@PathVariable int order_id,
                                      @PathVariable int product_id,
                                      @RequestBody OrderDetails orderDetails) {
        Product p = dataService.getProductById(product_id);
        Order o = dataService.getOrder(order_id);
        orderDetails.setOrder(o);
        orderDetails.setProduct(p);
        orderDetails.setUnitPrice(p.getUnitPrice());
        orderDetails.setId(new OrderDetail_ID(o.getId(), p.getId()));
        dataService.addOrderDetails(orderDetails);
    }
}
