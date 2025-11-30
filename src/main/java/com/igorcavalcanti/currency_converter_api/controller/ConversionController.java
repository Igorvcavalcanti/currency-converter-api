package com.igorcavalcanti.currency_converter_api.controller;


import com.igorcavalcanti.currency_converter_api.dto.response.ConversionResponse;
import com.igorcavalcanti.currency_converter_api.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ConversionController {

    private final ConversionService conversionService;

    @GetMapping("/convert")
    public ResponseEntity<ConversionResponse> convert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam BigDecimal amount

    ) {
        ConversionResponse response = conversionService.convert(from, to, amount);
        return ResponseEntity.ok(response);
    }
}
