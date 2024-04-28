# Consignado
# Nome do Projeto


#Premissas 
- a parte de cadastro é feita por outro sistema, consumos os dados dos clientes
- projeto é um MVP

## Descrição

Este projeto é uma aplicação baseada em Java que fornece funcionalidades para gerenciamento de consignados. Inclui recursos para listar simulações por CPF, obter detalhes do cliente, listar consignados por CPF e realizar simulações.

Este projeto é uma aplicação web construída com Spring Boot utilizando Java 17. Ele utiliza o padrão arquitetural MVC (Model-View-Controller) para garantir uma clara separação das camadas de apresentação, lógica de negócios e persistência de dados. Essa abordagem proporciona uma organização eficiente do código, facilitando sua manutenção e escalabilidade.

Os principais critérios para a escolha da arquitetura MVC incluem agilidade na atualização da interface da aplicação, facilidade de manutenção do código, implementação simplificada de camadas de segurança e integração de equipes de desenvolvedores.

Para a criação dos serviços web, foi utilizado o Spring Web Services, permitindo a exposição de APIs RESTful para comunicação entre sistemas de forma simples e eficiente. Além disso, o Mastruct foi empregado para a conversão de dados entre a camada de modelo e as representações de dados usadas nas requisições e respostas HTTP, simplificando o desenvolvimento e reduzindo a quantidade de código necessário.
O banco de dados em memória H2 foi escolhido para simplificar o desenvolvimento e os testes, proporcionando um ambiente de desenvolvimento isolado e de fácil configuração.

Para garantir a qualidade da aplicação, foram implementados testes unitários para validar as funcionalidades e testes integrados para verificar a interação entre os componentes do sistema.
## Recursos

1. **Listar Simulações por CPF**: Este recurso permite aos usuários recuperar uma lista de simulações associadas a um CPF específico.
```
curl --location --request GET 'http://localhost:8000/v0/consignado/simulacoes/075.178.955-08' \
--header 'Content-Type: application/json' \
```
2. **Obter Detalhes do Cliente**: Este recurso permite aos usuários recuperar detalhes de um cliente associado a um CPF específico.

3. **Listar Consignados por CPF**: Este recurso permite aos usuários recuperar uma lista de consignados associados a um CPF específico.

4. **Realizar Simulações**: Este recurso permite aos usuários realizar simulações.
```
curl --location --request POST 'http://localhost:8000/v0/consignado/simulacao' \
--header 'Content-Type: application/json' \
--data-raw '{
"CPF":"075.178.955-08",
"quantParcelas": 36,
"valorSolicitado": 5000.00
}'
```
## Configuração e Instalação

Para executar o projeto, você pode usar o Maven:

```bash
mvn spring-boot:run
```
Ou pode executar o arquivo JAR gerado:

```
java -jar seguros-0.0.1-SNAPSHOT.jar
```
## Uso

Forneça instruções sobre como usar o seu projeto.

## Testes

Este projeto inclui testes unitários e de integração. Os testes cobrem os principais recursos da aplicação.

```
curl --location --request POST 'http://localhost:8000/v0/consignado/contratar' \
--header 'Content-Type: application/json' \
--data-raw '{
"CPF":"075.178.955-08",
"idConsigando": 1
}'
```

-- listar 


