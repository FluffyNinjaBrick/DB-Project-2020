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

    @PostMapping("/product")
    public void addProduct(@RequestHeader(value = "product") Product p, @RequestHeader(value="category") int category_id) {
        System.out.println("controller");
        dataService.addProduct(p,category_id);}

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return dataService.getAllProducts();
    }

    @PostMapping("/category")
    public void addCategory(@RequestBody Category c){
        dataService.addCategory(c);
    }

    @GetMapping("/category")
    public List<Category> getAllCategories(){
        return dataService.getAllCategories();
    }
}
