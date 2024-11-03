package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String index() {
        return "admin/dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("/products")
    public String productManage() {
        return "admin/product";
    }

    @GetMapping("/users")
    public String userManage() {
        return "admin/user";
    }

    @GetMapping("/orders")
    public String orderManage() {
        return "admin/order";
    }

}
