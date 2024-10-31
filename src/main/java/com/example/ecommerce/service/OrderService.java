/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.dto.OrderDetailDTO;
import com.example.ecommerce.dto.OrderProductDTO;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.OrderProduct;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.OrderProductRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.PaymentRepository;
import com.example.ecommerce.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author infoh
 */
@Service
@Transactional
public class OrderService {
    
    @Autowired
    UserService us;
    
    @Autowired
    ProductService pr;
    
    @Autowired
    OrderProductRepository opr;
    
    @Autowired
    OrderRepository or;
    
    @Autowired
    PaymentRepository pmr;
    
    @Autowired
    UserRepository ur;

    public List<OrderDTO> findAll() {
        return or.findAll().stream().map(order -> {
            OrderDTO dto = new OrderDTO();
            dto.setId(order.getId());
            dto.setCustomerName(order.getUser().getFullName());
            dto.setPhone(order.getUser().getPhone());
            dto.setEmail(order.getUser().getUsername());
            dto.setShippingPrice(order.getShippingPrice());
            dto.setCreatedAt(order.getCreatedAt());
            dto.setShippingDate(order.getShippingDate());
            dto.setStatus(order.getStatus());
            return dto;
        }).collect(Collectors.toList());
    }

    public OrderDetailDTO getDetail(Long orderID) {
        Order order = or.findById(orderID).get();
        User user = order.getUser();
        List<OrderProductDTO> products = transOPToDTO(orderID);
        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setUserEmail(user.getUsername());
        dto.setUserName(user.getFullName());
        dto.setUserPhone(user.getPhone());
        dto.setOrderID(orderID);
        dto.setCreatedAt(order.getCreatedAt());
        dto.setOrderShippingPrice(order.getShippingPrice());
        dto.setListProduct(products);
        return dto;
    }

    public List<OrderProductDTO> transOPToDTO(Long orderID) {
        List<OrderProduct> products = opr.findByOrderId(orderID);
        List<OrderProductDTO> productsDTO = new ArrayList<>();
        for (OrderProduct product : products) {
            Product productInOrder = pr.findById(product.getId().getProductId());
            OrderProductDTO newOdPDTO = new OrderProductDTO(productInOrder.getId(), productInOrder.getName(),
                    productInOrder.getDescription(), productInOrder.getImgUrl(), product.getQuantity(),
                    product.getPrice(), product.getTotal());
            productsDTO.add(newOdPDTO);
        }
        return productsDTO;
    }
}
