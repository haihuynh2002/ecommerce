/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.PaymentService;
import com.example.ecommerce.service.UserService;

import lombok.extern.slf4j.Slf4j;


/**
 *
 * @author infoh
 */
@RestController
@RequestMapping("/api/payment")
@Slf4j
public class PaymentController {

    @Autowired
    UserService us;

    @Autowired
    PaymentService ps;

    @GetMapping
    public List<Payment> getByUser(Authentication auth) {
        User user = us.findByAuthentication(auth);
        return ps.findByUserId(user.getId());
    }
    
     @GetMapping("/{id}")
    public ResponseEntity<Payment> get(@PathVariable("id") Long id) {
        Payment payment = ps.findById(id);
        return ResponseEntity.ok(payment);
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody Payment payment, 
            Authentication auth) {
        User user = us.findByAuthentication(auth);
        ps.create(user, payment);
        return ResponseEntity.ok(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@RequestBody Payment payment, @PathVariable("id") Long id,
    Authentication auth) {
        User user = us.findByAuthentication(auth);
        payment.setUser(user);
        ps.update(payment);
        return ResponseEntity.ok(payment);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        ps.delete(id);
    }
}
