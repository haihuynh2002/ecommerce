/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.example.ecommerce.enumeration.Role;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ProjectConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ApplicationRunner applicationRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if(userRepository.findByUsername("admin@gmail.com").isEmpty()) {
                User user = new User();
                user.setUsername("admin@gmail.com");
                user.setPassword(passwordEncoder.encode("admin"));
                user.setRole(Role.ADMIN.name());
                userRepository.save(user);
                log.warn("admin user has been created with default username: admin@gmail.com and password: admin, please change it");
            }
        };
    }
}
