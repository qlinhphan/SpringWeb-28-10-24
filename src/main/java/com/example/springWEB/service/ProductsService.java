package com.example.springWEB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;
import com.example.springWEB.repository.CartDetailRepository;
import com.example.springWEB.repository.CartRepository;
import com.example.springWEB.repository.ProductsRepository;

@Service
public class ProductsService {

    private ProductsRepository productsRepository;
    private UserService userService;
    private CartRepository cartRepository;
    private CartDetailRepository cartDetailRepository;

    public ProductsService(ProductsRepository productsRepository, UserService userService,
            CartRepository cartRepository, CartDetailRepository cartDetailRepository) {
        this.productsRepository = productsRepository;
        this.userService = userService;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
    }

    public Products saveProduct(Products pro) {
        return this.productsRepository.save(pro);
    }

    public List<Products> findAllProducts() {
        return this.productsRepository.findAll();
    }

    public Products findProductById(long id) {
        return this.productsRepository.findById(id);
    }

    public void DeleteProductById(long id) {
        this.productsRepository.deleteById(id);
    }

    public void addProductToCart(String email, long idProduct) {
        Users us = this.userService.findUsersByEmail(email);

        if (us != null) {
            Cart ca = this.cartRepository.findByUsers(us);

            if (ca == null) {
                Cart newCart = new Cart();
                newCart.setSum(1);
                newCart.setUsers(us);
                ca = this.cartRepository.save(newCart);
            }

            Products pr = this.productsRepository.findById(idProduct);
            if (pr != null) {
                CartDetail cd = new CartDetail();
                cd.setPrice((long) pr.getPrice());
                cd.setQuantity(1);
                cd.setCart(ca);
                cd.setProducts(pr);
                this.cartDetailRepository.save(cd);
            }

        }
    }

}
