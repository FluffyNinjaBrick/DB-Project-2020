package com.example.northwind.service;

import com.example.northwind.dao.NorthwindDao;
import com.example.northwind.model.Category;
import com.example.northwind.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

    // --- methods --- //
    public int addProduct(Product p) {
        return dao.addProduct(p);
    }

    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    public int addCategory(Category category){return dao.addCategory(category);}

    public List<Category> getAllCategories(){return dao.getAllCategories();}

}
