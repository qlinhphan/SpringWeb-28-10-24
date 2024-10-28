package com.example.springWEB.domain;

import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Oders")
public class Oders {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private double totalPrice;
    // userId

    // order n => 1 users
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    // order 1 => n orderdetail
    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Oders [id=" + id + ", totalPrice=" + totalPrice + "]";
    }

}
