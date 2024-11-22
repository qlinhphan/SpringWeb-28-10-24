package com.example.springWEB.controller.admin;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderControll {

    private OrderService orderService;
    private OrderDetailService orderDetailService;
    private UserService userService;
    private CartService cartService;
    private CartDetailService cartDetailServicel;

    public OrderControll(OrderService orderService, UserService userService, CartService cartService,
            CartDetailService cartDetailService, OrderDetailService orderDetailService) {
        this.orderService = orderService;
        this.userService = userService;
        this.cartService = cartService;
        this.cartDetailServicel = cartDetailService;
        this.orderDetailService = orderDetailService;
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
        List<OrderDetail> orderDetails = this.orderDetailService.findOrderDetailByOrder(order);
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("order", order);
        return "/admin/order/show_detail";
    }

    @GetMapping("/admin/order/update/{id}")
    public String edit(Model model, @PathVariable long id, @ModelAttribute("current") Oders orde) {
        System.out.println("ORDER OF: " + id);
        Oders order = this.orderService.findOrderById(id);
        return "/admin/order/onlyEditStt";
    }

    @PostMapping("/admin/order/update/finish")
    public String postMethodName(Model model, @ModelAttribute("current") Oders orde) {
        String stt = orde.getStatus();
        long id = orde.getId();
        Oders order = this.orderService.findOrderById(id);
        order.setStatus(stt);
        this.orderService.saveOrder(order);
        return "redirect:/adminOrder";
    }

    @GetMapping("/admin/order/del/{id}")
    public String delOrder(Model model, @ModelAttribute("delOrder") Oders ode, @PathVariable long id) {
        Oders oder = this.orderService.findOrderById(id);
        model.addAttribute("delO", oder);
        return "/admin/order/delOrder";
    }

    @PostMapping("/admin/order/del/finish")
    public String delOrderF(Model model, @ModelAttribute("delOrder") Oders ode) {
        Oders od = this.orderService.findOrderById(ode.getId());
        List<OrderDetail> orderDetail = this.orderDetailService.findOrderDetailByOrder(od);
        for (OrderDetail ord : orderDetail) {
            this.orderDetailService.deleteOrderDetailById(ord.getId());
        }

        long id = ode.getId();
        System.out.println("ID: " + id);
        this.orderService.deleteOrderById(id);
        return "redirect:/adminOrder";
    }

}
