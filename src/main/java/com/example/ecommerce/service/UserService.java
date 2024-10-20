/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;

import lombok.AllArgsConstructor;

/**
 *
 * @author infoh
 */
@Service
@AllArgsConstructor
@Transactional
public class UserService {

    private static String uploadDirectory = "src/main/resources/static/image/user/";
    private final PasswordEncoder passwordEncoder;
    private final UserRepository ur;

    public User findById(Long id) {
        return ur.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User is not found"));
    }

    public User findByAuthentication(Authentication auth) {
        return ur.findByUsername(auth.getName()).orElseThrow(
                () -> new UsernameNotFoundException("Email is not found"));
    }

    public User create(User user) {
        ur.findByUsername(user.getUsername()).ifPresent(u -> {
            throw new RuntimeException("user exists");
        });

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ur.save(user);
    }

    public User findUserById(Long id) {
        return ur.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("User not found"));
    }

    public List<User> findAll() {
        return ur.findAll();
    }

    public String saveImage(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        Path fileNameAndPath = Paths.get(uploadDirectory, fileName);
        Files.write(fileNameAndPath, file.getBytes());
        return "/image/user/" + fileName;
    }

    public User update(User newUser) {
        User user = findById(newUser.getId());
        user.setUsername(newUser.getUsername());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setPhone(newUser.getPhone());
        user.setGender(newUser.getGender());
        user.setEnabled(newUser.isEnabled());
        user.setRole(newUser.getRole());
        return ur.save(user);
    }

    public void delete(User user) {
        ur.delete(user);
    }
}
