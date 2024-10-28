package com.example.ecommerce.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private String customerName;
    private String phone;
    private String email;
    private BigDecimal shippingPrice;
    private String createdAt;
    private String shippingDate;
    private byte status;

    public void setCreatedAt(Date createdAt) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.createdAt = formatter.format(createdAt);
    }

    public void setShippingDate(Date shippingDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.shippingDate = formatter.format(shippingDate);
    }
}
