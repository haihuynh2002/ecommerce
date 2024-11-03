package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private Cart cart;

    @Autowired
    private UserService userService;

    @ModelAttribute(value = "cart")
    public Cart cart() {
        return cart;
    }

    @ModelAttribute(value = "user")
    public User user(Authentication auth) {
        if(auth != null) {
            User user = userService.findByAuthentication(auth);
            return user;
        }
        return null;
    }
}
