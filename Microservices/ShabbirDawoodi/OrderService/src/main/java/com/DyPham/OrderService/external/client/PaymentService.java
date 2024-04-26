package com.DyPham.OrderService.external.client;

import com.DyPham.OrderService.external.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Payment-Service/payment")
public interface PaymentService {
    @PostMapping
    ResponseEntity<?> doPayment(@RequestBody PaymentRequest paymentRequest);

}
