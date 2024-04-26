package com.DyPham.PaymentService.service;

import com.DyPham.PaymentService.entity.TransactionDetails;
import com.DyPham.PaymentService.model.PaymentRequest;
import com.DyPham.PaymentService.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details: {}", paymentRequest);
        TransactionDetails transactionDetails = TransactionDetails
                .builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("Success")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();
        paymentRepository.save(transactionDetails);
        log.info("Transaction Conpleted with Id: {}", transactionDetails.getId());
        return transactionDetails.getId();
    }
}
