/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.dto.OrderDetailDTO;
import com.example.ecommerce.service.OrderService;
import com.example.ecommerce.service.UserService;

/**
 *
 * @author infoh
 */
@RequestMapping("/api/order")
@RestController
public class OrderController {

    @Autowired
    OrderService os;

    @Autowired
    UserService us;

    @GetMapping
    public List<OrderDTO> getAll() {
        return os.findAll();
    }

    @GetMapping("/detail/{id}")
    public OrderDetailDTO getDetail(@PathVariable("id") Long orderID) {
        return os.getDetail(orderID);
    }

}
