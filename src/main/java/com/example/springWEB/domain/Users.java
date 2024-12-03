package com.example.springWEB.domain;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.feedBack;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Users")
public class Users {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String email;
    private String password;
    private String fullname;
    private String address;
    private String phone;
    private String avatar;
    // private String content;
    // private Date date;

    // roleId
    // users n -> 1 roles
    @ManyToOne
    @JoinColumn(name = "roles_id") // user la chu nen su dung joincolumn voi name = "tenduoi_id"
    private Roles roles;

    // users 1 => n orders
    @OneToMany(mappedBy = "users")
    private List<Oders> orders;

    // users 1 -> 1 cart
    @OneToOne(mappedBy = "users")
    private Cart cart;

    // 1 user -> n feed
    @OneToMany(mappedBy = "user")
    private List<feedBack> feed;

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<Oders> getOrders() {
        return orders;
    }

    public void setOrders(List<Oders> orders) {
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Users [id=" + id + ", email=" + email + ", password=" + password + ", fullname=" + fullname
                + ", address=" + address + ", phone=" + phone + ", avatar=" + avatar + "]";
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    // public String getContent() {
    // return content;
    // }

    // public void setContent(String content) {
    // this.content = content;
    // }

    // public Date getDate() {
    // return date;
    // }

    // public void setDate(Date date) {
    // this.date = date;
    // }

}
