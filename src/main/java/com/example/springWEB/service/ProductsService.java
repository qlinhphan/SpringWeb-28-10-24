package com.example.springWEB.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Products_;
import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.Cart;
import com.example.springWEB.domain.cart.CartDetail;
import com.example.springWEB.domain.dto.ProductCriterialDTO;
import com.example.springWEB.repository.CartDetailRepository;
import com.example.springWEB.repository.CartRepository;
import com.example.springWEB.repository.ProductsRepository;
import com.example.springWEB.repository.UserRepository;
import com.example.springWEB.service.specification.ProductSpecService;

@Service
public class ProductsService {

    private ProductsRepository productsRepository;
    private UserService userService;
    private UserRepository userRepository;
    private CartDetailRepository cartDetailRepository;
    private CartRepository cartRepository;
    private ProductSpecService productSpecService;

    public ProductsService(ProductsRepository productsRepository, UserService userService,
            UserRepository userRepository, CartDetailRepository cartDetailRepository, CartRepository cartRepository,
            ProductSpecService productSpecService) {
        this.productsRepository = productsRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.cartRepository = cartRepository;
        this.productSpecService = productSpecService;

    }

    public Products saveProduct(Products pro) {
        return this.productsRepository.save(pro);
    }

    public List<Products> findAllProducts() {
        return this.productsRepository.findAll();
    }

    public Products findProductById(long id) {
        return this.productsRepository.findById(id);
    }

    public void DeleteProductById(long id) {
        this.productsRepository.deleteById(id);
    }

    public void addProductToCart(long idProduct, String email) {
        // loi ra 1 nguoi dung
        Users user = this.userRepository.findByEmail(email);

        // neu nguoi dung nay ton tai
        if (user != null) {
            int sumCart;
            // kiem tra xem nguoi dung co cart chua?
            Cart cart = this.cartRepository.findByUsers(user);
            if (cart == null) {
                sumCart = 0;
            } else {
                sumCart = cart.getSum();
            }
            // neu chua thi tao cart moi
            if (cart == null) {
                Cart newCart = new Cart();
                newCart.setSum(sumCart);
                newCart.setUsers(user);
                cart = this.cartRepository.save(newCart);
            }

            sumCart += 1;
            cart.setSum(sumCart);
            this.cartRepository.save(cart);

            Products products = this.productsRepository.findById(idProduct);
            if (products != null) {
                int quantityCartDetail;
                CartDetail currentCartDetail = this.cartDetailRepository.findByCartAndProducts(cart, products);
                if (currentCartDetail == null) {
                    quantityCartDetail = 0;
                    CartDetail cartDetail = new CartDetail();
                    cartDetail.setPrice((long) products.getPrice());
                    cartDetail.setQuantity(quantityCartDetail);
                    cartDetail.setCart(cart);
                    cartDetail.setProducts(products);
                    currentCartDetail = this.cartDetailRepository.save(cartDetail);
                }
                quantityCartDetail = currentCartDetail.getQuantity();
                quantityCartDetail += 1;
                currentCartDetail.setQuantity(quantityCartDetail);
                this.cartDetailRepository.save(currentCartDetail);
            }
        }
    }

    public Page<Products> PaginationProduct(Pageable pageable) {
        return this.productsRepository.findAll(pageable);
    }

    public Page<Products> paginationQueryByName(String name, Pageable pageable) {
        return this.productsRepository.findAll(this.productSpecService.likeNameFactOne(name), pageable);
    }

    public Page<Products> paginationQueryByPrice(String price, Pageable pageable) {
        return this.productsRepository.findAll(this.productSpecService.lessThanInputPrice(price),
                pageable);
    }

    public Page<Products> paginationQueryByFactory(String fact, Pageable pageable) {
        return this.productsRepository.findAll(this.productSpecService.factoryIsApple(fact), pageable);
    }

    public Page<Products> paginationQueryByManyFactory(List<String> fact, Pageable pageable) {
        return this.productsRepository.findAll(this.productSpecService.factoryIsAppleAndDell(fact), pageable);
    }

    public Page<Products> paginationQueryArrMoney(List<double[]> data, Pageable pageable) {
        return this.productsRepository.findAll(this.productSpecService.queryByManyMoney(data), pageable);
    }

    public Page<Products> paginationQueryNameIs(String fact, Pageable pageable) {
        return this.productsRepository.findAll(this.productSpecService.factoryIs(fact), pageable);
    }

    public Page<Products> paginationQuerySelectManyInAllFactory(List<String> factory, Pageable pag) {
        return this.productsRepository.findAll(this.productSpecService.selectManyInAllFactory(factory), pag);
    }

    public Page<Products> paginationQuerySelectManyInAllTarget(List<String> target, Pageable pag) {
        return this.productsRepository.findAll(this.productSpecService.selectManyInAllTarget(target), pag);
    }

    public Page<Products> SearchManyCondition(List<String> fact, List<String> target, List<double[]> money,
            Pageable pag) {
        Specification<Products> list = Specification.where(null);
        if (fact != null) {
            Specification<Products> fff = this.productSpecService.selectManyInAllFactory(fact);
            list = list.and(fff);
        }
        if (target != null) {
            Specification<Products> ttt = this.productSpecService.selectManyInAllTarget(target);
            list = list.and(ttt);
        }
        if (money != null) {
            Specification<Products> aaa = this.productSpecService.queryByManyMoney(money);
            list = list.and(aaa);
        }
        return this.productsRepository.findAll(list, pag);
    }

    public Page<Products> searchFactoryAndMoney(List<String> fact, List<double[]> money, Pageable pageable) {
        Specification<Products> dk = Specification.where(null);
        if (fact != null) {
            Specification<Products> aaa = this.productSpecService.selectManyInAllFactory(fact);
            dk = dk.and(aaa);
        }
        if (money != null) {
            Specification<Products> bbb = this.productSpecService.queryByManyMoney(money);
            dk = dk.and(bbb);
        }
        return this.productsRepository.findAll(dk, pageable);
    }

    public Page<Products> searchTargetAndMoney(List<String> target, List<double[]> money, Pageable pageable) {
        Specification<Products> dk = Specification.where(null);
        if (target != null) {
            Specification<Products> aaa = this.productSpecService.selectManyInAllTarget(target);
            dk = dk.and(aaa);
        }
        if (money != null) {
            Specification<Products> bbb = this.productSpecService.queryByManyMoney(money);
            dk = dk.and(bbb);
        }
        return this.productsRepository.findAll(dk, pageable);
    }
}
