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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserAPIController {
    @Autowired
    UserService us;

    @Autowired
    ProductService ps;

    @GetMapping
    public List<User> getAll() {
        return us.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") Long id) {
        User User = us.findById(id);
        return ResponseEntity.ok(User);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestPart("image") MultipartFile image, @RequestPart User User) {
        us.adminCreate(User, image);
        return ResponseEntity.ok(User);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User User) {
        User.setId(id);
        us.update(User, null);
        return ResponseEntity.ok(User);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        User user = us.findById(id);
        us.delete(user);
    }
}
