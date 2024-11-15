package com.example.springWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

    public Cart findByUsers(Users us);

    public Cart save(Cart ca);
}
