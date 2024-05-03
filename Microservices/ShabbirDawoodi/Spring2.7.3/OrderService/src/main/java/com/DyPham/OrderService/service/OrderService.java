package com.DyPham.OrderService.service;

import com.DyPham.OrderService.model.OrderRequest;
import com.DyPham.OrderService.model.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}
