package com.example.northwind.api;

import com.example.northwind.model.Product;
import com.example.northwind.service.NorthwindDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
