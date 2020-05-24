package com.example.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderWrapper {

    private final String orderDate;
    private final String requiredDate;
    private final double freight;
    private final int customerID;
    private final int shipperID;
    private final List<Integer> products;
    private final List<OrderDetails> details;

    public OrderWrapper(@JsonProperty("orderDate") String orderDate,
                        @JsonProperty("requiredDate")String requiredDate,
                        @JsonProperty("freight") double freight,
                        @JsonProperty("customer") int customerID,
                        @JsonProperty("shipper") int shipperID,
                        @JsonProperty("products") List<Integer> products,
                        @JsonProperty("details") List<OrderDetails> details) {
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.freight = freight;
        this.customerID = customerID;
        this.shipperID = shipperID;
        this.products = products;
        this.details = details;
    }

    public Order getOrder() { return new Order(orderDate, requiredDate, freight); }

    public List<OrderDetails> getDetails() { return details; }

    public List<Integer> getProducts() { return products; }

    public int getCustomerID() {
        return customerID;
    }

    public int getShipperID() {
        return shipperID;
    }
}
