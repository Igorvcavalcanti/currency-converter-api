package com.igorcavalcanti.currency_converter_api.exception;


import com.igorcavalcanti.currency_converter_api.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RateNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRateNotFound(RateNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                Instant.now().toString()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
