# API Bank

Este é um projeto de API Rest em Spring Boot para um sistema bancário simples.

A aplicação está atualmente hospedada em [https://api-bank-3fim.onrender.com](https://api-bank-3fim.onrender.com).

## Visão Geral

O **API Bank** é uma aplicação bancária que oferece funcionalidades básicas, como realização de compras, depósitos, consulta de saldo, gerenciamento de usuários e transferências entre contas.

## Configuração

### Requisitos do Sistema

- Java 11 ou superior
- Maven
- PostgreSQL

### Configuração do Banco de Dados

O projeto utiliza um banco de dados PostgreSQL. Certifique-se de ter um servidor PostgreSQL em execução. As configurações do banco de dados podem ser ajustadas no arquivo `application.properties`:

```properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.url=jdbc:postgresql://seu-host-do-postgres/sua-base-de-dados
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
```

### Compilação e Execução

Para compilar e executar o projeto localmente, use o seguinte comando:

```bash
mvn spring-boot:run
```

O aplicativo estará disponível em [https://api-bank-3fim.onrender.com](https://api-bank-3fim.onrender.com).

## Endpoints

A API fornece os seguintes endpoints:

- `POST /api/compra`: Realiza uma compra.
- `POST /api/depositar`: Realiza um depósito na conta de um usuário.
- `GET /api/saldo`: Verifica o saldo de um usuário.
- `POST /api/usuarios`: Cria um novo usuário.
- `GET /api/usuarios`: Lista todos os usuários ativos.
- `PUT /api/usuarios/{id}/inativar`: Inativa um usuário.
- `PUT /api/usuarios/{id}/status`: Altera o status de um usuário (ativo/inativo).
- `GET /api/usuarios/{cpf}`: Obtém informações sobre um usuário específico por CPF.
- `POST /api/transferir`: Realiza uma transferência entre contas.

## Exemplos de Uso

1. **Realizar uma compra:**

```bash
curl -X POST -H "Content-Type: application/json" -d '{"usuarioId": 1, "valor": 500.0}' https://api-bank-3fim.onrender.com/api/compra
```

2. **Realizar um depósito:**

```bash
curl -X POST -H "Content-Type: application/json" -d '{"usuarioId": 1, "valor": 1000.0}' https://api-bank-3fim.onrender.com/api/depositar
```

3. **Verificar saldo:**

```bash
curl https://api-bank-3fim.onrender.com/api/saldo?usuarioId=1
```

4. **Criar um novo usuário:**

```bash
curl -X POST -H "Content-Type: application/json" -d '{"nome": "Nome do Usuário", "cpf": "123.456.789-01", "saldo": 1000.0}' https://api-bank-3fim.onrender.com/api/usuarios
```

5. **Listar todos os usuários:**

```bash
curl https://api-bank-3fim.onrender.com/api/usuarios
```

6. **Inativar um usuário:**

```bash
curl -X PUT https://api-bank-3fim.onrender.com/api/usuarios/1/inativar
```

7. **Alterar o status de um usuário:**

```bash
curl -X PUT -H "Content-Type: application/json" -d '{"ativo": false}' https://api-bank-3fim.onrender.com/api/usuarios/1/status
```

8. **Buscar usuário por CPF:**

```bash
curl https://api-bank-3fim.onrender.com/api/usuarios/123.456.789-01
```

9. **Realizar transferência:**

```bash
curl -X POST -H "Content-Type: application/json" -d '{"remetenteId": 1, "destinatarioId": 2, "valor": 200.0}' https://api-bank-3fim.onrender.com/api/transferir
```

Lembre-se de substituir os valores nos exemplos pelos dados reais da sua aplicação. Este README fornece um guia básico; sinta-se à vontade para expandi-lo com mais informações específicas do seu projeto.


