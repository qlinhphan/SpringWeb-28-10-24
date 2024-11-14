package com.example.springWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;

public interface CardRepository extends JpaRepository<Cart, Long> {

    public Cart findByUsers(Users users);

    public Cart save(Cart ca);

}
