package com.DyPham.ProductService.exception;

import lombok.Data;

@Data
public class ProductQuantityCustomException extends RuntimeException{
    public ProductQuantityCustomException(String message) {
        super(message);
    }
}
