package com.igorcavalcanti.currency_converter_api.controller;


import com.igorcavalcanti.currency_converter_api.dto.response.ConversionResponse;
import com.igorcavalcanti.currency_converter_api.service.ConversionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Currency Conversion", description = "Endpoints responsáveis pela conversão de moedas")
public class ConversionController {

    private final ConversionService conversionService;

    @GetMapping("/convert")
    @Operation(
            summary = "Converte valores entre duas moedas",
            description = "Realiza a conversao usando taaxas internas em memoria. Esse endpoint ja possui cache das taxas"
    )
    public ResponseEntity<ConversionResponse> convert(
            @Parameter(description = "Moeda de origem (ex: GBP)", example = "GBP")
            @RequestParam String from,

            @Parameter(description = "Moeda de destino (ex: BRL)", example = "BRL")
            @RequestParam String to,

            @Parameter(description = "Valor a ser convertido", example = "100.00")
            @RequestParam BigDecimal amount

    ) {
        return ResponseEntity.ok(conversionService.convert(from, to, amount));
    }
}
