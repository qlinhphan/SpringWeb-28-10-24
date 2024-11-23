package com.example.springWEB.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Users;
import com.example.springWEB.service.OrderService;
import com.example.springWEB.service.ProductsService;
import com.example.springWEB.service.UserService;

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
    public String adminDash(Model model) {
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
        model.addAttribute("countUsers", countUsers);
        model.addAttribute("countProducts", countProducts);
        model.addAttribute("countOrders", countOrders);
        return "admin/dasboard/show"; // có 1 sự thay đổi nhỏ trong file để upload lên
    }
}
