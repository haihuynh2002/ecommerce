package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.repository.OrderProductRepository;
import com.example.ecommerce.repository.OrderRepository;

@RequestMapping("/api/detail")
@RestController
public class OrderDetailController {
    @Autowired
    OrderProductRepository opr;

    @Autowired
    OrderRepository or;

}
