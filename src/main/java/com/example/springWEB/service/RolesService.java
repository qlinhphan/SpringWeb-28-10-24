package com.example.springWEB.service;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Roles;
import com.example.springWEB.repository.RolesRepository;

@Service
public class RolesService {

    private RolesRepository rolesRepository;

    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public Roles findRolesByName(String name) {
        return this.rolesRepository.findByName(name);
    }
}
