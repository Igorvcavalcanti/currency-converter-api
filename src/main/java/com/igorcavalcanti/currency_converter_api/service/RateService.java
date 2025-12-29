package com.igorcavalcanti.currency_converter_api.service;


import com.igorcavalcanti.currency_converter_api.util.CurrencyRates;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RateService {

    @Cacheable("currencyRates")
    public BigDecimal getRate(String from, String to) {
        // Hoje faz o get no mapa em memoria
        return CurrencyRates.getRate(from, to);
    }
}
