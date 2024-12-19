package com.example.springWEB.controller.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.OrderDetail;
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
        model.addAttribute("user", users);
        Cart cart = this.cartService.findCartByUser(users);
        int sumCart;
        if (cart == null) {
            sumCart = 0;

            List<OrderDetail> orderDetail = this.orderDetailService.findAllOrderDetail();
            List<Long> idProducts = new ArrayList<>();
            for (OrderDetail orderDetail2 : orderDetail) {
                System.out.println(orderDetail2.getProducts().getName());
                System.out.println(orderDetail2.getProducts().getId());
                idProducts.add(orderDetail2.getProducts().getId());
            }
            System.out.println(idProducts);

            // bien dem so lan xuat hien moi san pham
            double dem;

            // san pham nao xuat hien nhieu nhat -> san pham nguoi ta quan tam nhat
            double maxCount = 0;

            // id tuong ung cua san pham xuat hien trong nhieu nhat trong cac don cua khach
            // hang
            long idProductCare = 1;
            for (Long long1 : idProducts) {
                dem = 0;
                for (Long long2 : idProducts) {
                    if (long1 == long2) {
                        dem++;
                    }
                }
                System.out.println("SO " + long1 + " XUAT HIEN: " + dem);
                if (maxCount < dem) {
                    maxCount = dem;
                    idProductCare = long1;
                }
            }
            System.out.println("SAN PHAM XUAT HIEN NHIEU NHAT: " + maxCount);
            System.out.println("ID TUONG UNG CUA SAN PHAM DO: " + idProductCare);
            Products productCare = this.productsService.findProductById(idProductCare);
            model.addAttribute("productCare", productCare);

            List<Users> user = this.userService.findAllUser();
            int countUser = 0;
            for (Users users2 : user) {
                if (users2 != null) {
                    countUser++;
                }
            }
            model.addAttribute("countUser", countUser);

            List<Oders> od = this.orderService.findAllOders();
            int countOrder = 0;
            for (Oders oders : od) {
                if (oders != null && oders.getStatus().equals("Finish")) {
                    countOrder++;
                }
            }
            model.addAttribute("countOrder", countOrder);

            // tim ra nguoi dung tich cuc nhat
            List<Oders> ods = this.orderService.findAllOders();
            for (Oders oders : ods) {
                System.out.println("Id User: " + oders.getUsers().getId());
            }
            int demIdUser;
            int max = 0; // dem cac oder xem nguoi nao xuat hien nhieu nhat
            long isId = 0;
            for (Oders oders : ods) {
                demIdUser = 0;
                for (Oders oders2 : ods) {
                    if (oders.getUsers().getId() == oders2.getUsers().getId()) {
                        demIdUser++;
                    }
                    if (max < demIdUser) {
                        max = demIdUser;
                        isId = oders.getUsers().getId();
                    }

                }
                System.out.println("Id User " + oders.getUsers().getId() + ": " + demIdUser);
                System.out.println("So Lan XUat Hien Nhieu Nhat: " + max);
                System.out.println("DO LA ID CUA NGUOI DUNG: " + isId);
                Users isUser = this.userService.findUserById(isId);
                model.addAttribute("isUser", isUser);
            }

            // tim ra khach hang dac biet nhat
            List<Oders> ode = this.orderService.findAllOders();
            double maxMoney = 0;
            long isOrderId = 0;
            for (Oders oders : ode) {
                System.out.println(oders.getTotalPrice());
            }
            for (Oders oders : ode) {
                if (maxMoney < oders.getTotalPrice()) {
                    maxMoney = oders.getTotalPrice();
                    isOrderId = oders.getId();
                }
            }
            Oders isOrder = this.orderService.findOrderById(isOrderId);
            model.addAttribute("isOrder", isOrder);
            System.out.println("So tien nhieu nhat duoc su dung: " + maxMoney);
            return "/client/show";
        }

        List<OrderDetail> orderDetail = this.orderDetailService.findAllOrderDetail();
        List<Long> idProducts = new ArrayList<>();
        for (OrderDetail orderDetail2 : orderDetail) {
            System.out.println(orderDetail2.getProducts().getName());
            System.out.println(orderDetail2.getProducts().getId());
            idProducts.add(orderDetail2.getProducts().getId());
        }
        System.out.println(idProducts);

        // bien dem so lan xuat hien moi san pham
        double dem;

        // san pham nao xuat hien nhieu nhat -> san pham nguoi ta quan tam nhat
        double maxCount = 0;

        // id tuong ung cua san pham xuat hien trong nhieu nhat trong cac don cua khach
        // hang
        long idProductCare = 1;
        for (Long long1 : idProducts) {
            dem = 0;
            for (Long long2 : idProducts) {
                if (long1 == long2) {
                    dem++;
                }
            }
            System.out.println("SO " + long1 + " XUAT HIEN: " + dem);
            if (maxCount < dem) {
                maxCount = dem;
                idProductCare = long1;
            }
        }
        System.out.println("SAN PHAM XUAT HIEN NHIEU NHAT: " + maxCount);
        System.out.println("ID TUONG UNG CUA SAN PHAM DO: " + idProductCare);
        Products productCare = this.productsService.findProductById(idProductCare);
        model.addAttribute("productCare", productCare);

        List<Users> user = this.userService.findAllUser();
        int countUser = 0;
        for (Users users2 : user) {
            if (users2 != null) {
                countUser++;
            }
        }
        model.addAttribute("countUser", countUser);

        List<Oders> od = this.orderService.findAllOders();
        int countOrder = 0;
        for (Oders oders : od) {
            if (oders != null && oders.getStatus().equals("Finish")) {
                countOrder++;
            }
        }
        model.addAttribute("countOrder", countOrder);

        sumCart = cart.getSum();
        session.setAttribute("SumCarts", sumCart);

        // tim ra nguoi dung tich cuc nhat
        List<Oders> ods = this.orderService.findAllOders();
        for (Oders oders : ods) {
            System.out.println("Id User: " + oders.getUsers().getId());
        }
        int demIdUser;
        int max = 0; // dem cac oder xem nguoi nao xuat hien nhieu nhat
        long isId = 0;
        for (Oders oders : ods) {
            demIdUser = 0;
            for (Oders oders2 : ods) {
                if (oders.getUsers().getId() == oders2.getUsers().getId()) {
                    demIdUser++;
                }
                if (max < demIdUser) {
                    max = demIdUser;
                    isId = oders.getUsers().getId();
                }

            }
            System.out.println("Id User " + oders.getUsers().getId() + ": " + demIdUser);
            System.out.println("So Lan XUat Hien Nhieu Nhat: " + max);
            System.out.println("DO LA ID CUA NGUOI DUNG: " + isId);
            Users isUser = this.userService.findUserById(isId);
            model.addAttribute("isUser", isUser);
        }

        // tim ra khach hang dac biet nhat
        List<Oders> ode = this.orderService.findAllOders();
        double maxMoney = 0;
        long isOrderId = 0;
        for (Oders oders : ode) {
            System.out.println(oders.getTotalPrice());
        }
        for (Oders oders : ode) {
            if (maxMoney < oders.getTotalPrice()) {
                maxMoney = oders.getTotalPrice();
                isOrderId = oders.getId();
            }
        }
        Oders isOrder = this.orderService.findOrderById(isOrderId);
        model.addAttribute("isOrder", isOrder);
        System.out.println("So tien nhieu nhat duoc su dung: " + maxMoney);

        return "/client/show";
    }

    // @RequestParam(value = "page", defaultValue = "1") String pages,
    @GetMapping("/buy")
    public String fetch(Model model, ProductCriterialDTO proCri, @RequestParam Map<String, String> params,
            @RequestParam(value = "sort", defaultValue = "khong-sap-xep") String sort,
            HttpSession session, @AuthenticationPrincipal UserDetails ud) {
        model.addAttribute("ud", this.userService.findUsersByEmail(ud.getUsername()));
        int page = Integer.parseInt(proCri.getPage());

        System.out.println("PAGE: " + page);

        Pageable pab = null;
        if (proCri.getSort() == null) {
            proCri.setSort(sort);
        }
        if (proCri.getSort().equals("khong-sap-xep")) {
            pab = PageRequest.of(page - 1, 3);
        }
        if (proCri.getSort().equals("gia-tang-dan")) {
            pab = PageRequest.of(page - 1, 10, Sort.by(Products_.PRICE).ascending());
        }
        if (proCri.getSort().equals("gia-giam-dan")) {
            pab = PageRequest.of(page - 1, 10, Sort.by(Products_.PRICE).descending());
        }

        List<String> nameTarget = new ArrayList<>();
        List<String> nameFact = new ArrayList<>();
        List<double[]> nameMoney = new ArrayList<>();

        if (proCri.getTarget() == null && proCri.getFact() == null) {
            if (proCri.getMoney() == null) {
                Page<Products> pagePro = this.productsService.PaginationProduct(pab);
                List<Products> listPro = pagePro.getContent();
                model.addAttribute("totalPage", pagePro.getTotalPages());
                // System.out.println();
                System.out.println("TOTAL PAGE: " + pagePro.getTotalPages());
                model.addAttribute("currentPage", page);
                model.addAttribute("dsProducts", listPro);
                return "/client/shop";
            }
            String[] ListMoney = proCri.getMoney().split(",");
            for (String str : ListMoney) {
                if (str.equals("duoi-10tr")) {
                    double min = 0;
                    double max = 10000000;
                    nameMoney.add(new double[] { min, max });
                }
                if (str.equals("tu-10tr-den-15tr")) {
                    double min = 10000000;
                    double max = 15000000;
                    nameMoney.add(new double[] { min, max });
                }
                if (str.equals("tu-15tr-den-20tr")) {
                    double min = 15000000;
                    double max = 20000000;
                    nameMoney.add(new double[] { min, max });
                }
                if (str.equals("tren-20tr")) {
                    double min = 20000000;
                    double max = 100000000;
                    nameMoney.add(new double[] { min, max });
                }
            }
            Page<Products> pagePro = this.productsService.paginationQueryArrMoney(nameMoney, pab);
            List<Products> listPro = pagePro.getContent();

            System.out.println("TOTAL PAGE: " + pagePro.getTotalPages());
            model.addAttribute("totalPage", pagePro.getTotalPages());
            model.addAttribute("currentPage", page);
            model.addAttribute("dsProducts", listPro);
            return "/client/shop";
        }
        if (proCri.getTarget() == null && proCri.getFact() != null) {
            if (proCri.getMoney() == null) {
                String[] datafact = proCri.getFact().split(",");
                for (String string : datafact) {
                    nameFact.add(string);
                }
                Page<Products> pagePro = this.productsService.paginationQuerySelectManyInAllFactory(nameFact, pab);
                List<Products> listPro = pagePro.getContent();
                model.addAttribute("totalPage", pagePro.getTotalPages());
                model.addAttribute("currentPage", page);
                model.addAttribute("dsProducts", listPro);
                return "/client/shop";
            }
            String[] datafact = proCri.getFact().split(",");
            for (String string : datafact) {
                nameFact.add(string);
            }
            String[] ListMoney = proCri.getMoney().split(",");
            for (String str : ListMoney) {
                if (str.equals("duoi-10tr")) {
                    double min = 0;
                    double max = 10000000;
                    nameMoney.add(new double[] { min, max });
                }
                if (str.equals("tu-10tr-den-15tr")) {
                    double min = 10000000;
                    double max = 15000000;
                    nameMoney.add(new double[] { min, max });
                }
                if (str.equals("tu-15tr-den-20tr")) {
                    double min = 15000000;
                    double max = 20000000;
                    nameMoney.add(new double[] { min, max });
                }
                if (str.equals("tren-20tr")) {
                    double min = 20000000;
                    double max = 100000000;
                    nameMoney.add(new double[] { min, max });
                }
            }

            Page<Products> pagePro = this.productsService.searchFactoryAndMoney(nameFact, nameMoney, pab);
            List<Products> listPro = pagePro.getContent();
            model.addAttribute("totalPage", pagePro.getTotalPages());
            model.addAttribute("currentPage", page);
            model.addAttribute("dsProducts", listPro);
            return "/client/shop";

        }
        if (proCri.getTarget() != null & proCri.getFact() == null) {
            if (proCri.getMoney() == null) {

                String[] dataTarget = proCri.getTarget().split(",");
                for (String string : dataTarget) {
                    nameTarget.add(string);
                }
                Page<Products> pagePro = this.productsService.paginationQuerySelectManyInAllTarget(nameTarget, pab);
                List<Products> listPro = pagePro.getContent();
                model.addAttribute("totalPage", pagePro.getTotalPages());
                model.addAttribute("currentPage", page);
                model.addAttribute("dsProducts", listPro);
                return "/client/shop";
            }
            String[] dataTarget = proCri.getTarget().split(",");
            for (String string : dataTarget) {
                nameTarget.add(string);
            }
            String[] ListMoney = proCri.getMoney().split(",");
            for (String str : ListMoney) {
                if (str.equals("duoi-10tr")) {
                    double min = 0;
                    double max = 10000000;
                    nameMoney.add(new double[] { min, max });
                }
                if (str.equals("tu-10tr-den-15tr")) {
                    double min = 10000000;
                    double max = 15000000;
                    nameMoney.add(new double[] { min, max });
                }
                if (str.equals("tu-15tr-den-20tr")) {
                    double min = 15000000;
                    double max = 20000000;
                    nameMoney.add(new double[] { min, max });
                }
                if (str.equals("tren-20tr")) {
                    double min = 20000000;
                    double max = 100000000;
                    nameMoney.add(new double[] { min, max });
                }
            }
            Page<Products> pagePro = this.productsService.searchTargetAndMoney(nameTarget, nameMoney, pab);
            List<Products> listPro = pagePro.getContent();
            model.addAttribute("totalPage", pagePro.getTotalPages());
            model.addAttribute("currentPage", page);
            model.addAttribute("dsProducts", listPro);
            return "/client/shop";
        }

        if (proCri.getTarget() != null & proCri.getFact() != null) {
            if (proCri.getMoney() == null) {
                String[] dataTarget = proCri.getTarget().split(",");
                for (String string : dataTarget) {
                    nameTarget.add(string);
                }
                String[] datafact = proCri.getFact().split(",");
                for (String string : datafact) {
                    nameFact.add(string);
                }
                Page<Products> pagePro = this.productsService.searchTargetAndFact(nameTarget, nameFact, pab);
                List<Products> listPro = pagePro.getContent();
                model.addAttribute("totalPage", pagePro.getTotalPages());
                model.addAttribute("currentPage", page);
                model.addAttribute("dsProducts", listPro);
                return "/client/shop";
            }
        }

        String[] ListTarget = proCri.getTarget().split(",");
        String[] ListFact = proCri.getFact().split(",");
        String[] ListMoney = proCri.getMoney().split(",");

        for (String string : ListTarget) {
            nameTarget.add(string);
        }
        for (String string1 : ListFact) {
            nameFact.add(string1);
        }
        for (String str : ListMoney) {
            if (str.equals("duoi-10tr")) {
                double min = 0;
                double max = 10000000;
                nameMoney.add(new double[] { min, max });
            }
            if (str.equals("tu-10tr-den-15tr")) {
                double min = 10000000;
                double max = 15000000;
                nameMoney.add(new double[] { min, max });
            }
            if (str.equals("tu-15tr-den-20tr")) {
                double min = 15000000;
                double max = 20000000;
                nameMoney.add(new double[] { min, max });
            }
            if (str.equals("tren-20tr")) {
                double min = 20000000;
                double max = 100000000;
                nameMoney.add(new double[] { min, max });
            }
        }

        Page<Products> pagePro = this.productsService.SearchManyCondition(nameFact, nameTarget, nameMoney, pab);
        List<Products> listPro = pagePro.getContent();

        model.addAttribute("totalPage", pagePro.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("dsProducts", listPro);

        return "/client/shop";
    }

}
