package com.DyPham.PaymentService.service;

import com.DyPham.PaymentService.model.PaymentRequest;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);
}
