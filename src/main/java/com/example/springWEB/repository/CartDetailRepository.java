package com.example.springWEB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    public CartDetail save(CartDetail cd);

    public CartDetail findByCartAndProducts(Cart cart, Products products);

    public List<CartDetail> findByCart(Cart cart);

    public List<CartDetail> findAll();

    public CartDetail findById(long id);

    public void deleteById(long id);

    public List<CartDetail> findCartDetailByCart(Cart cart);

    public void deleteCartDetailByCart(Cart cart);

}
