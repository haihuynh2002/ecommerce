/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ecommerce.repository;

import com.example.ecommerce.model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author infoh
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o.id FROM Order o WHERE FUNCTION('MONTH', o.createdAt) = :month AND FUNCTION('YEAR', o.createdAt) = :year")
    List<Long> findByMonth(@Param("month") int month, @Param("year") int year);

    @Query("SELECT o.id FROM Order o WHERE FUNCTION('YEAR', o.createdAt) = :year")
    List<Long> findByYear(@Param("year") int year);

}
