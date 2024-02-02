package com.spring_boot.mart.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_boot.mart.product.entity.Payment;
import com.spring_boot.mart.product.entity.Product;
import com.spring_boot.mart.product.repository.ProductRepository;
import com.spring_boot.mart.product.service.PaymentService;
import com.spring_boot.mart.product.service.impl.ProductServiceImpl;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment")
    public String payment() {
        return "payment/index";
    }

    @GetMapping("/payment/create")
    public String createPayment() {
        return "payment/invoice";
    }

    @PostMapping("/payment/save")
    public ResponseEntity<?> savePayment(@RequestBody List<Payment> product) {
        return paymentService.save(product);
    }

    @GetMapping("")
    public String allProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product/index";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Product> products = productRepository.findById(id);
        model.addAttribute("products", products);
        return "product/detail";
    }

    @GetMapping("/create")
    public String create() {
        return "product/create";
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Optional<Product> products = productRepository.findById(id);
        model.addAttribute("products", products);
        return "product/update";
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productService.update(id, updatedProduct);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        Optional<Product> products = productRepository.findById(id);
        model.addAttribute("products", products);
        return "product/delete";
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }
}