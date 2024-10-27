/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author infoh
 */
@Entity
@Setter
@Getter
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal shippingPrice;
    private byte status;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updateAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    // private List<OrderProduct> orderProducts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    // @Transient
    // public BigDecimal getTotal() {
    // return orderProducts.stream()
    // .map(line -> line.getTotal())
    // .reduce(BigDecimal.ZERO, BigDecimal::add);
    // }

    // @Transient
    // public int getQuantity() {
    // return orderProducts.stream()
    // .mapToInt(line -> line.getQuantity())
    // .sum();
    // }

    @Transient
    public Date getShippingDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 5);
        return c.getTime();
    }
}
