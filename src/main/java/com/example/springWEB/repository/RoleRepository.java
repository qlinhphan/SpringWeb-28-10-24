package com.example.springWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    public Roles findByName(String name);
}
