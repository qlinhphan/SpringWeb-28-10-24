package com.example.springWEB.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemProduct {

    @GetMapping("/detail/product/client/{id}")
    public String getDetailProduct(Model model, @PathVariable long id) {
        return "/client/item_product";
    }

    // @GetMapping("/create/product")
    // public String createProduct(Model model) {
    // return "/client/"
    // }

}
