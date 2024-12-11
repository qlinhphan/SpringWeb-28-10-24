package com.example.springWEB.controller.client;

import java.util.ArrayList;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Products_;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.dto.ProductCriterialDTO;
import com.example.springWEB.service.CartDetailService;
import com.example.springWEB.service.CartService;
import com.example.springWEB.service.OrderDetailService;
import com.example.springWEB.service.OrderService;
import com.example.springWEB.service.ProductsService;
import com.example.springWEB.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomePageControll {

    private ProductsService productsService;
    private UserService userService;
    private CartService cartService;
    private CartDetailService cartDetailService;
    private OrderService orderService;
    private OrderDetailService orderDetailService;

    public HomePageControll(ProductsService productsService, UserService userService, CartService cartService,
            OrderService orderService, OrderDetailService orderDetailService) {
        this.productsService = productsService;
        this.userService = userService;
        this.cartService = cartService;
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("")
    public String homepage(Model model, @AuthenticationPrincipal UserDetails userDetails, HttpSession session) {
        List<Products> ds = this.productsService.findAllProducts();
        model.addAttribute("products", ds);
        String email = userDetails.getUsername();
        Users users = this.userService.findUsersByEmail(email);
        Cart cart = this.cartService.findCartByUser(users);
        int sumCart = 0;
        if (cart == null) {
            System.out.println(userDetails.getPassword());
            return "/client/show";
        }
        sumCart = cart.getSum();
        session.setAttribute("SumCarts", sumCart);

        return "/client/show";
    }

    // @GetMapping("/buy")
    // public String Shop(Model model, @RequestParam(value = "page", defaultValue =
    // "1") int page,
    // @RequestParam(value = "name", defaultValue = "") String name) {
    // org.springframework.data.domain.Pageable pagea = PageRequest.of(page - 1, 6);
    // System.out.println(name);
    // if (name.isEmpty()) {
    // Page<Products> pagePro = this.productsService.PaginationProduct(pagea);
    // List<Products> ListPro = pagePro.getContent();
    // model.addAttribute("totalPage", pagePro.getTotalPages());
    // model.addAttribute("currentPage", page);
    // model.addAttribute("dsProducts", ListPro);
    // return "/client/shop";
    // }
    // String[] dataName;
    // dataName = name.split(",");
    // List<String> dataNames = new ArrayList<>();
    // for (String string : dataName) {
    // dataNames.add(string);
    // }
    // Page<Products> dsProductPage;
    // dsProductPage = this.productsService.paginationQueryByManyFactory(dataNames,
    // pagea);
    // List<Products> dsProducts = dsProductPage.getContent();

    // model.addAttribute("totalPage", dsProductPage.getTotalPages());
    // System.out.println("dsPage: " + dsProductPage.getTotalPages());
    // model.addAttribute("currentPage", page);
    // model.addAttribute("dsProducts", dsProducts);
    // return "/client/shop";
    // }

    // @GetMapping("/buy") ----------------------------------------------------->
    // //theo factory
    // public String fetch(Model model, ProductCriterialDTO proCri) {
    // String page = proCri.getPage();
    // if (page == null) {
    // page = "1";
    // }
    // int pages = Integer.parseInt(page);

    // Pageable pab = PageRequest.of(pages - 1, 10);

    // List<String> nameFact = new ArrayList<>();

    // if (proCri.getFact() == null) {
    // Page<Products> pagePro = this.productsService.PaginationProduct(pab);
    // List<Products> listPro = pagePro.getContent();
    // model.addAttribute("totalPage", pagePro.getTotalPages());
    // model.addAttribute("currentPage", pages);
    // model.addAttribute("dsProducts", listPro);
    // return "/client/shop";
    // }

    // String[] ListFact = proCri.getFact().split(",");

    // for (String string : ListFact) {
    // nameFact.add(string);
    // }

    // Page<Products> pagePro =
    // this.productsService.paginationQuerySelectManyInAllFactory(nameFact, pab);
    // List<Products> listPro = pagePro.getContent();

    // model.addAttribute("totalPage", pagePro.getTotalPages());
    // model.addAttribute("currentPage", pages);
    // model.addAttribute("dsProducts", listPro);

    // return "/client/shop";
    // }

    @GetMapping("/buy")
    public String fetch(Model model, ProductCriterialDTO proCri) {
        String page = proCri.getPage();
        if (page == null) {
            page = "1";
        }
        int pages = Integer.parseInt(page);
        Pageable pab = null;

        if (proCri.getSort().equals("khong-sap-xep") || proCri.getSort() == null) {
            pab = PageRequest.of(pages - 1, 10);
        }
        if (proCri.getSort().equals("gia-tang-dan")) {
            pab = PageRequest.of(pages - 1, 10, Sort.by(Products_.PRICE).ascending());
        }
        if (proCri.getSort().equals("gia-giam-dan")) {
            pab = PageRequest.of(pages - 1, 10, Sort.by(Products_.PRICE).descending());
        }

        List<String> nameTarget = new ArrayList<>();
        List<String> nameFact = new ArrayList<>();

        if (proCri.getTarget() == null && proCri.getFact() == null) {
            Page<Products> pagePro = this.productsService.PaginationProduct(pab);
            List<Products> listPro = pagePro.getContent();
            model.addAttribute("totalPage", pagePro.getTotalPages());
            model.addAttribute("currentPage", pages);
            model.addAttribute("dsProducts", listPro);
            return "/client/shop";
        }
        if (proCri.getTarget() == null & proCri.getFact() != null) {
            String[] datafact = proCri.getFact().split(",");
            for (String string : datafact) {
                nameFact.add(string);
            }
            Page<Products> pagePro = this.productsService.paginationQuerySelectManyInAllFactory(nameFact, pab);
            List<Products> listPro = pagePro.getContent();
            model.addAttribute("totalPage", pagePro.getTotalPages());
            model.addAttribute("currentPage", pages);
            model.addAttribute("dsProducts", listPro);
            return "/client/shop";
        }
        if (proCri.getTarget() != null & proCri.getFact() == null) {
            String[] dataTarget = proCri.getTarget().split(",");
            for (String string : dataTarget) {
                nameTarget.add(string);
            }
            Page<Products> pagePro = this.productsService.paginationQuerySelectManyInAllTarget(nameTarget, pab);
            List<Products> listPro = pagePro.getContent();
            model.addAttribute("totalPage", pagePro.getTotalPages());
            model.addAttribute("currentPage", pages);
            model.addAttribute("dsProducts", listPro);
            return "/client/shop";
        }

        String[] ListTarget = proCri.getTarget().split(",");
        String[] ListFact = proCri.getFact().split(",");

        for (String string : ListTarget) {
            nameTarget.add(string);
        }
        for (String string1 : ListFact) {
            nameFact.add(string1);
        }

        Page<Products> pagePro = this.productsService.SearchManyCondition(nameFact, nameTarget, pab);
        List<Products> listPro = pagePro.getContent();

        model.addAttribute("totalPage", pagePro.getTotalPages());
        model.addAttribute("currentPage", pages);
        model.addAttribute("dsProducts", listPro);

        return "/client/shop";
    }

}
