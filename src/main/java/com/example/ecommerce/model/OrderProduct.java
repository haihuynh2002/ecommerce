/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.model;

import java.math.BigDecimal;

import com.example.ecommerce.model.key.OrderProductKey;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author infoh
 */
@Entity
@Table(name = "order_product")
@Setter
@Getter
public class OrderProduct {

    @EmbeddedId
    @JsonIgnore
    private OrderProductKey id = new OrderProductKey();

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer quantity;
    private BigDecimal price;
    
    @Transient
    public BigDecimal getTotal() {
            return price.multiply(BigDecimal.valueOf(quantity));
    }
}
