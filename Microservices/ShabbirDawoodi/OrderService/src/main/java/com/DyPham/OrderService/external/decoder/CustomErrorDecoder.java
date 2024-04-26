package com.DyPham.OrderService.external.decoder;

import com.DyPham.OrderService.exception.CustomException;
import com.DyPham.OrderService.external.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();

        log.info("::{}", response.request().url());
        log.info("::{}", response.request().headers());

        try {
            ErrorResponse errorResponse =
                    objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
            return new CustomException(errorResponse.getErrorMessage());

        } catch (IOException e) {
            throw  new CustomException("Internal Server Error. The number of products exceeds the allowable limit");
        }
    }
}
