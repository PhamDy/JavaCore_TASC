package com.DyPham.ProductService.exception;

import lombok.Data;

@Data
public class ProductServiceCustomException extends RuntimeException{
    public ProductServiceCustomException(String message) {
        super(message);
    }
}
