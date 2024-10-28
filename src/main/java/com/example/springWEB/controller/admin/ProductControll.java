package com.example.springWEB.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductControll {

    @GetMapping("/adminProduct")
    public String adminDash(Model model) {
        return "/admin/product/show";
    }
}
