package com.example.springWEB.controller.client.cart;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.OrderDetail;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;
import com.example.springWEB.domain.dto.UsersInfRecv;
import com.example.springWEB.service.CartDetailService;
import com.example.springWEB.service.CartService;
import com.example.springWEB.service.OrderDetailService;
import com.example.springWEB.service.OrderService;
import com.example.springWEB.service.UserService;

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
    private OrderDetailService orderDetailService;

    public checkoutControll(OrderService orderService, UserService userService, CartService cartService,
            CartDetailService cartDetailService, OrderDetailService orderDetailService) {
        this.OrderService = orderService;
        this.userService = userService;
        this.cartDetailService = cartDetailService;
        this.cartService = cartService;
        this.orderDetailService = orderDetailService;

    }

    @GetMapping("/checkout")
    public String checkout(Model model, @ModelAttribute("UserInfRec") Oders orders, HttpSession session,
            @AuthenticationPrincipal UserDetails userDetails) {
        if (session.getAttribute("SumCarts").equals(0)) {
            return "/client/cart/emptyCartDetail";
        }
        Users user = this.userService.findUsersByEmail(userDetails.getUsername());
        Cart cart = this.cartService.findCartByUser(user);
        List<CartDetail> cartDetails = this.cartDetailService.findCartDetailByCart(cart);
        int sums = 0;
        for (CartDetail cartDetail : cartDetails) {
            sums += cartDetail.getQuantity() * cartDetail.getPrice();
        }
        model.addAttribute("sums", sums);

        return "/client/cart/checkout";
    }

    // khi dat hang hoan tat
    @PostMapping("/create/order")
    @Transactional
    public String postMethodName(Model model, @ModelAttribute("UserInfRec") UsersInfRecv usersInfRecv,
            @AuthenticationPrincipal UserDetails userDetails) {
        // luu order
        Oders order = new Oders();
        order.setReceiverAddress(usersInfRecv.getReceiverAddress());
        order.setReceiverName(usersInfRecv.getReceiverName());
        order.setReceiverPhone(usersInfRecv.getReceiverPhone());
        order.setStatus("Pending");
        // thong tin nguoi dung dang dang nhap hien tai
        order.setUsers(this.userService.findUsersByEmail(userDetails.getUsername()));
        double sumMoney = 0;
        Users user = this.userService.findUsersByEmail(userDetails.getUsername());
        Cart cart = this.cartService.findCartByUser(user);
        List<CartDetail> cartDetails = this.cartDetailService.findCartDetailByCart(cart);
        for (CartDetail cd : cartDetails) {
            sumMoney += cd.getPrice() * cd.getQuantity();
        }
        order.setTotalPrice(sumMoney);
        order = this.OrderService.saveOrder(order);

        // luu orderDetail, phai xem chi tiet (trong orderDetail) co nhung san pham gi
        // va
        // so luong nhu nao, gia ra sao ma len nhung tang ay tien
        for (CartDetail cd : cartDetails) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setPrice(cd.getPrice());
            orderDetail.setQuantity(cd.getQuantity());
            orderDetail.setProducts(cd.getProducts());
            orderDetail.setOrders(order);
            this.orderDetailService.saveOrderDetail(orderDetail);
        }

        // xoa cartDetail
        this.cartDetailService.deleteCartDetailByCartt(cart);

        // xoa cart
        this.cartService.deleteCartByUser(user);

        return "/client/cart/finishOrder";
    }

}
