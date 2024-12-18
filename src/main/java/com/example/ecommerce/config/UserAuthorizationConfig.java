/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author infoh
 */
@Configuration
@Order(3)
public class UserAuthorizationConfig {
    
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.formLogin(form -> form
                .loginPage("/auth/login")
                .loginProcessingUrl("/auth/login")
                .defaultSuccessUrl("/", false)
        );

        http.csrf(c -> c.disable());
                
        http.cors(c -> c.disable());

        http.sessionManagement( sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
        
        http.authorizeHttpRequests(c -> 
               c.requestMatchers("/auth/**").permitAll()
               .requestMatchers("/profile").hasRole("USER")
               .requestMatchers("/checkout").hasRole("USER")
               .anyRequest().permitAll()
        );
        
        http.logout(c -> c.logoutUrl("/auth/logout")
                .logoutSuccessUrl("/")
        );
        
        return http.build();
    }
}
