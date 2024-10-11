package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.dto.CartDto;
import com.example.ecommerce.model.Product;

@Service
public class CartService {

    @Autowired
    private ProductService ps;

    @Autowired
    private Cart cart;

    public void addItem(CartDto cartDto) {
		Product product = ps.findById(cartDto.getProductId());
		cart.addItem(product, cartDto.getQuantity());
	}

}
