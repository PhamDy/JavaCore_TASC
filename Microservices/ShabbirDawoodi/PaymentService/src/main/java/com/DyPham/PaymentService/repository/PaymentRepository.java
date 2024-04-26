package com.DyPham.PaymentService.repository;

import com.DyPham.PaymentService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<TransactionDetails, Long> {
}
