package com.example.springWEB.domain;

import java.util.Date;
import java.util.List;

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

    private String receiverName;
    private String receiverAddress;
    private String receiverPhone;
    private String status;

    // order n => 1 users
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    // order 1 => n orderdetail
    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetails;

    private Date dateOrder;

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

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Oders [id=" + id + ", totalPrice=" + totalPrice + ", receiverName=" + receiverName
                + ", receiverAddress=" + receiverAddress + ", receiverPhone=" + receiverPhone + ", status=" + status
                + ", users=" + users + ", orderDetails=" + orderDetails + "]";
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

}
