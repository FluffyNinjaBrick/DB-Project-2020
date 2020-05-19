package com.example.northwind.dao;

import com.example.northwind.model.Product;
import org.springframework.stereotype.Repository;

@Repository("HibernateAccess") // repository here meaning a class that stored data in a DB
public class HibernateAccess implements NorthwindDao {

    @Override
    public int addProduct(Product product) {
        System.out.println("Everything hooked up correctly");
        // TODO - this is where the actual DB logic is gonna go,
        //  for now I'm just doing the API so I'm leaving this blank
        return 0;
    }
}
