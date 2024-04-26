package com.DyPham.OrderService.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
