/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Payment;

/**
 *
 * @author infoh
 */
public interface PaymentRepository extends JpaRepository<Payment, Long>{
    List<Payment> findByUserId(Long id);
}
