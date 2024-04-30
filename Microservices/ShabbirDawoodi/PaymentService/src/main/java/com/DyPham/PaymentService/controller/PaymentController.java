package com.DyPham.PaymentService.controller;

import com.DyPham.PaymentService.model.PaymentRequest;
import com.DyPham.PaymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> doPayment(@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(
                paymentService.doPayment(paymentRequest),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getPaymentDetailsByOrderId(@PathVariable long orderId){
        return new ResponseEntity<>(paymentService.getPaymentDetailsByOrderId(orderId), HttpStatus.OK);
    }

}


