package com.example.springWEB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;
import com.example.springWEB.repository.CardDetailRepository;
import com.example.springWEB.repository.CardRepository;
import com.example.springWEB.repository.ProductsRepository;

@Service
public class ProductsService {
    private CardRepository cardRepository;
    private CardDetailRepository cardDetailRepository;
    private ProductsRepository productsRepository;
    private UserService userService;

    public ProductsService(com.example.springWEB.repository.CardRepository cardRepository,
            CardDetailRepository cardDetailRepository, ProductsRepository productsRepository, UserService userService) {
        this.cardRepository = cardRepository;
        this.cardDetailRepository = cardDetailRepository;
        this.productsRepository = productsRepository;
        this.userService = userService;
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

        // find user by email
        Users us = this.userService.findUsersByEmail(email);

        // if find user success
        if (us != null) {

            // check user's card
            Cart cart = this.cardRepository.findByUsers(us);

            // if user is not cart -> create cart
            if (cart == null) {
                Cart newCart = new Cart();
                newCart.setSum(1);
                newCart.setUsers(us);
                cart = this.cardRepository.save(newCart);
            }

            Products p = this.productsRepository.findById(idProduct);

            if (p != null) {
                CartDetail cd = new CartDetail();
                cd.setPrice((long) p.getPrice());
                cd.setQuantity(1);
                cd.setCart(cart);
                cd.setProducts(p);
                this.cardDetailRepository.save(cd);
            }

        }
    }

}
