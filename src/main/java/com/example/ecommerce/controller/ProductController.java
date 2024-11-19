/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.service.UserService;

/**
 *
 * @author infoh
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    UserService us;

    @Autowired
    ProductService ps;

    @GetMapping
    public List<Product> getAll(@RequestParam(required = false) String keywords) {
        if (keywords != null && !keywords.isEmpty()) {

            return ps.searchProducts(keywords);
        } 
        return ps.findAll();

    }

    @GetMapping("/amount")
    int getAmount() {
        List<Product> products = ps.findAll();
        return products.size();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable("id") Long id) {
        Product product = ps.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestPart("image") MultipartFile image, @RequestPart Product product) {
        ps.create(product, image);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @RequestBody Product product) {
        product.setId(id);
        ps.update(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        ps.delete(id);
    }
}
