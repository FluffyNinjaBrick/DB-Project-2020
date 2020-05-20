package com.example.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

    @EmbeddedId
    private OrderDetail id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ORDERID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("PRODUCTID")
    private Product product;

    private double UnitPrice;
    private int Quantity;
    private double Discount;

    private OrderDetails(){}

    public OrderDetails(@JsonProperty("order") Order order, @JsonProperty("product") Product product, @JsonProperty("unitPrice") double unitPrice,
                        @JsonProperty("quantity") int quantity, @JsonProperty("discount") double discount) {
        this.order = order;
        this.product = product;
        this.id = new OrderDetail(order.getId(),product.getId());
        UnitPrice = unitPrice;
        Quantity = quantity;
        Discount = discount;
    }
}
