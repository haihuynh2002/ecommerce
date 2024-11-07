package com.example.ecommerce.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Data
@Component(value = "cart")
@SessionScope
public class Cart {
	private List<CartItem> items;
	
	@PostConstruct
	public void init() {
		this.items = new ArrayList<>();
	}
	
	public void addItem(Product product, int quantity) {
		
		for(CartItem item: items) {
			if(item.getProduct().getId() == product.getId()) {
				item.setQuantity(item.getQuantity() + quantity);
				return;
			}
		}
		

        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(quantity);
        this.items.add(item);
	}
	
	public void removeItem(Product product) {
        this.items.removeIf(item -> item.getProduct().getId() == product.getId());
	}

	public void removeItem(Long id) {
        this.items.removeIf(item -> item.getProduct().getId() == id);
	}

	public BigDecimal getTotal() {
		return items.stream().reduce(BigDecimal.ZERO, (subtotal, item) -> subtotal.add(item.getSubTotal()), BigDecimal::add);
	}
}