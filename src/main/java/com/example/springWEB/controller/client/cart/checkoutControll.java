package com.example.springWEB.controller.client.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;

@Controller
public class checkoutControll {

    @GetMapping("/checkout")
    public String checkout(Model model) {
        return "/client/cart/checkout";
    }

}
