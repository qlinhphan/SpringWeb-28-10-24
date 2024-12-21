package com.example.springWEB.controller.client.cart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.OrderDetail;
import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;
import com.example.springWEB.domain.dto.UsersInfRecv;
import com.example.springWEB.service.CartDetailService;
import com.example.springWEB.service.CartService;
import com.example.springWEB.service.OrderDetailService;
import com.example.springWEB.service.OrderService;
import com.example.springWEB.service.ProductsService;
import com.example.springWEB.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class checkoutControll {
    private OrderService OrderService;
    private UserService userService;
    private CartService cartService;
    private CartDetailService cartDetailService;
    private OrderDetailService orderDetailService;
    private ProductsService productsService;

    public checkoutControll(OrderService orderService, UserService userService, CartService cartService,
            CartDetailService cartDetailService, OrderDetailService orderDetailService,
            ProductsService productsService) {
        this.OrderService = orderService;
        this.userService = userService;
        this.cartDetailService = cartDetailService;
        this.cartService = cartService;
        this.orderDetailService = orderDetailService;
        this.productsService = productsService;
    }

    @GetMapping("/checkout")
    public String checkout(Model model, @ModelAttribute("UserInfRec") Oders orders, HttpSession session,
            @AuthenticationPrincipal UserDetails userDetails) {
        Object sumCarts = session.getAttribute("SumCarts");

        // Kiểm tra nếu sumCarts là null hoặc bằng 0
        if (sumCarts == null || sumCarts.equals(0)) {
            return "/client/cart/emptyCartDetail";
        }
        Users user = this.userService.findUsersByEmail(userDetails.getUsername());
        Cart cart = this.cartService.findCartByUser(user);
        List<CartDetail> cartDetails = this.cartDetailService.findCartDetailByCart(cart);
        for (CartDetail cartDetail : cartDetails) {
            if (cartDetail != null && cartDetail.getQuantity() > cartDetail.getProducts().getQuantity()) {
                System.out.println(cartDetail.getQuantity());
                System.out.println(cartDetail.getProducts().getQuantity());
                return "redirect:/cart";
            }
        }
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
        order.setDateOrder(new Date());
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

        Users us = this.userService.findUsersByEmail(userDetails.getUsername());
        List<OrderDetail> listod = new ArrayList<>();
        if (us != null) {
            List<Oders> listOr = this.OrderService.findOrderByUser(us);
            for (Oders oders : listOr) {
                listod = this.orderDetailService.findOrderDetailByOrder(oders);

            }
        }
        for (OrderDetail orderDetail : listod) {
            System.out.println(orderDetail);
        }
        List<Products> pro = this.productsService.findAllProducts();
        for (OrderDetail li : listod) {
            for (Products products : pro) {
                if (li.getProducts().getId() == products.getId()) {
                    products.setQuantity(products.getQuantity() - li.getQuantity());
                    products.setSold(li.getQuantity());
                    this.productsService.saveProduct(products);
                    break;
                }
            }
        }

        this.cartDetailService.deleteCartDetailByCartt(cart);

        this.cartService.deleteCartByUser(user);

        return "/client/cart/finishOrder";
    }
}
