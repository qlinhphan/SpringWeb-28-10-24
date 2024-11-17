package com.example.springWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    public CartDetail save(CartDetail cd);

    public CartDetail findByCartAndProducts(Cart cart, Products products);
}
