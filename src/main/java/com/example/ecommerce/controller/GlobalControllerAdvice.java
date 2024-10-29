package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ecommerce.model.Cart;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private Cart cart;

    @ModelAttribute(value = "cart")
    public Cart cart() {
        return cart;
    }
}
