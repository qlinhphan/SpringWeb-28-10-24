package com.example.springWEB.controller.client.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.OrderDetail;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;
import com.example.springWEB.service.CartDetailService;
import com.example.springWEB.service.CartService;
import com.example.springWEB.service.OrderDetailService;
import com.example.springWEB.service.OrderService;
import com.example.springWEB.service.UserService;

@Controller
public class PurchaseHist {

    private OrderService orderService;
    private UserService userService;
    private CartService cartService;
    private OrderDetailService orderDetailService;
    private CartDetailService cartDetailService;

    public PurchaseHist(OrderService orderService, UserService userService, OrderDetailService orderDetailService,
            CartService cartService, CartDetailService cartDetailService) {
        this.orderService = orderService;
        this.userService = userService;
        this.orderDetailService = orderDetailService;
        this.cartService = cartService;
        this.cartDetailService = cartDetailService;
    }

    @GetMapping("/purcharseHist")
    public String getMethodName(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Users user = this.userService.findUsersByEmail(userDetails.getUsername());
        List<Oders> order = this.orderService.findOrderByUser(user);

        List<OrderDetail> ord = new ArrayList<>();
        for (Oders oders : order) {
            List<OrderDetail> orderDetails = this.orderDetailService.findOrderDetailByOrder(oders);
            ord.addAll(orderDetails);
        }

        model.addAttribute("orderDetails", ord);

        return "/client/cart/purchaseHist"; // orderDetails
    }

}
