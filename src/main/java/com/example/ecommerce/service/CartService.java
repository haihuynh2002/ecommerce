package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CartDto;
import com.example.ecommerce.dto.CartUpdationRequest;
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartService {

  @Autowired
  private ProductService ps;

  @Autowired
  private Cart cart;

  public void addItem(CartDto cartDto) {
    Product product = ps.findById(cartDto.getProductId());
    cart.addItem(product, cartDto.getQuantity());
  }

  public void deleteItem(Long productId) {
    cart.getItems().removeIf(item -> item.getProduct().getId() == productId);
  }

  public void updateItem(CartUpdationRequest request) {
    if(request.getQuantity() == 0) {
      deleteItem(request.getProductId());
      return;
    }
    
    log.info("product id {}", request.getProductId());
    CartItem item = cart.getItems().stream().filter(i -> i.getProduct().getId() == request.getProductId()).findFirst()
        .get();
    item.setQuantity(request.getQuantity());
  }
}
