package com.example.springWEB.service.toDel;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.toDel.People;
import com.example.springWEB.repository.toDel.PeopleRepo;

@Service
public class PeopleService {
    private PeopleRepo peopleRepo;

    public PeopleService(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    public People savePeople(People pe) {
        return this.peopleRepo.save(pe);
    }

    public boolean checkExistByEmail(String name) {
        return this.peopleRepo.existsByName(name);
    }
}
