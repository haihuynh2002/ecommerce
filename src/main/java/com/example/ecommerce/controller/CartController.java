package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.CartDto;
import com.example.ecommerce.dto.CartUpdationRequest;
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    Cart cart;

    @Autowired
    CartService cs;

    @GetMapping
    public List<CartItem> get() {
        return cart.getItems();
    }

    @PostMapping
    public void addToCart(@RequestBody CartDto cartDto) {
        cs.addItem(cartDto);
    }

    @PutMapping
    public void UpdateItem(@RequestBody CartUpdationRequest request) {
        cs.updateItem(request);
    }

    @DeleteMapping("/{id}")
    public void removeFromCart(@PathVariable("id") Long id) {
        cart.removeItem(id);
    }
}
