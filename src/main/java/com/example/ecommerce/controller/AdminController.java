package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/product")
    public String productManage() {
        return "product";
    }

    @GetMapping("/user")
    public String userManage() {
        return "user";
    }

    @GetMapping("/orders")
    public String orderManage() {
        return "order";
    }
}
