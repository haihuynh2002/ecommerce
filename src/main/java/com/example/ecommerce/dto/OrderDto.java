package com.example.ecommerce.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Long paymentId;
    private String note;
}
