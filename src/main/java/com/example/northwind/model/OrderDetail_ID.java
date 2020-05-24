package com.example.northwind.model;


import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OrderDetail_ID implements Serializable {

    @Column(name = "ORDER_ID")
    private int orderId;

    @Column(name = "PRODUCT_ID")
    private int  productID;

    public OrderDetail_ID() { }

    public OrderDetail_ID(int orderId, int productID) {
        this.orderId = orderId;
        this.productID = productID;
    }

    @Override
    public String toString() { return orderId + " " + productID; }
}
