package com.example.springWEB.service;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.repository.CartRepository;

@Service
public class CartService {

    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart findCartByUser(Users us) {
        return this.cartRepository.findByUsers(us);
    }

    public Cart savaCart(Cart cart) {
        return this.cartRepository.save(cart);
    }
}
