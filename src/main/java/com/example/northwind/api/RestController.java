package com.example.northwind.api;

import com.example.northwind.model.*;
import com.example.northwind.service.NorthwindDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public void addProduct(@RequestBody Product p) {
        dataService.addProduct(p);
    }

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
