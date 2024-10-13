/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author infoh
 */
@Controller
// @RequestMapping("/admin")
public class AdminController {
    @GetMapping("/products")
    public String productManage() {
        return "product";
    }

    @GetMapping("/users")
    public String userManage() {
        return "user";
    }

    @GetMapping("/orders")
    public String orderManage() {
        return "order";
    }
}
