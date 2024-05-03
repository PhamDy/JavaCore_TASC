package com.DyPham.PaymentService.exception;

public class PaymentNotFoundByOrderId extends RuntimeException{
    public PaymentNotFoundByOrderId(String message) {
        super(message);
    }
}
