package com.DyPham.PaymentService.service;

import com.DyPham.PaymentService.model.PaymentRequest;
import com.DyPham.PaymentService.model.PaymentResponse;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(long orderId);
}
