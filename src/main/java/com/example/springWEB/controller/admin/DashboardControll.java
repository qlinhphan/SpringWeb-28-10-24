package com.example.springWEB.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardControll {

    @GetMapping("/adminDash")
    public String adminDash() {
        return "admin/dasboard/show";
    }
}
