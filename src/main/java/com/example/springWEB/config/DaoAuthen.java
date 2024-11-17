package com.example.springWEB.config;

import java.security.Provider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.springWEB.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class DaoAuthen {

    private PasswordEncoder passwordEncoder;
    private CustomUserDetailsService customUserDetailsService;

    public DaoAuthen(PasswordEncoder passwordEncoder, CustomUserDetailsService customUserDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

}
