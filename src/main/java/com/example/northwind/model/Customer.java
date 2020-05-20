package com.example.northwind.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMERS")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String CustomerName;
    private String Address;
    private String City;
    private String PostalCode;
    private String Country;
    private String Phone;

    @OneToMany(mappedBy = "customerOrder",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    Set<Order> Orders;

    public Customer() { this.Orders = new HashSet<Order>();}

    public Customer(@JsonProperty("name")String customerName, @JsonProperty("address") String address, @JsonProperty("city") String city,
                    @JsonProperty("postalCode") String postalCode, @JsonProperty("country") String country, String phone) {
        this.CustomerName = customerName;
        this.Address = address;
        this.City = city;
        this.PostalCode = postalCode;
        this.Country = country;
        this.Phone = phone;
        this.Orders = new HashSet<Order>();
    }

    public int getCustomerID() {
        return id;
    }

    public void setCustomerID(int customerID) {
        id = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
