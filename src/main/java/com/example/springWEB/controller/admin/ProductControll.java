package com.example.springWEB.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.springWEB.domain.Products;
import com.example.springWEB.service.ProductsService;

import jakarta.servlet.ServletContext;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductControll {

    private ProductsService productsService;
    private ServletContext servletContext;

    public ProductControll(ProductsService productsService, ServletContext servletContext) {
        this.productsService = productsService;
        this.servletContext = servletContext;
    }

    @GetMapping("/adminProduct")
    public String adminDash(Model model) {
        return "/admin/product/show";
    }

    @GetMapping("/create/product")
    public String createProduct(Model model, @ModelAttribute("newProduct") Products pro) {
        return "/admin/product/create";
    }

    @PostMapping("/create/product/finish")
    public String createProductOk(Model model, @ModelAttribute("newProduct") Products pro,
            @RequestParam("imgProduct") MultipartFile file) {
        String linkImg = "";
        String kqs = pro.getFactory();
        System.out.println(kqs);
        try {
            byte[] bytes;
            bytes = file.getBytes();

            String rootPath = this.servletContext.getRealPath("/resources/images");

            File dir = new File(rootPath + File.separator + "product");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            File serverPath = new File(dir.getAbsolutePath() + File.separator + System.currentTimeMillis() + "-"
                    + file.getOriginalFilename());

            linkImg = System.currentTimeMillis() + "-"
                    + file.getOriginalFilename();

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverPath));

            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        pro.setImage(linkImg);
        this.productsService.saveProduct(pro);
        return "hello";
    }

}
