/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author infoh
 */
@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String gender;
    private String phone;
    private boolean enabled = false;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updateAt;
    private String imageUrl;
    private String role = "USER";

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Payment> payments = new HashSet<>();

    public void addPayment(Payment payment) {
        this.getPayments().add(payment);
        payment.setUser(this);
    }

    public void removePayment(Payment payment) {
        this.getPayments().remove(payment);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
