package com.example.springWEB.domain;

import java.util.List;

import com.example.springWEB.domain.cart.CartDetail;
import com.example.springWEB.domain.cart.feedBack;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Products {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String name;
    private double price;
    private String image;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String detailDes;

    private String shortDes;
    private long quantity; // lg hang con lai
    private long sold; // lg hang da ban
    private String factory; // nha sx
    private String target; // nhu cau sd

    // product 1 -> n cart_detail
    @OneToMany(mappedBy = "products")
    private List<CartDetail> cartDetail;

    // product 1 => n orderDetail
    // vì 1 chi tiết đơn hàng thì mình cần biết nó gồm những sản phẩm nào, và điều
    // ngược lại thì ko nhất thiết cần phải biết

    // product n => 1 factory

    // pro 1 -> n feed
    @OneToMany(mappedBy = "product")
    private List<feedBack> feed;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Products [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", detailDes="
                + detailDes + ", shortDes=" + shortDes + ", quantity=" + quantity + ", sold=" + sold + ", factory="
                + factory + ", target=" + target + "]";
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetailDes() {
        return detailDes;
    }

    public void setDetailDes(String detailDes) {
        this.detailDes = detailDes;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }

    // public String getFactory() {
    // return factory;
    // }

    // public void setFactory(String factory) {
    // this.factory = factory;
    // }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<CartDetail> getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(List<CartDetail> cartDetail) {
        this.cartDetail = cartDetail;
    }

}
