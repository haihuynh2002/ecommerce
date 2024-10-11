/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.OrderProduct;
import com.example.ecommerce.model.key.OrderProductKey;

/**
 *
 * @author infoh
 */
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductKey>{
}
