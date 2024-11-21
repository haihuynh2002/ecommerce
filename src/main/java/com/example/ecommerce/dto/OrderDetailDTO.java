package com.example.ecommerce.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private Long orderID;
    private String createdAt;
    private BigDecimal orderShippingPrice;

    private List<OrderProductDTO> listProduct;

    private String userName;
    private String userEmail;
    private String userPhone;
    private String userAddress;

    public void setCreatedAt(Date createdAt) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy, HH:mm");
        this.createdAt = formatter.format(createdAt);
    }
}
