package com.example.springWEB.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_Details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long quantity;
    private double price;

    // orderDetail n => 1 order
    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Oders orders;

    // orderDetail n => 1 product
    @ManyToOne
    @JoinColumn(name = "products_id")
    private Products products;

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Oders getOrders() {
        return orders;
    }

    public void setOrders(Oders orders) {
        this.orders = orders;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderDetail [quantity=" + quantity + ", price=" + price + "]";
    }

}
