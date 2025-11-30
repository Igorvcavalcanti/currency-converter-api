# Currency Converter API

API REST desenvolvida em **Java 17**, **Spring Boot** e **Lombok**, criada para realizar conversões simples de moedas utilizando taxas de câmbio definidas em memória.

O projeto demonstra fundamentos essenciais de desenvolvimento back-end:
- Criação de endpoints REST
- Organização em camadas (Controller, Service, DTO, Util)
- Tratamento global de erros
- Uso de `BigDecimal` para cálculos financeiros

---

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 4 (Web MVC)**
- **Lombok**
- **Maven**
- **Insomnia/Postman** (para testes)
- **Tomcat Embutido**

---

## 📁 Estrutura do Projeto

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

yaml
Copiar código

---

## 🛠 Como rodar o projeto

### Pré-requisitos
- Java 17+
- Maven instalado
- IDE com suporte a Lombok (IntelliJ + Annotation Processing ativado)

### Executar via terminal

```bash
mvn spring-boot:run
Ou rode a classe principal:

Copiar código
CurrencyConverterApiApplication.java
A API estará disponível em:

arduino
Copiar código
http://localhost:8080
📌 Endpoint Principal
GET /api/convert
Realiza a conversão de uma moeda para outra usando taxas fixas.

Nome	Tipo	Obrigatório	Exemplo
from	String	Sim	GBP
to	String	Sim	BRL
amount	BigDecimal	Sim	100

Exemplo de requisição:
sql
Copiar código
GET http://localhost:8080/api/convert?from=GBP&to=BRL&amount=100
Resposta:
json
Copiar código
{
  "from": "GBP",
  "to": "BRL",
  "originalAmount": 100.00,
  "convertedAmount": 706.00,
  "rate": 7.06
}
❗ Tratamento de Erros
Se o usuário enviar uma combinação inválida, o sistema retorna:

json
Copiar código
{
  "status": 400,
  "message": "Conversion rate not available for GBP -> JPY"
}
Esse comportamento é gerenciado por um @RestControllerAdvice global.

💱 Taxas Utilizadas (exemplo)
As taxas estão definidas em memória no arquivo:

Copiar código
util/CurrencyRates.java
Exemplos:

GBP ➝ BRL = 7.06

BRL ➝ USD = 0.19

USD ➝ GBP = 0.75

🎯 Objetivo do Projeto
Este projeto foi criado para consolidar os seguintes conhecimentos:

Criação de APIs REST com Spring Boot

Uso de Lombok para reduzir boilerplate

Boas práticas de organização de pacotes

Cálculos com BigDecimal

Tratamento global de erros

Desenvolvimento orientado a camadas

Exposição de endpoint simples utilizando query params

🧩 Possíveis Melhorias Futuras (Roadmap)
Adicionar documentação Swagger/OpenAPI

Inserir testes unitários com JUnit + Mockito

Conectar a uma API real de câmbio

Implementar cache das taxas

Criar Dockerfile

Habilitar CORS configurável

Implementar validação personalizada de moedas

📝 Licença
Este projeto é livre para uso educacional e profissional.

🧑‍💻 Autor
Igor Cavalcanti
Desenvolvedor Java | Spring Boot | Golang | APIs & Microsserviços
LinkedIn: https://www.linkedin.com/in/igor-cavalcanti