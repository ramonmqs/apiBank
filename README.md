# API Bank

API Bank é uma API RESTful simples para simular operações bancárias básicas.

## Endpoints

A API possui os seguintes endpoints:

- `POST /api/compra`: Realiza uma compra.
- `POST /api/depositar`: Deposita um valor para um usuário.
- `GET /api/saldo`: Verifica o saldo de um usuário.
- `POST /api/usuarios`: Cria um novo usuário.
- `GET /api/usuarios`: Lista todos os usuários.
- `PUT /api/usuarios/{id}/inativar`: Inativa um usuário.
- `PUT /api/usuarios/{id}/status`: Altera o status de um usuário.
- `GET /api/usuarios/{cpf}`: Busca um usuário por CPF.
- `POST /api/transferir`: Realiza uma transferência entre dois usuários.

## Tecnologias

O projeto foi desenvolvido com as seguintes tecnologias:

- Spring Boot
- PostgreSQL
- Hibernate

## Configuração

Para rodar o projeto localmente, você precisa configurar o arquivo `application.properties` com as informações do seu banco de dados PostgreSQL:

```properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.url=jdbc:postgresql://<seu_host>/<seu_banco_de_dados>
spring.datasource.username=<seu_usuario>
spring.datasource.password=<sua_senha>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
