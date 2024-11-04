/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;

/**
 *
 * @author infoh
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService us;
    
    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        user.setUsername("me@gmail.com");
        model.addAttribute("register", user);
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("register") User user,
            BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        us.create(user);
        return "redirect:/auth/login";
    }
}
