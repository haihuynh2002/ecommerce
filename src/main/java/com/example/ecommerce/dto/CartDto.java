package com.example.ecommerce.dto;

import lombok.Data;

@Data
public class CartDto {

    private Long productId;
    private Integer quantity;
}
