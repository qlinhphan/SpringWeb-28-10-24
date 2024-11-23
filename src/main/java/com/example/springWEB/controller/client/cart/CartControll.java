package com.example.springWEB.controller.client.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;
import com.example.springWEB.repository.CartDetailRepository;
import com.example.springWEB.repository.UserRepository;
import com.example.springWEB.service.CartDetailService;
import com.example.springWEB.service.CartService;
import com.example.springWEB.service.ProductsService;
import com.example.springWEB.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CartControll {

    private UserService userService;
    private ProductsService productsService;
    private CartDetailService cartDetailService;
    private CartService cartService;

    public CartControll(UserService userService, ProductsService productsService,
            CartDetailService cartDetailService,
            CartService cartService) {
        this.userService = userService;
        this.productsService = productsService;
        this.cartDetailService = cartDetailService;
        this.cartService = cartService;
    }

    public double total_sum(double a, double b) {
        return a * b;
    }

    @GetMapping("/cart")
    public String Cart(Model model, @AuthenticationPrincipal UserDetails userDetails,
            @ModelAttribute("deleteDetail") CartDetail cartDetail, HttpSession session) {
        Users user = this.userService.findUsersByEmail(userDetails.getUsername());
        Cart cart = this.cartService.findCartByUser(user);
        List<CartDetail> cartDetails = this.cartDetailService.findCartDetailByCart(cart);
        int sumP = 0;
        long sumM = 0;
        for (CartDetail cartDetail2 : cartDetails) {
            sumP += cartDetail2.getQuantity();
            sumM += cartDetail2.getPrice() * cartDetail2.getQuantity();

        }
        if (sumP == 0) {
            session.setAttribute("SumCarts", 0);
        }
        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("SumM", sumM);
        return "/client/cart/cartDetail";
    }

    @PostMapping("/delete-product-from-cart")
    public String deleteProduct(Model model, @AuthenticationPrincipal UserDetails userDetails, HttpSession session,
            @ModelAttribute("deleteDetail") CartDetail cartDetail) {
        String email = userDetails.getUsername();
        Users users = this.userService.findUsersByEmail(email);
        Cart cart = this.cartService.findCartByUser(users);
        int updateSum = cart.getSum();
        if (cart != null) {
            System.out.println(cartDetail.getId());
            Long idCartDetail = cartDetail.getId();
            this.cartDetailService.deleteCartDetailById(idCartDetail);
            updateSum = cart.getSum() - cartDetail.getQuantity();
            cart.setSum(updateSum);
            this.cartService.savaCart(cart);
        }
        session.setAttribute("SumCarts", updateSum);
        return "redirect:/cart";
    }

}
