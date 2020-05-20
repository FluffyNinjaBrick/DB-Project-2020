package com.example.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SHIPPERS")
public class Shipper implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String CompanyName;
    private String Phone;

    @OneToMany(mappedBy = "shipperOrder",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    Set<Order> Orders;

    public Shipper(){this.Orders = new HashSet<Order>();}

    public Shipper(@JsonProperty("name") String companyName, @JsonProperty("phone") String phone) {
        this.CompanyName = companyName;
        this.Phone = phone;
        this.Orders = new HashSet<Order>();
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
