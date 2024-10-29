/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderProduct;
import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.OrderProductRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.UserRepository;

/**
 *
 * @author infoh
 */
@Service
@Transactional
public class OrderService {

    @Autowired
    Cart cart;
    
    @Autowired
    UserService us;
    
    @Autowired
    ProductService bs;
    
    @Autowired
    OrderProductRepository obr;
    
    @Autowired
    OrderRepository or;
    
    @Autowired
    PaymentService ps;
    
    @Autowired
    UserRepository ur;

    public Order create(OrderDto orderDto, User user) {
        Payment payment = ps.findById(orderDto.getPaymentId());
        Order order = new Order();
        order.setUser(user);
        order.setPayment(payment);
        or.save(order);

        for(CartItem item: cart.getItems()) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(order);
            orderProduct.setProduct(item.getProduct());
            orderProduct.setPrice(item.getProduct().getPrice());
            orderProduct.setQuantity(item.getQuantity());
            obr.save(orderProduct);
        }

        cart.getItems().clear();
        return order;
    }
    
}
