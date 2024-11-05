package com.example.springWEB.service.toDel;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.toDel.Roless;
import com.example.springWEB.repository.toDel.RolessRepo;

@Service
public class RolessService {
    private RolessRepo rolessRepo;

    public RolessService(RolessRepo rolessRepo) {
        this.rolessRepo = rolessRepo;
    }

    public Roless findByNameRoless(String name) {
        return this.rolessRepo.findByName(name);
    }
}
