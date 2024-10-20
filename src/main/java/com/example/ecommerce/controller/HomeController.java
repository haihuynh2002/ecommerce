package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;

@Controller
public class HomeController {

    @Autowired
    UserService us;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/account")
    public String account() {
        return "account.html";
    }

    @GetMapping("/order")
    public String order() {
        return "order.html";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart.html";
    }

    @GetMapping("/shop")
    public String shop() {
        return "shop.html";
    }

    @GetMapping("/profile")
    public String profile(Model model, Authentication auth) {
        User user = us.findByAuthentication(auth);
        model.addAttribute("user", user);
        return "profile.html";
    }
}
