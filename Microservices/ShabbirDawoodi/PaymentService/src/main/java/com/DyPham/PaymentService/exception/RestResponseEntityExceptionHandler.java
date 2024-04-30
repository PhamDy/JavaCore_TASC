package com.DyPham.PaymentService.exception;

import com.DyPham.PaymentService.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.time.LocalDateTime;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PaymentNotFoundByOrderId.class)
    public ResponseEntity<ErrorResponse> handleCustomException(PaymentNotFoundByOrderId exception, WebRequest webRequest) {

        return new ResponseEntity<>(new ErrorResponse().builder()
                .errorMessage(exception.getMessage())
                .errorTime(Instant.now())
                .errorCode(HttpStatus.NOT_FOUND)
                .apiPath(webRequest.getDescription(false))
                .build(),
                HttpStatus.NOT_FOUND);
    }

}
