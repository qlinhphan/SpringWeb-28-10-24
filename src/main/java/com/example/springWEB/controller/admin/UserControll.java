package com.example.springWEB.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.Users;
import com.example.springWEB.service.RolesService;
import com.example.springWEB.service.UserService;

import jakarta.servlet.ServletContext;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserControll {
    private final ServletContext servletContext;
    private UserService userService;
    private RolesService rolesService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserControll(UserService userService, ServletContext servletContext, RolesService rolesService,
            PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.servletContext = servletContext;
        this.rolesService = rolesService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/create/user")
    public String createUser(Model model, @ModelAttribute("newUser") Users us) {
        return "/admin/user/create";
    }

    @PostMapping("/create/user/finish")
    public String postMethodName(Model model, @ModelAttribute("newUser") Users us,
            @RequestParam("fileName") MultipartFile file) {
        String kq = us.getRoles().getName();
        System.out.println("Roles: " + kq);
        String linkImage = "";
        try {
            byte[] bytes;
            bytes = file.getBytes();

            String rootPath = this.servletContext.getRealPath("/resources/images");

            File dir = new File(rootPath + File.separator + "/avatar");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            File server = new File(dir.getAbsolutePath() + File.separator + System.currentTimeMillis() + "-"
                    + file.getOriginalFilename());

            linkImage = System.currentTimeMillis() + "-"
                    + file.getOriginalFilename();

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(server));

            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        us.setRoles(this.rolesService.findRolesByName(kq));
        us.setAvatar(linkImage);
        us.setPassword(passwordEncoder.encode(us.getPassword()));
        Users user = this.userService.createUser(us);
        return "redirect:/table/user";
    }

    @GetMapping("/table/user")
    public String tableUser(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 3);
        System.out.println(page);
        Page<Users> usP = this.userService.findAllPage(pageable);
        List<Users> us = usP.getContent();
        model.addAttribute("users", us);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", usP.getTotalPages());
        // System.out.println("totalPage: " + pageable.getPageSize());
        return "/admin/user/table_fordash";
    }

    // hien thi cu the nguoi dung
    @GetMapping("/exactly/table/{id}")
    public String getMethodName(Model model, @PathVariable long id) {
        Users us = this.userService.findUserById(id);
        model.addAttribute("current", us);
        return "admin/user/exactlyUser_fordash";
    }

    // hien thi page chinh sua
    @GetMapping("/edit/user/{id}")
    public String getPageEdit(Model model, @PathVariable long id) {
        Users us = this.userService.findUserById(id);
        model.addAttribute("user", us);
        return "admin/user/update";
    }

    // chinh sua nguoi dung
    @PostMapping("/edit/user/finish")
    public String postUserRepeat(Model model, @ModelAttribute("user") Users us) {
        Users searchUser = this.userService.findUserById(us.getId());
        if (searchUser != null) {
            searchUser.setEmail(us.getEmail());
            searchUser.setPassword(us.getPassword());
            searchUser.setFullname(us.getFullname());
            searchUser.setAddress(us.getAddress());
            searchUser.setPhone(us.getPhone());
        }
        this.userService.createUser(searchUser);
        return "redirect:/table/user";
    }

    // hien thi giao dien xoa nguoi dung
    @GetMapping("/del/user/{id}")
    public String delUser(Model model, @PathVariable long id) {
        Users us = this.userService.findUserById(id);
        // System.out.println("USERSDETAIL: " + userDetails.getUsername()); lay ra email
        // cua nguoi dung da dang nhap
        if (us.getRoles().getName().equals("Admin")) {
            System.out.println("THIS USER IS ADMIN");
            model.addAttribute("current", us);
            return "/admin/user/notDel";
        } else {
            System.out.println("THIS USER IS NOT ADMIN");
            model.addAttribute("current", us);
        }
        return "/admin/user/del";
    }

    @PostMapping("/del/user/finish")
    public String delUserFinish(Model model, @ModelAttribute("current") Users user) {
        System.out.println(user.getId());
        this.userService.deleteUserById(user.getId());
        return "redirect:/table/user";
    }

}
