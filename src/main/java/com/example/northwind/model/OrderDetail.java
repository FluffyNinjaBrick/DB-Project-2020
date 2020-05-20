package com.example.northwind.model;


import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OrderDetail implements Serializable {

    @Column(name = "ORDER_ID")
    private int orderId;

    @Column(name = "PRODUCT_ID")
    private int  productID;

    public OrderDetail() { }

    public OrderDetail(int orderId, int productID) {
        this.orderId = orderId;
        this.productID = productID;
    }





    //@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "ORDER_ID")
    //private Order order;


}
