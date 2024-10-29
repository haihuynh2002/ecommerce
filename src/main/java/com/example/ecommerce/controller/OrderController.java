/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.ecommerce.service.OrderService;
import com.example.ecommerce.service.UserService;

@Controller
public class OrderController {

    @Autowired
    OrderService os;

    @Autowired
    UserService us;


}
