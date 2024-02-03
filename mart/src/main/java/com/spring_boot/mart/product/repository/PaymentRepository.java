package com.spring_boot.mart.product.repository;

import com.spring_boot.mart.product.entity.Payment;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findById(Long id);

    @Query(value = "SELECT product_name FROM tbl_product ", nativeQuery = true)
    List<Object[]> getAll();

    @Query(value = "SELECT unit_price FROM tbl_product WHERE product_name = :product ", nativeQuery = true)
    List<Object[]> getPrice(@Param("product") String product);
}
