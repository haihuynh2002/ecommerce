package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/login")
    public String login() {
        return "admin-login";
    }

    @GetMapping("/product")
    public String productManage() {
        return "product";
    }

    @GetMapping("/user")
    public String userManage() {
        return "user";
    }
}
