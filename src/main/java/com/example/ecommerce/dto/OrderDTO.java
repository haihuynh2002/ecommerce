package com.example.ecommerce.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private String customerName;
    private String phone;
    private String email;
    private BigDecimal shippingPrice;
    private Date createdAt;
    private Date shippingDate;
    private byte status;
}
