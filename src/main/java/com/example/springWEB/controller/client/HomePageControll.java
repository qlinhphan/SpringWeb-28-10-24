package com.example.springWEB.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Products;
import com.example.springWEB.service.ProductsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomePageControll {

    private ProductsService productsService;

    public HomePageControll(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("")
    public String homepage(Model model) {
        List<Products> ds = this.productsService.findAllProducts();
        model.addAttribute("products", ds);
        return "/client/show";
    }

} // test
