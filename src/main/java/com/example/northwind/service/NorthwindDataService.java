package com.example.northwind.service;

import com.example.northwind.dao.NorthwindDao;
import com.example.northwind.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NorthwindDataService {

    private final NorthwindDao dao;

    @Autowired
    public NorthwindDataService(@Qualifier("HibernateAccess") NorthwindDao dao) {
        this.dao = dao;
    }

    // --- methods --- //
    public int addProduct(Product p) {
        return dao.addProduct(p);
    }

}
