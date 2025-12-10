package com.igorcavalcanti.currency_converter_api.service;

import com.igorcavalcanti.currency_converter_api.dto.response.ConversionResponse;
import com.igorcavalcanti.currency_converter_api.util.CurrencyRates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class ConversionService {

    private final RateService rateService;

    public ConversionResponse convert(String from, String to, BigDecimal amount) {
        BigDecimal rate = rateService.getRate(from, to);

        if (rate == null) {
            throw new IllegalArgumentException("Conversion rate not available for " + from + " -> " + to);
        }

        BigDecimal normalizedAmount = amount.setScale(2, RoundingMode.HALF_UP);

        BigDecimal converted = normalizedAmount
                .multiply(rate)
                .setScale(2, RoundingMode.HALF_UP);

        return new ConversionResponse(
                from.toUpperCase(),
                to.toUpperCase(),
                normalizedAmount,
                converted,
                rate
        );
    }
}