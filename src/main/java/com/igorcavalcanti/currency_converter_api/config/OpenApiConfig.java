package com.igorcavalcanti.currency_converter_api.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public OpenAPI currencyConverterOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Currency Converter API")
                        .description("API para conversão de moedas usando taxas internas em memória, com cache aplicado às taxas.")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Igor Vitor Cavalcanti")
                                .url("https://github.com/Igorvcavalcanti")

                        )
                );
    }
}
