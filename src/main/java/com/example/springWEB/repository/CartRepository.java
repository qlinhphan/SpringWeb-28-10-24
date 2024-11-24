package com.example.springWEB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.Users;

public interface CartRepository extends JpaRepository<Cart, Long> {

    public Cart findByUsers(Users us);

    public Cart save(Cart cart);

    public void deleteByUsers(Users users);
}
