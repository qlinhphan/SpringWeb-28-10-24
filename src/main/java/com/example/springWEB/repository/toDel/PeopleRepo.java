package com.example.springWEB.repository.toDel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.toDel.People;

public interface PeopleRepo extends JpaRepository<People, Long> {

    public People save(People pe);

    public boolean existsByName(String name);
}
