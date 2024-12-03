package com.example.springWEB.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Users;
import com.example.springWEB.domain.cart.feedBack;
import com.example.springWEB.domain.dto.RegisterDTO;
import com.example.springWEB.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
        kq.setPassword(passwordEncoder.encode(re.getPassword()));
        return kq;
    }

    public boolean existsByEmailUser(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public Users findUsersByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public Page<Users> findAllPage(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    // public Users fromFeedbackToUsers(feedBack feed) {
    // Users us = new Users();
    // us.setContent(feed.getContent());
    // us.setDate(new Date());
    // return us;
    // }

    public Users saveUser(Users us) {
        return this.userRepository.save(us);
    }

}
