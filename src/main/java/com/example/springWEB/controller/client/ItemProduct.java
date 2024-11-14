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
import com.example.springWEB.service.ProductsService;

@Controller
public class ItemProduct {

    private ProductsService productsService;

    public ItemProduct(ProductsService productsService) {
        this.productsService = productsService;
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
        long idProduct = id;
        String email = userDetails.getUsername();
        System.out.println("EMAIL: " + email);
        this.productsService.addProductToCart(email, idProduct);
        return "redirect:/";
    }

}
