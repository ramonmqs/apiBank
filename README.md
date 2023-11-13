# API Bank

API Bank é uma aplicação web que simula um banco digital. Ela foi construída usando uma arquitetura RESTful e permite aos usuários realizar várias operações bancárias, como verificar saldo, depositar dinheiro, realizar compras e transferências.

## Endpoints

A API possui os seguintes endpoints:

- `POST /api/compra`: Este endpoint permite ao usuário realizar uma compra. Ele recebe um objeto `Compra` no corpo da solicitação e retorna uma mensagem indicando se a compra foi aprovada ou negada.

- `POST /api/depositar`: Este endpoint permite ao usuário depositar dinheiro em sua conta. Ele recebe o ID do usuário e o valor do depósito como parâmetros da solicitação.

- `GET /api/saldo`: Este endpoint permite ao usuário verificar seu saldo. Ele recebe o ID do usuário como parâmetro da solicitação e retorna um objeto `Usuario` com as informações do usuário, incluindo o saldo.

- `POST /api/usuarios`: Este endpoint permite criar um novo usuário. Ele recebe um objeto `Usuario` no corpo da solicitação e retorna o objeto `Usuario` criado.

- `GET /api/usuarios`: Este endpoint retorna uma lista de todos os usuários.

- `PUT /api/usuarios/{id}/inativar`: Este endpoint permite inativar um usuário. Ele recebe o ID do usuário como parâmetro do caminho.

- `PUT /api/usuarios/{id}/status`: Este endpoint permite alterar o status de um usuário. Ele recebe o ID do usuário como parâmetro do caminho e um objeto com a chave `ativo` no corpo da solicitação.

- `GET /api/usuarios/{cpf}`: Este endpoint permite buscar um usuário por CPF. Ele recebe o CPF do usuário como parâmetro do caminho.

- `POST /api/transferir`: Este endpoint permite realizar uma transferência entre dois usuários. Ele recebe um objeto `TransferenciaDto` no corpo da solicitação.

## Tecnologias

O projeto foi desenvolvido com as seguintes tecnologias:

- [Spring Boot](https://spring.io/projects/spring-boot): Um framework Java que facilita a criação de aplicações stand-alone baseadas em Spring.

- [PostgreSQL](https://www.postgresql.org/): Um sistema de gerenciamento de banco de dados relacional de código aberto.

- [Hibernate](https://hibernate.org/): Uma framework para o mapeamento objeto-relacional para a linguagem Java.

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
```

## Execução

Para executar o projeto, você pode usar a ferramenta Spring Boot Maven Plugin com o comando `mvn spring-boot:run`.


