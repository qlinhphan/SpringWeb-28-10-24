package com.example.springWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.cart.CartDetail;

public interface CardDetailRepository extends JpaRepository<CartDetail, Long> {
    public CartDetail save(CartDetail cd);
}
