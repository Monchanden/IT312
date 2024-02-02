package com.spring_boot.mart.product.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_boot.mart.product.entity.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findById(Long id);
}
