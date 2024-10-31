package com.example.springWEB.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderControll {

    @GetMapping("/adminOrder")
    public String getOrder(Model model) {
        return "/admin/order/show";
    }
}
