package com.example.springWEB.controller.client;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.repository.CartRepository;
import com.example.springWEB.service.CartService;
import com.example.springWEB.service.ProductsService;
import com.example.springWEB.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ItemProduct {

    private ProductsService productsService;
    private UserService userService;
    private CartService cartService;

    public ItemProduct(ProductsService productsService, UserService userService, CartService cartService) {
        this.productsService = productsService;
        this.userService = userService;
        this.cartService = cartService;
    }

    @GetMapping("/detail/product/client/{id}")
    public String getDetailProduct(Model model, @PathVariable long id) {
        Products pro = this.productsService.findProductById(id);
        model.addAttribute("product", pro);
        return "/client/item_product";
    }

    // @GetMapping("/create/product")
    // public String createProduct(Model model) {
    // return "/client/"
    // }

    @PostMapping("/add-product-to-card/{id}")
    public String addProductToCard(Model model, @PathVariable long id,
            @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println("IDproduct: " + id);
        long idProduct = id;
        System.out.println("Email of users: " + userDetails.getUsername());
        String email = userDetails.getUsername();
        this.productsService.addProductToCart(idProduct, email);
        Users user = this.userService.findUsersByEmail(email);
        Cart cart = this.cartService.findCartByUser(user);
        // System.out.println(cart.getSum());
        // int sumCart = cart.getSum();
        // session.setAttribute("sumCart", sumCart);
        return "redirect:/";
    }

}
