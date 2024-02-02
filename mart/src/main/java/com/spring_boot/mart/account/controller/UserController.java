package com.spring_boot.mart.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_boot.mart.account.dto.UserDto;
import com.spring_boot.mart.account.entity.User;
import com.spring_boot.mart.account.repository.UserRepository;
import com.spring_boot.mart.product.repository.ProductRepository;
import com.spring_boot.mart.product.service.impl.ProductServiceImpl;

@Controller
@RequestMapping(path = "/account")
public class UserController {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> validation(@RequestBody UserDto user) {
        User validation = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(validation != null){
            return ResponseEntity.ok("Login Successfully!");
        }
        return ResponseEntity.notFound().build();
    }
}