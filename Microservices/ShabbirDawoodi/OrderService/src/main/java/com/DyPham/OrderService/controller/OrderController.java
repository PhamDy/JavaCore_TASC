package com.DyPham.OrderService.controller;

import com.DyPham.OrderService.external.client.PaymentService;
import com.DyPham.OrderService.model.OrderRequest;
import com.DyPham.OrderService.model.OrderResponse;
import com.DyPham.OrderService.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest){
        long orderId = orderService.placeOrder(orderRequest);
        log.info("Order Id: {}", orderId);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderDetails(@PathVariable long orderId){
        OrderResponse orderResponse = orderService.getOrderDetails(orderId);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

}
