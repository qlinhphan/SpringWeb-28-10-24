package com.example.springWEB.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // logic at here
        com.example.springWEB.domain.Users user = this.userService.findUsersByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        return new User(
                user.getEmail(),
                "{noop}" + user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLES_USER")));
    }

}
