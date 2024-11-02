package com.example.springWEB.controller.client.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Roles;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.dto.RegisterDTO;
import com.example.springWEB.repository.RolesRepository;
import com.example.springWEB.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegisterControll {

    private UserService userService;
    private RolesRepository rolesRepository;

    public RegisterControll(UserService userService, RolesRepository rolesRepository) {
        this.userService = userService;
        this.rolesRepository = rolesRepository;
    }

    @GetMapping("/register")
    public String register(Model model, @ModelAttribute("regisNew") RegisterDTO re) {
        return "/client/auth/register";
    }

    @PostMapping("/registerF")
    public String registerF(Model model, @ModelAttribute("regisNew") RegisterDTO re) {
        System.out.println(re);
        Users kq = new Users();
        kq = this.userService.registerDtoToUser(re);
        kq.setRoles(this.rolesRepository.findByName("User"));
        String pass = re.getPassword();
        String repass = re.getRepeatPassword();
        if (!pass.equals(repass)) {
            System.out.println("Not Save, Because repeat-Pass and Pass are different");
            return "client/auth/noSave";
        }
        this.userService.createUser(kq);
        return "hello";
    }

}
