package com.example.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

    @EmbeddedId
    private OrderDetail_ID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ORDERID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("PRODUCTID")
    private Product product;

    private double UnitPrice;
    private int Quantity;
    private double Discount;

    public OrderDetails() {}

    public OrderDetails(@JsonProperty("order") Order order,
                        @JsonProperty("product") Product product,
                        @JsonProperty("unitPrice") double unitPrice,
                        @JsonProperty("quantity") int quantity,
                        @JsonProperty("discount") double discount) {
        this.order = order;
        this.product = product;
        this.id = new OrderDetail_ID(0,0);
        this.UnitPrice = unitPrice;
        this.Quantity = quantity;
        this.Discount = discount;
    }

    public OrderDetails(@JsonProperty("unitPrice") double unitPrice,
                        @JsonProperty("quantity") int quantity,
                        @JsonProperty("discount") double discount) {
        this.id = new OrderDetail_ID(0,0);
        this.UnitPrice = unitPrice;
        this.Quantity = quantity;
        this.Discount = discount;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(OrderDetail_ID id) {
        this.id = id;
    }

    public int getOrder() {
        return order.getId();
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getProduct() {
        return product.getId();
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }
}
