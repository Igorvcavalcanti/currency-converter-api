package com.igorcavalcanti.currency_converter_api.exception;

public class RateNotFoundException extends RuntimeException {
    public RateNotFoundException(String message) {
        super(message);
    }
}
