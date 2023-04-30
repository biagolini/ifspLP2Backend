# Client Data Processor

Este projeto é uma aplicação Spring Boot que processa dados de clientes a partir de arquivos CSV e JSON, aplica regras de negócio e expõe os dados por meio de uma API RESTful. A aplicação utiliza o gerenciador de dependências Maven.

## Contexto do projeto

Este projeto faz parte da avaliação final da disciplina Linguagem de Programação II, do curso Tecnologia em Análise e Desenvolvimento de Sistemas, ministrada no Instituto Federal de Educação, Ciência e Tecnologia de São Paulo - Câmpus São Paulo. A disciplina foi cursada no primeiro semestre de 2023. O objetivo deste projeto é integrar os conhecimentos adquiridos durante a disciplina, aplicando os conceitos de desenvolvimento de aplicações e serviços web com a linguagem Java. Além disso, busca-se demonstrar a compreensão dos fundamentos de arquiteturas de aplicações web e a utilização de ambientes de desenvolvimento integrado.

## Estrutura do Projeto

O projeto segue uma estrutura básica de pastas e arquivos apresentados abaixo:

```
project_root/
│
├── src/
│      └── main/
│             └──java/br/edu/ifsp/spo/clientdataprocessor/
│                                                       ├── controllers/
│                                                       ├── dto/
│                                                       ├── entity/
│                                                       ├── repository/
│                                                       ├── service/
│                                                       └── Main.java
│      └── resources/
│                └── application.properties
└─ pomxml
```

## Aspectors importantes da arquitetura

A estrutura do projeto segue o padrão MVC (Model-View-Controller), onde cada componente tem uma função específica:

- `controllers/`: Diretório que contém os controladores responsáveis por lidar com as requisições HTTP e retornar as respostas para o cliente.
- `dto/`: Diretório que contém os objetos de transferência de dados (Data Transfer Objects) utilizados para transferir informações entre camadas do sistema.
- `entity/`: Diretório que contém as entidades do sistema, que representam as tabelas no banco de dados e são utilizadas pelo JPA (Java Persistence API) para realizar operações de persistência.
- `repository/`: Diretório que contém os repositórios, que são interfaces responsáveis por fornecer um conjunto de operações para interagir com o banco de dados.
- `service/`: Diretório que contém os serviços que encapsulam a lógica de negócios da aplicação, sendo a ponte entre os controladores e os repositórios.
- `Main.java`: Classe principal da aplicação, responsável por iniciar a aplicação Spring Boot.
- `pom.xml`: Documento que descreve todas as dependências necessárias para o projeto, como o Spring Boot Starter Data JPA, Spring Boot Starter Validation e Spring Boot Starter Web. Além disso, inclui dependências para conectar ao banco de dados MySQL e utilizar o Lombok, que simplifica a criação de classes em Java.

## Repositórios relacionados

- [Banco de dados](https://github.com/biagolini/ifspLP2SQLCodes): Repositório com os scripts SQL utilizados para criar e configurar o banco de dados MySQL, que armazena os dados processados pela aplicação.
- [Backend](https://github.com/biagolini/ifspLP2Backend): Repositório responsável pelo backend do projeto, contendo os códigos relacionados à API RESTful desenvolvida em Spring Boot.
- [Frontend](https://github.com/biagolini/ifspLP2Frontend): Repositório contendo o frontend do projeto, desenvolvido em Angular, que se integra com a API RESTful apresentada no backend.
