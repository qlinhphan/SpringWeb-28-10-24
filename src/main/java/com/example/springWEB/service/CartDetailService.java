package com.example.springWEB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;
import com.example.springWEB.repository.CartDetailRepository;
import com.example.springWEB.repository.CartRepository;
import com.example.springWEB.repository.ProductsRepository;

@Service
public class CartDetailService {

    private CartDetailRepository cartDetailRepository;

    public CartDetailService(CartDetailRepository cartDetailRepository) {
        this.cartDetailRepository = cartDetailRepository;
    }

    public List<CartDetail> findAllCartDetail() {
        return this.cartDetailRepository.findAll();
    }

    public List<CartDetail> findCartDetailByCart(Cart cart) {
        return this.cartDetailRepository.findByCart(cart);
    }

    public void deleteCartDetailById(long id) {
        this.cartDetailRepository.deleteById(id);
    }

    public CartDetail findCartDetailById(long id) {
        return this.cartDetailRepository.findById(id);
    }
}
