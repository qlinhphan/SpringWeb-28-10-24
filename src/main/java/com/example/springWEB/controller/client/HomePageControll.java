package com.example.springWEB.controller.client;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.service.CartDetailService;
import com.example.springWEB.service.CartService;
import com.example.springWEB.service.ProductsService;
import com.example.springWEB.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomePageControll {

    private ProductsService productsService;
    private UserService userService;
    private CartService cartService;
    private CartDetailService cartDetailService;

    public HomePageControll(ProductsService productsService, UserService userService, CartService cartService) {
        this.productsService = productsService;
        this.userService = userService;
        this.cartService = cartService;
    }

    @GetMapping("")
    public String homepage(Model model, @AuthenticationPrincipal UserDetails userDetails, HttpSession session) {
        List<Products> ds = this.productsService.findAllProducts();
        model.addAttribute("products", ds);
        String email = userDetails.getUsername();
        Users users = this.userService.findUsersByEmail(email);
        Cart cart = this.cartService.findCartByUser(users);
        int sumCart = 0;
        if (cart == null) {
            session.setAttribute("sumCart", sumCart);
            return "/client/show";
        }
        sumCart = cart.getSum();
        session.setAttribute("SumCarts", sumCart);
        return "/client/show";
    }

} // test
