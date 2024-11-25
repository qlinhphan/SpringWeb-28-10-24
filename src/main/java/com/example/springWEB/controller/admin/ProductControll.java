package com.example.springWEB.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.springWEB.domain.Products;
import com.example.springWEB.service.ProductsService;

import jakarta.servlet.ServletContext;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductControll {

    private ProductsService productsService;
    private ServletContext servletContext;

    public ProductControll(ProductsService productsService, ServletContext servletContext) {
        this.productsService = productsService;
        this.servletContext = servletContext;
    }

    // @GetMapping("/adminProduct")
    // public String adminDash(Model model) {
    // return "/admin/product/show";
    // }

    @GetMapping("/create/product")
    public String createProduct(Model model, @ModelAttribute("newProduct") Products pro) {
        return "/admin/product/create";
    }

    @PostMapping("/create/product/finish")
    public String createProductOk(Model model, @ModelAttribute("newProduct") Products pro,
            @RequestParam("imgProduct") MultipartFile file) {
        String linkImg = "";
        // String kqs = pro.getFactory();
        // System.out.println(kqs);
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
        return "redirect:/adminProduct";
    }

    @GetMapping("/adminProduct")
    public String getProducts(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 2);
        Page<Products> pagei = this.productsService.PaginationProduct(pageable);
        List<Products> products = pagei.getContent();
        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageable.getPageSize());
        // System.out.println(model.getAttribute("totalPages"));
        return "/admin/product/show";
    }

    @GetMapping("/showDetail/{id}")
    public String showDetail(Model model, @PathVariable long id) {
        Products pro = this.productsService.findProductById(id);
        model.addAttribute("product", pro);
        return "/admin/product/show_detail";
    }

    @GetMapping("/editProduct/{id}")
    public String getMethodName(Model model, @PathVariable long id) {
        Products pro = this.productsService.findProductById(id);
        model.addAttribute("product", pro);

        return "/admin/product/edit";
    }

    @PostMapping("/editProduct/finish")
    public String FinishEdit(Model model, @ModelAttribute("product") Products pro) {
        long id = pro.getId();
        System.out.println(id);
        Products current = this.productsService.findProductById(id);

        if (current != null) {
            current.setName(pro.getName());
            current.setPrice(pro.getPrice());
            current.setDetailDes(pro.getDetailDes());
            current.setShortDes(pro.getShortDes());
            current.setQuantity(pro.getQuantity());
            current.setFactory(pro.getFactory());
            current.setTarget(pro.getTarget());
        }
        this.productsService.saveProduct(current);
        return "redirect:/adminProduct";
    }

    @GetMapping("/del/product/{id}")
    public String delProduct(Model model, @PathVariable long id) {
        Products pro = this.productsService.findProductById(id);
        model.addAttribute("product", pro);
        return "/admin/product/del";
    }

    @PostMapping("/del/finish")
    public String delProductFinish(Model model, @ModelAttribute("product") Products pro) {
        this.productsService.DeleteProductById(pro.getId());
        return "redirect:/adminProduct";
    }

}
