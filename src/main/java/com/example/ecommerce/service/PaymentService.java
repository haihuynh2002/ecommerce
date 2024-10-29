/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.PaymentRepository;
import com.example.ecommerce.repository.UserRepository;

/**
 *
 * @author infoh
 */
@Service
@Transactional
public class PaymentService {

    @Autowired
    PaymentRepository pr;

    @Autowired
    UserService us;

    @Autowired
    UserRepository ur;

    public Payment create(User user, Payment payment) {
        payment.setUser(user);
        return pr.save(payment);
    }

    public Payment update(Payment payment) {
        return pr.save(payment);
    }

    public void delete(Long id) {
        pr.deleteById(id);
    }

    public List<Payment> findByUserId(Long userId) {
        return pr.findByUserId(userId);
    }

    public Payment findById(Long id) {
        return pr.findById(id).orElse(null);
    }
}
