package com.example.springWEB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.dto.RegisterDTO;
import com.example.springWEB.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users createUser(Users us) {
        return this.userRepository.save(us);
    }

    public List<Users> findAllUser() {
        return this.userRepository.findAll();
    }

    public Users findUserById(long id) {
        return this.userRepository.findById(id);
    }

    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    public Users registerDtoToUser(RegisterDTO re) {

        Users kq = new Users();
        kq.setFullname(re.getFirstName() + " " + re.getLastName());
        kq.setEmail(re.getEmail());
        kq.setPassword(re.getPassword());

        return kq;
    }

}
