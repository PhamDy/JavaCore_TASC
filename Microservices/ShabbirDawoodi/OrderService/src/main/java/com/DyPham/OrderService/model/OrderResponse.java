package com.DyPham.OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private long orderId;
    private Instant orderDate;
    private String orderStatus;
    private long amount;
    private ProductDetails productDetails;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductDetails {
        private String name;
        private long id;
        private long quantity;
        private double price;
    }


}
