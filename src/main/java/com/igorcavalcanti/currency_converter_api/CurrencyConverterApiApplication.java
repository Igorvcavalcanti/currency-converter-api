package com.igorcavalcanti.currency_converter_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CurrencyConverterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApiApplication.class, args);
	}

}
