package com.example.springWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    public Products save(Products pro);
}
