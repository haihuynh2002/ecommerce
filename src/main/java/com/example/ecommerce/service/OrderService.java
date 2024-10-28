/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.repository.OrderProductRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.PaymentRepository;
import com.example.ecommerce.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author infoh
 */
@Service
@Transactional
public class OrderService {
    
    @Autowired
    UserService us;
    
    @Autowired
    ProductService bs;
    
    @Autowired
    OrderProductRepository opr;
    
    @Autowired
    OrderRepository or;
    
    @Autowired
    PaymentRepository pr;
    
    @Autowired
    UserRepository ur;

    public List<OrderDTO> findAll() {
        return or.findAll().stream().map(order -> {
            OrderDTO dto = new OrderDTO();
            dto.setId(order.getId());
            dto.setCustomerName(order.getUser().getFullName());
            dto.setPhone(order.getUser().getPhone());
            dto.setEmail(order.getUser().getUsername());
            dto.setShippingPrice(order.getShippingPrice());
            dto.setCreatedAt(order.getCreatedAt());
            dto.setShippingDate(order.getShippingDate());
            dto.setStatus(order.getStatus());
            return dto;
        }).collect(Collectors.toList());
    }
    

}
