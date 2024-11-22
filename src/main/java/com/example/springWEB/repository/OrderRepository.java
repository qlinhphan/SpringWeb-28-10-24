package com.example.springWEB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Oders;

public interface OrderRepository extends JpaRepository<Oders, Long> {
    public Oders save(Oders oders);

    public List<Oders> findAll();

    public Oders findById(long id);

    public Oders deleteById(long id);
}
