package com.example.springWEB.controller.client.profile;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Users;
import com.example.springWEB.service.UserService;

@Controller
public class OverViewControll {

    public UserService userService;

    public OverViewControll(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/overView")
    public String getMethodName(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Users us = this.userService.findUsersByEmail(userDetails.getUsername());
        model.addAttribute("user", us);
        return "/client/profile/overView";
    }

}
