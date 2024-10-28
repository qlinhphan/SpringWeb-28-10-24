package com.example.springWEB.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;

@Controller
public class HomePageControll {

    @GetMapping("/homePage/client")
    public String homepage(Model model) {
        return "/client/show";
    }

}
