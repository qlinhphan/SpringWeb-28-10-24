package com.example.springWEB.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductControll {

    @GetMapping("/adminProduct")
    public String adminDash(Model model) {
        return "/admin/product/show";
    }

    @GetMapping("/create/product")
    public String createProduct(Model model) {
        return "/admin/product/create";
    }

}
