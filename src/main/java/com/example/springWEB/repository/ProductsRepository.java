package com.example.springWEB.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    public Products save(Products pro);

    public List<Products> findAll();

    public Products findById(long id);

    public void deleteById(long id);

    public Page<Products> findAll(Pageable pageable);
}
