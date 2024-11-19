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
import com.example.springWEB.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class ProductsService {

    private ProductsRepository productsRepository;
    private UserService userService;
    private UserRepository userRepository;
    private CartDetailRepository cartDetailRepository;
    private CartRepository cartRepository;

    public ProductsService(ProductsRepository productsRepository, UserService userService,
            UserRepository userRepository, CartDetailRepository cartDetailRepository, CartRepository cartRepository) {
        this.productsRepository = productsRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.cartRepository = cartRepository;

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

    public void addProductToCart(long idProduct, String email) {
        // loi ra 1 nguoi dung
        Users user = this.userRepository.findByEmail(email);

        // neu nguoi dung nay ton tai
        if (user != null) {
            int sumCart;
            // kiem tra xem nguoi dung co cart chua?
            Cart cart = this.cartRepository.findByUsers(user);
            if (cart == null) {
                sumCart = 0;
            } else {
                sumCart = cart.getSum();
            }
            // neu chua thi tao cart moi
            if (cart == null) {
                Cart newCart = new Cart();
                newCart.setSum(sumCart);
                newCart.setUsers(user);
                cart = this.cartRepository.save(newCart);
            }

            sumCart += 1;
            cart.setSum(sumCart);
            this.cartRepository.save(cart);

            Products products = this.productsRepository.findById(idProduct);
            if (products != null) {
                int quantityCartDetail;
                CartDetail currentCartDetail = this.cartDetailRepository.findByCartAndProducts(cart, products);
                if (currentCartDetail == null) {
                    quantityCartDetail = 0;
                    CartDetail cartDetail = new CartDetail();
                    cartDetail.setPrice((long) products.getPrice());
                    cartDetail.setQuantity(quantityCartDetail);
                    cartDetail.setCart(cart);
                    cartDetail.setProducts(products);
                    currentCartDetail = this.cartDetailRepository.save(cartDetail);
                }
                quantityCartDetail = currentCartDetail.getQuantity();
                quantityCartDetail += 1;
                currentCartDetail.setQuantity(quantityCartDetail);
                this.cartDetailRepository.save(currentCartDetail);
            }
        }
    }

}
