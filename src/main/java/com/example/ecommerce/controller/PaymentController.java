/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.PaymentService;
import com.example.ecommerce.service.UserService;

/**
 *
 * @author infoh
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    UserService us;

    @Autowired
    PaymentService ps;

    @PostMapping("/create")
    public ResponseEntity<Payment> create(@RequestBody Payment payment, 
            Authentication auth) {
        User user = us.findByAuthentication(auth);
        ps.create(user, payment);
        return ResponseEntity.ok(payment);
    }

    @PostMapping("/update")
    public ResponseEntity<Payment> update(@RequestBody Payment payment) {
        ps.update(payment);
        return ResponseEntity.ok(payment);
    }
    
    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        ps.delete(id);
    }
}
