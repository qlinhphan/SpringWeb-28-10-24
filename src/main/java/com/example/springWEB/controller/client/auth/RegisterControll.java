package com.example.springWEB.controller.client.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.dto.RegisterDTO;
import com.example.springWEB.repository.RolesRepository;
import com.example.springWEB.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/register")
    public String registerf(Model model, @ModelAttribute("regisNew") RegisterDTO re,
            RedirectAttributes redirectAttributes) {
        Users kq = new Users();
        kq = this.userService.registerDtoToUser(re);
        kq.setRoles(this.rolesRepository.findByName("User"));
        String pass = re.getPassword();
        String repass = re.getRepeatPassword();
        boolean hasER = false;
        if (!pass.equals(repass)) {
            // model.addAttribute("showMess", true);
            redirectAttributes.addFlashAttribute("showMess", true);
            hasER = true;
            System.out.println("error repass");
        }

        if (this.userService.existsByEmailUser(re.getEmail())) {
            // model.addAttribute("emailExist", true);
            redirectAttributes.addFlashAttribute("emailExist", true);
            hasER = true;
            System.out.println("email is exist");
        }

        // if (model.containsAttribute("showMess") ||
        // model.containsAttribute("emailExist")) {
        // return "/client/auth/register";
        // }
        if (hasER) {
            return "redirect:/register";
        }
        System.out.println(kq);
        this.userService.createUser(kq);
        System.out.println("this is saved");
        return "hello";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "/client/auth/login";
    }

    @GetMapping("/access-deny")
    public String getMethodName(Model model) {
        return "/client/auth/access-deny";
    }

    // @PostMapping("/login")
    // public String registerF(Model model, @ModelAttribute("regisNew") RegisterDTO
    // re,
    // RedirectAttributes redirectAttributes) {
    // System.out.println(re);
    // Users kq = new Users();
    // kq = this.userService.registerDtoToUser(re);
    // kq.setRoles(this.rolesRepository.findByName("User"));
    // String pass = re.getPassword();
    // String repass = re.getRepeatPassword();
    // boolean hasER = false;
    // if (!pass.equals(repass)) {
    // // model.addAttribute("showMess", true);
    // redirectAttributes.addFlashAttribute("showMess", true);
    // hasER = true;
    // System.out.println("error repass");
    // }

    // if (this.userService.existsByEmailUser(re.getEmail())) {
    // // model.addAttribute("emailExist", true);
    // redirectAttributes.addFlashAttribute("emailExist", true);
    // hasER = true;
    // System.out.println("email is exist");
    // }

    // // if (model.containsAttribute("showMess") ||
    // // model.containsAttribute("emailExist")) {
    // // return "/client/auth/register";
    // // }
    // if (hasER) {
    // return "redirect:/register";
    // }

    // this.userService.createUser(kq);
    // return "/client/auth/login";
    // }

}
