package com.example.springWEB.controller.client.profile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OverViewControll {

    @GetMapping("/overView")
    public String getMethodName(Model model) {
        return "/client/profile/overView";
    }

}
