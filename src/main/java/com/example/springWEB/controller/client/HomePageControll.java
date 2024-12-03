package com.example.springWEB.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.OrderDetail;
import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
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

        List<Oders> listOrder = this.orderService.findAllOders();

        // lay tat ca id cua product va dem xem cai nao xuat hien nhieu nhat => san pham
        // ban chay nhat
        List<Long> idProduct = new ArrayList<>();
        for (Oders od : listOrder) {
            List<OrderDetail> listOrderDetail = this.orderDetailService.findOrderDetailByOrder(od);
            System.out.println(listOrderDetail);
            for (OrderDetail oderDe : listOrderDetail) {
                // System.out.println(oderDe.getProducts().getId());
                idProduct.add(oderDe.getProducts().getId());
            }
        }
        System.out.println(idProduct);
        // for(int i=0; i<idProduct.size(); i++){
        // for(int j=i+1; j<idProduct.size(); j++){
        // if(idProduct)
        // }
        // }
        return "/client/show";
    }

    @GetMapping("/buy")
    public String Shop(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "name", defaultValue = "") String name) {
        org.springframework.data.domain.Pageable pagea = PageRequest.of(page - 1, 6);
        System.out.println(name);
        if (name.isEmpty()) {
            Page<Products> pagePro = this.productsService.PaginationProduct(pagea);
            List<Products> ListPro = pagePro.getContent();
            model.addAttribute("totalPage", pagePro.getTotalPages());
            model.addAttribute("currentPage", page);
            model.addAttribute("dsProducts", ListPro);
            return "/client/shop";
        }
        String[] dataName;
        dataName = name.split(",");
        List<String> dataNames = new ArrayList<>();
        for (String string : dataName) {
            dataNames.add(string);
        }
        Page<Products> dsProductPage;
        dsProductPage = this.productsService.paginationQueryByManyFactory(dataNames, pagea);
        List<Products> dsProducts = dsProductPage.getContent();

        model.addAttribute("totalPage", dsProductPage.getTotalPages());
        System.out.println("dsPage: " + dsProductPage.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("dsProducts", dsProducts);
        return "/client/shop";
    }

    // @GetMapping("/products")
    // public String Price(Model model, @RequestParam(value = "page", defaultValue =
    // "1") int page,
    // @RequestParam(value = "name", defaultValue = "") String price) {
    // org.springframework.data.domain.Pageable pagea = PageRequest.of(page - 1, 6);
    // String dataPrice = price;
    // System.out.println(price);
    // String[] dataPriceFinal = dataPrice.split(",");
    // List<Double[]> dataFinal = new ArrayList<>();

    // for (String money : dataPriceFinal) {
    // if (money.equals("tu-10tr-den-15tr")) {
    // dataFinal.add(new Double[] { (double) 10000000, (double) 15000000 });
    // }
    // if (money.equals("tren-20tr")) {
    // dataFinal.add(new Double[] { (double) 20000000, (double) 200000000 });
    // }
    // }

    // Page<Products> dsProductPage =
    // this.productsService.paginationQueryByRangeMoney(dataFinal,
    // pagea);
    // List<Products> dsProducts = dsProductPage.getContent();
    // model.addAttribute("totalPage", dsProductPage.getTotalPages());
    // model.addAttribute("currentPage", page);
    // model.addAttribute("dsProducts", dsProducts);
    // // System.out.println(min + " " + max);
    // // Page<Products> dsProductPage =
    // // this.productsService.paginationQueryByRangeMoney(min, max, pagea);

    // return "/client/shop";
    // }

}
// test
