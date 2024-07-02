# Projeto e-commerce

## Visão Geral
Projeto focado em aprendizado e implementação de conceitos de **Java**, ultilizando o framework **Quarkus**, ele inclui funcionalidades como inserção de produtos, método de pagamento, criação de cadastro, consulta de produtos, etc.

## Instalação

### Pré-requisito
- [`Quarkus 3.8.1`](https://pt.quarkus.io) _Versão ultilizada_
  #### Extensões ultilizadas
  - RESTEasy Classic jackson
  - RESTEasy Classic
  - SmallRye OpenAPI
  - JDBC Driver - PostgreSQL
  - Hibernate ORM with Panache
    
- [`Java 17.0.7`](https://www.oracle.com/java/technologies/javase/17-0-7-relnotes.html)  _Versão ultilizada_
- [`PostgreSQL`](https://www.postgresql.org)
- [`Maven 3.9.x`](https://maven.apache.org/download.cgi) 

## Passos para instalação

1. Clone o repositório:
   ```
   git clone https://github.com/HugoValuar03/ecommerce.git
   
   cd ecommerce
   ```
3. Instale os programas listados anteriormente
   
4. Inicie o servidor:
   ```
   ./mvnw compile quarkus:dev
   ```
5. Acesse a aplicação no navegador:
   [`http://localhost:8080`](http://localhost:8080)

## Testar a aplicação

- Crie um usuário
![image](https://github.com/HugoValuar03/ecommerce/assets/142545466/367b3e6f-069a-4cd9-ad7d-56e8daed4b60)
![image](https://github.com/HugoValuar03/ecommerce/assets/142545466/4dafc78d-4b5c-4d2b-a7a5-92742b991125)

- Ao criar um usuário, vá até o `Auth Resource`, coloque seu usuario, senha, e o tipo de usuário que no caso seria 2 para cliente
![image](https://github.com/HugoValuar03/ecommerce/assets/142545466/773a88f2-55b2-4c16-8f8e-a05bf18ec6b0)

# Contribuição
Contribuições são bem-vindas! Por favor, siga os passos abaixo para contribuir com o projeto:

1. Faça um fork do projeto.
2. Crie uma nova branch (git checkout -b feature/nova-feature).
3. Commit suas mudanças (git commit -m 'Adicionei uma nova feature').
4. Faça um push para a branch (git push origin feature/nova-feature).
5. Abra um Pull Request.


##### Por hora fiz somente o back-end, logo mais implementarei o front-end
