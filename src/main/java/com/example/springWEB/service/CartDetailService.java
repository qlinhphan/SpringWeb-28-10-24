package com.example.springWEB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.OrderDetail;
import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;
import com.example.springWEB.repository.CartDetailRepository;
import com.example.springWEB.repository.CartRepository;
import com.example.springWEB.repository.OrderDetailRepository;
import com.example.springWEB.repository.ProductsRepository;

@Service
public class CartDetailService {

    private CartDetailRepository cartDetailRepository;
    private OrderDetailRepository orderDetailRepository;
    // private CartRepository cartRepository;

    public CartDetailService(CartDetailRepository cartDetailRepository, OrderDetailRepository orderDetailRepository) {
        this.cartDetailRepository = cartDetailRepository;
        this.orderDetailRepository = orderDetailRepository;
        // this.cartRepository = cartRepository;
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

    public List<CartDetail> findCartDetailFromCart(Cart cart) {
        return this.cartDetailRepository.findCartDetailByCart(cart);
    }

    public void deleteCartDetailByCartt(Cart cart) {
        this.cartDetailRepository.deleteCartDetailByCart(cart);
    }
}
