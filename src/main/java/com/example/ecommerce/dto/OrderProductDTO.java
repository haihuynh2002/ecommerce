package com.example.ecommerce.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderProductDTO {
    private Long productId;
    private String productName;
    private String productDecs;
    private String productImgUrl;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal total;

    public OrderProductDTO(Long productId, String productName, String productDecs, String productImgUrl,
            Integer quantity, BigDecimal price, BigDecimal total) {
        this.productId = productId;
        this.productName = productName;
        this.productDecs = productDecs;
        this.productImgUrl = productImgUrl;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

}
