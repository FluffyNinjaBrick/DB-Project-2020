package com.example.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime OrderDate;
    private LocalDateTime RequiredDate;
    private LocalDateTime ShippedDate;
    private double Freight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName ="id", nullable = false)
    Customer customerOrder;




    //@Transient
    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Order(){}

    public Order(@JsonProperty("orderDate") String orderDate, @JsonProperty("requiredDate")String requiredDate, @JsonProperty("freight") double freight) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.OrderDate = LocalDateTime.parse(orderDate,formatter);
        this.RequiredDate = LocalDateTime.parse(requiredDate,formatter);
        this.Freight = freight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        OrderDate = orderDate;
    }

    public LocalDateTime getRequiredDate() {
        return RequiredDate;
    }

    public void setRequiredDate(LocalDateTime requiredDate) {
        RequiredDate = requiredDate;
    }

    public LocalDateTime getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(LocalDateTime shippedDate) {
        ShippedDate = shippedDate;
    }

    public double getFreight() {
        return Freight;
    }

    public void setFreight(double freight) {
        Freight = freight;
    }

    //
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
//

}
