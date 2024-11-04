package com.example.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderDto {
    @NotNull(message = "Please add payment to checkout")  
    private Long paymentId;
    private String note;
}
