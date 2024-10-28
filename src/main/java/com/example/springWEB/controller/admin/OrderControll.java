package com.example.springWEB.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderControll {

    @GetMapping("/adminOrder")
    public String getOrder() {
        return "/admin/order/show";
    }
}
