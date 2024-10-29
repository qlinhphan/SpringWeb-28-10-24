package com.example.springWEB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Products;
import com.example.springWEB.repository.ProductsRepository;

@Service
public class ProductsService {

    private ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
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
}
