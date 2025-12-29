# Currency Converter API

API REST desenvolvida em **Java 17**, **Spring Boot** e **Lombok**, criada para realizar conversões simples de moedas utilizando taxas de câmbio definidas em memória.

O projeto demonstra fundamentos essenciais de desenvolvimento back-end:
- Criação de endpoints REST
- Organização em camadas (Controller, Service, DTO, Util)
- Tratamento global de erros
- Uso de `BigDecimal` para cálculos financeiros

---

## ✨ Funcionalidades
- Conversão de moedas com validação de entrada
- Cache das taxas usando Spring Cache (`@EnableCaching` + `@Cacheable`)
- Documentação da API com Swagger / OpenAPI (springdoc 3.x)
- Tratamento global de erros com `@RestControllerAdvice`
- Respostas padronizadas com `ErrorResponse`

## 🧱 Tecnologias principais
- Java 17+
- Spring Boot 4.x
- Spring Web
- Spring Cache
- springdoc-openapi (Swagger UI)

---

## 📁 Estrutura do Projeto
```bash
src/main/java/com/igorcavalcanti/currency_converter_api
│── controller
│ └── ConversionController.java
│── dto
│ └── response
│ └── ConversionResponse.java
│── service
│ └── ConversionService.java
│── util
│ └── CurrencyRates.java
└── CurrencyConverterApiApplication.java
```
---

## 🛠 Como rodar o projeto

### Pré-requisitos
- Java 17+
- Maven instalado
- IDE com suporte a Lombok (IntelliJ + Annotation Processing ativado)

### Executar via terminal

```bash
mvn spring-boot:run
```
Ou rode a classe principal:

CurrencyConverterApiApplication.java
A API estará disponível em:
http://localhost:8080

## 📌 Endpoints

### GET `/api/convert`
Realiza a conversão entre duas moedas.

**Parâmetros:**
| Nome   | Tipo       | Exemplo |
|--------|-------------|----------|
| from   | String      | GBP      |
| to     | String      | BRL      |
| amount | BigDecimal  | 100.00   |

**Exemplo de sucesso (200):**
```json
{
  "fromCurrency": "GBP",
  "toCurrency": "BRL",
  "originalAmount": 100.00,
  "convertedAmount": 706.00,
  "rate": 7.06
}
```

## 📚 Documentação (Swagger)

Após subir a aplicação:

Swagger UI: http://localhost:8080/swagger-ui/index.html

OpenAPI JSON: http://localhost:8080/v3/api-docs

**Exemplo de erro (400):**
```json
{
  "message": "Conversion rate not available for GBP -> XYZ",
  "timestamp": "2025-12-10T21:31:00Z"
}
```

## ❗ Tratamento de Erros
Se o usuário enviar uma combinação inválida, o sistema retorna:
```bash
{
  "status": 400,
  "message": "Conversion rate not available for GBP -> JPY"
}
```
Esse comportamento é gerenciado por um @RestControllerAdvice global.

## 💱 Taxas Utilizadas (exemplo)
As taxas estão definidas em memória no arquivo:

```bash
util/CurrencyRates.java
Exemplos:

GBP ➝ BRL = 7.06

BRL ➝ USD = 0.19

USD ➝ GBP = 0.75
```

### 🧩 Sobre as taxas
Atualmente as taxas são estáticas e armazenadas em memória (`CurrencyRates.java`) apenas para fins demonstrativos.
Em um cenário real, essa camada pode ser substituída por:
- Banco de dados
- API externa de câmbio
- Serviço interno da empresa


## 🧠 Arquitetura (resumo)

- controller – recebe a requisição HTTP e delega para o serviço

- service – contém a regra de negócio (conversão, uso de cache)

- util – taxas em memória (CurrencyRates)

- exception – exceções de domínio e handler global da API

- dto – objetos de entrada/saída expostos pela API

O cache é aplicado no RateService via @Cacheable("currencyRates"), o que permite evoluir futuramente para buscar taxas de uma API externa sem alterar o contrato da aplicação.


## 🎯 Objetivo do Projeto
Este projeto foi criado para consolidar os seguintes conhecimentos:

Criação de APIs REST com Spring Boot

Uso de Lombok para reduzir boilerplate

Boas práticas de organização de pacotes

Cálculos com BigDecimal

Tratamento global de erros

Desenvolvimento orientado a camadas

Exposição de endpoint simples utilizando query params

## 🧩 Possíveis Melhorias Futuras (Roadmap)

Inserir testes unitários com JUnit + Mockito

Conectar a uma API real de câmbio

Criar Dockerfile

Habilitar CORS configurável

Implementar validação personalizada de moedas

## 📝 Licença
Este projeto é livre para uso educacional e profissional.

## 🧑‍💻 Autor
Igor Cavalcanti
Desenvolvedor Java | Spring Boot | Golang | APIs & Microsserviços
LinkedIn: https://www.linkedin.com/in/igor-cavalcanti
