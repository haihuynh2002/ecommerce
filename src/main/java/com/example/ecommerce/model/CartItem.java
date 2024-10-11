package com.example.ecommerce.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartItem {
    
    private Product product;
    private int quantity;

    public BigDecimal getSubTotal() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
