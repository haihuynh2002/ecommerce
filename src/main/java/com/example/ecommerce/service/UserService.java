/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.dto.PasswordDto;
import com.example.ecommerce.enumeration.Role;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.util.ImageUtil;

import lombok.AllArgsConstructor;

/**
 *
 * @author infoh
 */
@Service
@AllArgsConstructor
@Transactional
public class UserService {
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
        user.setRole(Role.USER.name());
        return ur.save(user);
    }

    public User adminCreate(User user, MultipartFile image) {
        ur.findByUsername(user.getUsername()).ifPresent(u -> {
            throw new RuntimeException("user exists");
        });
        if (image != null) {
            String imageUrl = ImageUtil.saveImage(image, "src/main/resources/static/images/user/", "/images/user/");
            user.setImgUrl(imageUrl);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER.name());
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

    public User update(User user, MultipartFile image) {
        // User user = findById(newUser.getId());
        if (image != null) {
            String imageUrl = ImageUtil.saveImage(image, "src/main/resources/static/images/user/", "/images/user/");
            user.setImgUrl(imageUrl);
        }
        return ur.save(user);
    }

    public void delete(User user) {
        ur.delete(user);
    }

    public void changePassword(User user, PasswordDto passwordDto) {
        if (!passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword())) {
            throw new RuntimeException("Password does not match");
        }

        if (!passwordEncoder.matches(passwordDto.getOldPassword(), user.getPassword())) {
            throw new RuntimeException("Old password is not correct");
        }

        user.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));
        ur.save(user);
    }
}
