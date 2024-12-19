package com.example.springWEB.controller.admin;

import java.util.ArrayList;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Users;
import com.example.springWEB.service.OrderService;
import com.example.springWEB.service.ProductsService;
import com.example.springWEB.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardControll {

    private UserService userService;
    private ProductsService productsService;
    private OrderService orderService;

    public DashboardControll(UserService userService, ProductsService productsService, OrderService orderService) {
        this.userService = userService;
        this.productsService = productsService;
        this.orderService = orderService;

    }

    @GetMapping("/adminDash")
    public String adminDash(Model model, @AuthenticationPrincipal UserDetails userDetails, HttpSession session) {
        List<Users> users = this.userService.findAllUser();
        int countUsers = 0;
        for (Users users2 : users) {
            if (users2 != null) {
                countUsers += 1;
            }
        }
        List<Products> products = this.productsService.findAllProducts();
        int countProducts = 0;
        for (Products products2 : products) {
            if (products2 != null) {
                countProducts += 1;
            }
        }
        List<Oders> order = this.orderService.findAllOders();
        int countOrders = 0;
        for (Oders oders : order) {
            if (oders != null) {
                countOrders += 1;
            }
        }

        // dem don hang cho xac nhan
        int countOrdersPending = 0;
        for (Oders oders : order) {
            if (oders.getStatus().equals("Đang chờ")) {
                countOrdersPending += 1;
            }
        }

        // dem don hang dang van chuyen
        int countOrdersDelivering = 0;
        for (Oders oders : order) {
            if (oders.getStatus().equals("Đang vận chuyển")) {
                countOrdersDelivering += 1;
            }
        }

        // dem don hang da hoan tat
        int countOrdersFinish = 0;
        for (Oders oders : order) {
            if (oders.getStatus().equals("Hoàn thành")) {
                countOrdersFinish += 1;
            }
        }

        Users us = this.userService.findUsersByEmail(userDetails.getUsername());
        session.setAttribute("currentUserLogin", us.getFullname());
        model.addAttribute("countUsers", countUsers);
        model.addAttribute("countProducts", countProducts);
        model.addAttribute("countOrders", countOrders);
        model.addAttribute("pending", countOrdersPending);
        model.addAttribute("finish", countOrdersFinish);
        model.addAttribute("delivering", countOrdersDelivering);

        List<Oders> dataTable = new ArrayList<>();
        for (Oders oders : order) {
            if (oders.getStatus().equals("Hoàn thành")) {
                dataTable.add(oders);
            }
        }
        model.addAttribute("orders", dataTable);

        return "admin/dasboard/show"; // có 1 sự thay đổi nhỏ trong file để upload lên
    }

}
