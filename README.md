
## Premissas 
- A parte de cadastro é feita por outro sistema, consumos os dados dos clientes
- O projeto é um MVP, sendo uma primeira versão demostrativa 


## Descrição

Este projeto é uma aplicação baseada em Java que fornece funcionalidades para gerenciamento de consignados. Inclui recursos para listar simulações por CPF, obter detalhes do cliente, listar consignados por CPF e realizar simulações.

Este projeto é uma aplicação web construída com Spring Boot utilizando Java 17. Ele utiliza o padrão arquitetural MVC (Model-View-Controller) para garantir uma clara separação das camadas de apresentação, lógica de negócios e persistência de dados. Essa abordagem proporciona uma organização eficiente do código, facilitando sua manutenção e escalabilidade.

Os principais critérios para a escolha da arquitetura MVC incluem agilidade na atualização da interface da aplicação, facilidade de manutenção do código, implementação simplificada de camadas de segurança e integração de equipes de desenvolvedores.

Para a criação dos serviços web, foi utilizado o Spring Web Services, permitindo a exposição de APIs RESTful para comunicação entre sistemas de forma simples e eficiente. Além disso, o Mastruct foi empregado para a conversão de dados entre a camada de modelo e as representações de dados usadas nas requisições e respostas HTTP, simplificando o desenvolvimento e reduzindo a quantidade de código necessário.
Este projeto utiliza o método nativo CPF, juntamente com uma expressão regular (regex), para garantir que apenas CPFs válidos e no formato desejado sejam aceitos pelo programa.

O projeto é estruturado em três classes de modelo, que implementam as regras de negócio. As classes são:

- Cliente
- Simulação
- Consignado

O projeto utiliza um banco de dados em memória H2 e possui três tabelas criadas para interações entre os dados. A relação entre as tabelas é estabelecida através do CPF do cliente.

A tabela de clientes contém informações sobre os clientes. A tabela de simulações contém informações sobre as simulações realizadas pelos clientes. A tabela de consignados contém informações sobre os consignados dos clientes.
Para garantir a qualidade da aplicação, foram implementados testes unitários para validar as funcionalidades e testes integrados para verificar a interação entre os componentes do sistema.
## Recursos

1. **Listar Simulações por CPF**: Este recurso permite aos usuários recuperar uma lista de simulações associadas a um CPF específico.
```
curl --location --request GET 'http://localhost:8000/v0/consignado/simulacoes/075.178.955-08' \
--header 'Content-Type: application/json' \
```
2. **Obter Detalhes do Cliente**: Este recurso permite aos usuários recuperar detalhes de um cliente associado a um CPF específico.
 ````
 curl --location --request GET 'http://localhost:8000/v0/consignado/cliente/444.444.444-44' \
--data-raw ''
 ````
3. **Listar Consignados por CPF**: Este recurso permite aos usuários recuperar uma lista de consignados associados a um CPF específico.
  ```
 curl --location --request GET 'http://localhost:8000/v0/consignado/consignados/075.178.955-08' \
   --header 'Content-Type: application/json' \
   --data-raw '{"CPF1":"@##!#1"}'
   ```
5. **Realizar Simulações**: Este recurso permite aos usuários realizar simulações.
```
curl --location --request POST 'http://localhost:8000/v0/consignado/simulacao' \
--header 'Content-Type: application/json' \
--data-raw '{
"CPF":"075.178.955-08",
"quantParcelas": 36,
"valorSolicitado": 5000.00
}'
```
6. **Listar clientes**: Este recurso lista todos os clientes na base
```
curl --location --request GET 'http://localhost:8000 /v0/consignado/clientes' \
--data-raw ''
```



## Uso

Para executar o projeto, você pode usar o Maven:

```bash
mvn spring-boot:run
```
Ou pode executar o arquivo JAR gerado.
Após clonado o projeto, abra o terminal e entre na pasta target:
```
java -jar Consignado-0.0.1-SNAPSHOT.jar"
```


## Testes

Este projeto inclui testes unitários e de integração. Os testes cobrem os principais recursos da aplicação.




