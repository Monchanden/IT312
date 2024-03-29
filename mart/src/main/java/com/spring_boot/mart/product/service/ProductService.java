package com.spring_boot.mart.product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring_boot.mart.product.entity.Product;

@Service
public interface ProductService {
    List<Product> findAll();

    ResponseEntity<?> all();

    ResponseEntity<String> update(@PathVariable Long id, @RequestBody Product updatedProduct);

    ResponseEntity<String> save(@RequestBody Product product);

    ResponseEntity<?> delete(@PathVariable Long id);

    ResponseEntity<String> updateQuantity(Long quantity, String ProductName);
}
