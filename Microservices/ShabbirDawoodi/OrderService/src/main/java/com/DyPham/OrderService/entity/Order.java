package com.DyPham.OrderService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;

    @Column(name = "product_id")
    private long productId;
    private long quantity;

    @Column(name = "order_date")
    private Instant orderDate;

    @Column(name = "status")
    private String orderStatus;
    private long amount;

}
