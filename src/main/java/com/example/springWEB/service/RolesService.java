package com.example.springWEB.service;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Roles;
import com.example.springWEB.repository.RoleRepository;

@Service
public class RolesService {
    private RoleRepository roleRepository;

    public RolesService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Roles findRolesByName(String name) {
        return this.roleRepository.findByName(name);
    }
}
