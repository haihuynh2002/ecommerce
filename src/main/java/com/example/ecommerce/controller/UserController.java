/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;

/**
 *
 * @author infoh
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService us;

    @GetMapping
    public ResponseEntity<User> get(Authentication auth) {
        User user = us.findByAuthentication(auth);
        return ResponseEntity.ok(user);
    }
}
