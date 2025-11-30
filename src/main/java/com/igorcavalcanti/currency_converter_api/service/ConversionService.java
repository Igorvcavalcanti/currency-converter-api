package com.igorcavalcanti.currency_converter_api.service;

import com.igorcavalcanti.currency_converter_api.dto.response.ConversionResponse;
import com.igorcavalcanti.currency_converter_api.util.CurrencyRates;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ConversionService {

    public ConversionResponse convert(String from, String to, BigDecimal amount) {
        BigDecimal rate = CurrencyRates.getRate(from, to);

        if (rate == null) {
            throw new IllegalArgumentException("Conversion rate not available for " + from + " -> " + to);
        }

        BigDecimal converted = amount.multiply(rate)
                .setScale(2, RoundingMode.HALF_UP);

        return new ConversionResponse(
                from.toUpperCase(),
                to.toUpperCase(),
                amount.setScale(2, RoundingMode.HALF_UP),
                converted,
                rate
        );
    }
}
