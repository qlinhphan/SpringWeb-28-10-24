package com.example.springWEB.controller.client.cart;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;
import com.example.springWEB.domain.dto.UsersInfRecv;
import com.example.springWEB.service.CartDetailService;
import com.example.springWEB.service.CartService;
import com.example.springWEB.service.OrderService;
import com.example.springWEB.service.UserService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class checkoutControll {
    private OrderService OrderService;
    private UserService userService;
    private CartService cartService;
    private CartDetailService cartDetailService;

    public checkoutControll(OrderService orderService, UserService userService, CartService cartService,
            CartDetailService cartDetailService) {
        this.OrderService = orderService;
        this.userService = userService;
        this.cartDetailService = cartDetailService;
        this.cartService = cartService;
    }

    @GetMapping("/checkout")
    public String checkout(Model model, @ModelAttribute("UserInfRec") Oders orders, HttpSession session,
            @AuthenticationPrincipal UserDetails userDetails) {
        if (session.getAttribute("SumCarts").equals(0)) {
            return "/client/cart/emptyCartDetail";
        }
        // Users user = this.userService.findUsersByEmail(userDetails.getUsername());
        // Cart cart = this.cartService.findCartByUser(user);
        // CartDetail cartDetail = this.cartDetailService.findCartDetailById()
        return "/client/cart/checkout";
    }

    // khi dat hang hoan tat
    @PostMapping("/create/order")
    @Transactional
    public String postMethodName(Model model, @ModelAttribute("UserInfRec") UsersInfRecv usersInfRecv,
            @AuthenticationPrincipal UserDetails userDetails, HttpSession session) {
        Oders oders = new Oders();
        oders.setReceiverName(usersInfRecv.getReceiverName());
        oders.setReceiverAddress(usersInfRecv.getReceiverAddress());
        oders.setReceiverPhone(usersInfRecv.getReceiverPhone());
        oders.setUsers(this.userService.findUsersByEmail(userDetails.getUsername()));
        oders.setStatus("Pending");
        double sum = 0;
        Users users = this.userService.findUsersByEmail(userDetails.getUsername());
        Cart carts = this.cartService.findCartByUser(users);
        List<CartDetail> cartDetail = this.cartDetailService.findCartDetailByCart(carts);
        for (CartDetail cd : cartDetail) {
            sum += cd.getPrice();
        }
        oders.setTotalPrice(sum);
        this.OrderService.saveOrder(oders);

        Users user = this.userService.findUsersByEmail(userDetails.getUsername());
        Cart cart = this.cartService.findCartByUser(user);
        List<CartDetail> cartDetails = this.cartDetailService.findCartDetailByCart(cart);
        for (CartDetail cd : cartDetails) {
            this.cartDetailService.deleteCartDetailById(cd.getId());
        }

        this.cartService.deleteCartByUser(user);
        session.setAttribute("SumCarts", 0);

        return "hello";
    }

}
