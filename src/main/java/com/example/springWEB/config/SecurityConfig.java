package com.example.springWEB.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public HttpFirewall httpFirewall() {
                StrictHttpFirewall firewall = new StrictHttpFirewall();
                firewall.setAllowSemicolon(true); // Cho phép ký tự ;
                firewall.setAllowUrlEncodedDoubleSlash(true); // Cho phép //
                return firewall;
        }

        // @Bean
        // public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        // return new CustomSuccessHandler();
        // }

        // @Bean
        // public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        // return new CustomSuccessHandler();
        // }

        @Bean
        public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
                return new CustomSuccessHandlers();
        }

        @Bean
        SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authorize -> authorize
                                                .dispatcherTypeMatchers(DispatcherType.FORWARD,
                                                                DispatcherType.INCLUDE)
                                                .permitAll()

                                                .requestMatchers("/", "/login", "/client/**", "/detail/**", "/page403",
                                                                "/css/**", "/js/**", "/images/**", "/register")
                                                .permitAll()

                                                .requestMatchers("/adminDash/**").hasRole("Admin")

                                                .anyRequest().authenticated())

                                .formLogin(formLogin -> formLogin
                                                .loginPage("/login")
                                                .failureUrl("/login?error")
                                                .successHandler(myAuthenticationSuccessHandler())
                                                .permitAll())

                                .exceptionHandling(ex -> ex.accessDeniedPage("/access-deny"))
                                .rememberMe(reM -> reM.key("uniqueAndSecret").tokenValiditySeconds(86400))
                                .logout(logout -> logout.deleteCookies("JSESSIONID"));

                return http.build();
        }

}
