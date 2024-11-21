package com.example.springWEB.controller.admin;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;
import com.example.springWEB.service.CartDetailService;
import com.example.springWEB.service.CartService;
import com.example.springWEB.service.OrderService;
import com.example.springWEB.service.UserService;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderControll {

    private OrderService orderService;
    private UserService userService;
    private CartService cartService;
    private CartDetailService cartDetailServicel;

    public OrderControll(OrderService orderService, UserService userService, CartService cartService,
            CartDetailService cartDetailService) {
        this.orderService = orderService;
        this.userService = userService;
        this.cartService = cartService;
        this.cartDetailServicel = cartDetailService;
    }

    @GetMapping("/adminOrder")
    public String getOrder(Model model) {
        List<Oders> oders = this.orderService.findAllOders();
        model.addAttribute("oders", oders);
        System.out.println(oders);
        return "/admin/order/show";
    }

    @GetMapping("/admin/order/detail/{id}")
    public String getOrderDetail(Model model, @PathVariable long id) {
        System.out.println("id product: " + id);
        Oders order = this.orderService.findOrderById(id);

        model.addAttribute("order", order);

        return "/admin/order/show_detail";
    }

}
