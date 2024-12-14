package com.example.springWEB.controller.client.profile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.dto.ChangePassDTO;
import com.example.springWEB.service.UserService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OverViewControll {

    public UserService userService;
    public ServletContext servletContext;
    public PasswordEncoder passwordEncoder;

    public OverViewControll(UserService userService, ServletContext servletContext, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.servletContext = servletContext;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/overView")
    public String getMethodName(Model model, @AuthenticationPrincipal UserDetails userDetails,
            @ModelAttribute("editInf") Users user, @ModelAttribute("changePass") ChangePassDTO changePassDTO) {
        Users us = this.userService.findUsersByEmail(userDetails.getUsername());
        System.out.println("LINK IMAGE: " + us.getAvatar());
        model.addAttribute("user", us);
        return "/client/profile/overView";
    }

    @PostMapping("/edit/inf")
    public String get(Model model, @ModelAttribute("editInf") Users user,
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam("fileName") MultipartFile file) {
        Users us = this.userService.findUsersByEmail(userDetails.getUsername());
        us.setAddress(user.getAddress());
        us.setFullname(user.getFullname());
        us.setEmail(user.getEmail());
        us.setPhone(user.getPhone());
        String link = "";
        try {
            byte[] bytes;
            bytes = file.getBytes();

            String rootPath = this.servletContext.getRealPath("/resources/images");

            File dir = new File(rootPath + File.separator + "/avatar");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            File server = new File(dir.getAbsolutePath() + File.separator
                    + file.getOriginalFilename());

            link = file.getOriginalFilename();

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(server));
            stream.write(bytes);
            stream.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        us.setAvatar(link);
        this.userService.saveUser(us);
        return "redirect:/overView";
    }

    @PostMapping("/change")
    public String changePasss(Model model, @ModelAttribute("changePass") ChangePassDTO changePassDTO,
            @AuthenticationPrincipal UserDetails userDetails, HttpSession session) {
        Users us = this.userService.findUsersByEmail(userDetails.getUsername());
        String dataPass = us.getPassword();
        String curPass = changePassDTO.getCurrentPass();
        System.out.println("MAT KHAU DA NHAP: " + changePassDTO.getCurrentPass());
        if (this.passwordEncoder.matches(curPass, dataPass)) {
            System.out.println("MAT KHAU DUNG"); // so sanh voi pass duoi csdl
            String newPass = changePassDTO.getNewPass();
            String rePass = changePassDTO.getRePass();
            if (newPass.equals(rePass)) {
                System.out.println("2 MAT KHAU DA KHOP NHAU");
                us.setPassword(this.passwordEncoder.encode(changePassDTO.getNewPass()));
                this.userService.saveUser(us);
            } else {
                System.out.println("2 MAT KHAU KO KHOP NHAU");
                session.setAttribute("ers", "Mat Khau khong khop");
            }
        } else {
            System.out.println("MAT KHAU SAI");
            session.setAttribute("er", "Mat Khau Sai");
        }
        return "redirect:/overView";
    }

}
