package com.example.northwind.api;

import com.example.northwind.model.*;
import com.example.northwind.service.NorthwindDataService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// this is where we define the actual API endpoints, which clients can access via HTTP requests

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
    public List<Product> getAllProducts() {
        return dataService.getAllProducts();
    }

    @GetMapping("/product/{product_id}")
    public Product getProductById(@PathVariable int product_id){ return dataService.getProductById(product_id);}

    @DeleteMapping("/product/{product_id}")
    public void deleteProductById(@PathVariable int product_id){ dataService.deleteProductById(product_id);}

    // ==========  CATEGORY  ========== //

    @PostMapping("/category")
    public void addCategory(@RequestBody Category c){
        dataService.addCategory(c);
    }

    @GetMapping("/category")
    public List<Category> getAllCategories(){
        return dataService.getAllCategories();
    }

    @GetMapping("/category/{category_id}")
    public Category getCategoryByID(@PathVariable int category_id) {
        return dataService.getCategoryByID(category_id);
    }

    @DeleteMapping("/category/{category_id}")
    public void deleteCategoryById(@PathVariable int category_id) { dataService.deleteCategoryById(category_id);}

    // ==========  CUSTOMER  ========== //

    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer c) { dataService.addCustomer(c); }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() { return dataService.getAllCustomers(); }

    @GetMapping("/customer/{customer_id}")
    public Customer getCustomerById(@PathVariable int customer_id){ return dataService.getCustomerById(customer_id); }

    // ==========  SHIPPER  ========== //

    @PostMapping("/shipper")
    public void addShipper(@RequestBody Shipper s) { dataService.addShipper(s); }

    @GetMapping("/shipper")
    public List<Shipper> getAllShippers(){
        return dataService.getAllShippers();
    }

    @GetMapping("/shipper/{shipper_id}")
    public Shipper getShipperById(@PathVariable int shipper_id) { return dataService.getShipperById(shipper_id);}
}
