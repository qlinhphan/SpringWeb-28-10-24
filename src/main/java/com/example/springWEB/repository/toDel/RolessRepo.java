package com.example.springWEB.repository.toDel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.toDel.Roless;

public interface RolessRepo extends JpaRepository<Roless, Long> {
    public Roless findByName(String name);
}
