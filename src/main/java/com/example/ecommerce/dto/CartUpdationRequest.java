package com.example.ecommerce.dto;

import lombok.Data;

@Data
public class CartUpdationRequest {
    private Long productId;
    private Integer quantity;
}
