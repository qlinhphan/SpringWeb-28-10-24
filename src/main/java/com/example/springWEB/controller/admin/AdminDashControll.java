package com.example.springWEB.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminDashControll {

    @GetMapping("/admin")
    public String getMethodName(Model model) {
        return "/admin/DashBoard";
    }

}
