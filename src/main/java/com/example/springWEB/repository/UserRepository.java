package com.example.springWEB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    public Users save(Users user);

    public List<Users> findAll();

    public Users findById(long id);

    public void deleteById(long id);
}
