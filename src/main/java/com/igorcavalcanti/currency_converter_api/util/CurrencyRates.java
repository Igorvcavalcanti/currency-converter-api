package com.igorcavalcanti.currency_converter_api.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CurrencyRates {

    private static final Map<String, BigDecimal> RATES = new HashMap<>();

    static {
        // GBP para outras
        RATES.put("GBP-BRL", new BigDecimal("7.06"));
        RATES.put("GBP-USD", new BigDecimal("1.33"));
        RATES.put("GBP-EUR", new BigDecimal("1.14"));

        // BRL para outras
        RATES.put("BRL-GBP", new BigDecimal("0.14"));
        RATES.put("BRL-USD", new BigDecimal("0.19"));
        RATES.put("BRL-EUR", new BigDecimal("0.16"));

        // USD para outras
        RATES.put("USD-GBP", new BigDecimal("0.75"));
        RATES.put("USD-BRL", new BigDecimal("5.34"));
        RATES.put("USD-EUR", new BigDecimal("0.86"));
    }

    public static BigDecimal getRate(String from, String to) {
        return RATES.get(from.toUpperCase() + "-" + to.toUpperCase());
    }
}
