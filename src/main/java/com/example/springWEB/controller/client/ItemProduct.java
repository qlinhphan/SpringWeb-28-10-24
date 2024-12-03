package com.example.springWEB.controller.client;

import java.util.Date;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.feedBack;

import com.example.springWEB.service.CartService;
import com.example.springWEB.service.FeedbackService;
import com.example.springWEB.service.ProductsService;
import com.example.springWEB.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ItemProduct {

    private ProductsService productsService;
    private UserService userService;
    private CartService cartService;
    private FeedbackService feedbackService;

    public ItemProduct(ProductsService productsService, UserService userService, CartService cartService,
            FeedbackService feedbackService) {
        this.productsService = productsService;
        this.userService = userService;
        this.cartService = cartService;
        this.feedbackService = feedbackService;
    }

    @GetMapping("/detail/product/client/{id}")
    public String getDetailProduct(Model model, @PathVariable long id, @ModelAttribute("newFeed") feedBack feed) {
        Products pro = this.productsService.findProductById(id);
        model.addAttribute("product", pro);
        return "/client/item_product";
    }

    @PostMapping("/cmt/finish")
    public String cmtFinish(Model model, @ModelAttribute("newFeed") feedBack feed,
            @AuthenticationPrincipal UserDetails userDetails) {
        String content = feed.getContent();
        feedBack feedBack = new feedBack();
        feedBack.setContent(content);
        feedBack.setDate(new Date());
        feedBack.setUser(this.userService.findUsersByEmail(userDetails.getUsername()));
        feedBack.setProduct(feed.getProduct());
        this.feedbackService.savFeedBack(feedBack);
        return "hello";
    }

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
        return "redirect:/";
    }

}
