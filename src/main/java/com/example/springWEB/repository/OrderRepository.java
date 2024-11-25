package com.example.springWEB.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.Users;

public interface OrderRepository extends JpaRepository<Oders, Long> {
    public Oders save(Oders oders);

    public List<Oders> findAll();

    public Oders findById(long id);

    public Oders deleteById(long id);

    public List<Oders> findByUsers(Users user);

    public Page<Oders> findAll(Pageable pageable);
}
