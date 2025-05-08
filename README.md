Integrantes:

RM99404 - Thiago Garcia Tonato
RM555502 - Ian Madeira Gonçalves da Silva

# API de Brinquedos

API REST para gerenciamento de brinquedos para crianças até 14 anos.

## Visão Geral do Projeto

Este projeto é uma API REST desenvolvida em Spring Boot para gerenciamento de brinquedos. A aplicação permite cadastrar, consultar e gerenciar brinquedos com suas características específicas.

## Arquitetura do Projeto

O projeto segue o padrão de arquitetura em camadas:

```
┌─────────────────┐
│    Controller   │  <- Camada de apresentação
└────────┬────────┘
         │
┌────────▼────────┐
│   Repository    │  <- Camada de persistência
└────────┬────────┘
         │
┌────────▼────────┐
│     Model       │  <- Camada de domínio
└─────────────────┘
```

## Estrutura do Projeto

```
src/main/java/com/fiap/brinquedos/
├── Main.java                    # Ponto de entrada da aplicação
├── controller/
│   └── BrinquedoController.java # Controlador REST
├── model/
│   └── Brinquedo.java          # Entidade de domínio
└── repository/
    └── BrinquedoRepository.java # Interface de persistência
```

## Classes e Suas Responsabilidades

### 1. BrinquedoController

- **Pacote**: `com.fiap.brinquedos.controller`
- **Responsabilidade**: Gerencia as requisições HTTP e coordena as operações CRUD
- **Métodos**:
  - `listarTodos()`: Retorna todos os brinquedos cadastrados
  - `buscarPorId(Long id)`: Busca um brinquedo específico pelo ID
  - `criar(Brinquedo brinquedo)`: Cria um novo brinquedo

### 2. Brinquedo

- **Pacote**: `com.fiap.brinquedos.model`
- **Responsabilidade**: Representa a entidade de domínio Brinquedo
- **Atributos**:
  - `id`: Identificador único (Long)
  - `nome`: Nome do brinquedo (String)
  - `tipo`: Tipo do brinquedo (String)
  - `classificacao`: Classificação etária (String)
  - `tamanho`: Tamanho do brinquedo (String)
  - `preco`: Preço do brinquedo (Double)

### 3. BrinquedoRepository

- **Pacote**: `com.fiap.brinquedos.repository`
- **Responsabilidade**: Interface de persistência que estende JpaRepository
- **Funcionalidades**: Fornece métodos padrão para operações CRUD

## Endpoints da API

### 1. Listar todos os brinquedos

- **Método**: GET
- **URL**: `/brinquedos`
- **Resposta**:
  ```json
  [
    {
      "id": 1,
      "nome": "Carrinho",
      "tipo": "Veículo",
      "classificacao": "3+",
      "tamanho": "Médio",
      "preco": 49.99
    }
  ]
  ```
- **Status**: 200 OK

### 2. Buscar brinquedo por ID

- **Método**: GET
- **URL**: `/brinquedos/{id}`
- **Resposta**:
  ```json
  {
    "id": 1,
    "nome": "Carrinho",
    "tipo": "Veículo",
    "classificacao": "3+",
    "tamanho": "Médio",
    "preco": 49.99
  }
  ```
- **Status**:
  - 200 OK (encontrado)
  - 404 Not Found (não encontrado)

### 3. Criar novo brinquedo

- **Método**: POST
- **URL**: `/brinquedos`
- **Request Body**:
  ```json
  {
    "nome": "Nome do Brinquedo",
    "tipo": "Tipo do Brinquedo",
    "classificacao": "Classificação Etária",
    "tamanho": "Tamanho do Brinquedo",
    "preco": 99.99
  }
  ```
- **Resposta**: Retorna o brinquedo criado com ID
- **Status**: 201 Created

## Configuração do Banco de Dados

1. Certifique-se de ter o Oracle Database instalado e rodando
2. Crie um banco de dados chamado `ORACLE_FIAP`
3. Atualize o arquivo `src/main/resources/application.properties` e `src/main/resources/META-INF/persistence.xml` com suas credenciais do banco de dados

## Estrutura do Banco de Dados

Tabela: `TDS_TB_BRINQUEDOS`

| Coluna        | Tipo     | Descrição            |
| ------------- | -------- | -------------------- |
| id            | NUMBER   | Chave primária       |
| nome          | VARCHAR2 | Nome do brinquedo    |
| tipo          | VARCHAR2 | Tipo do brinquedo    |
| classificacao | VARCHAR2 | Classificação etária |
| tamanho       | VARCHAR2 | Tamanho do brinquedo |
| preco         | NUMBER   | Preço do brinquedo   |

## Testando com Postman

1. Inicie a aplicação Spring Boot
2. Abra o Postman
3. Configure as requisições conforme os endpoints acima
4. Para criar um novo brinquedo, use o método POST com o body em formato JSON
5. Para consultar brinquedos, use o método GET

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- Oracle Database
- Maven
- Lombok

## Dependências Principais

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.oracle.database.jdbc</groupId>
        <artifactId>ojdbc8</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>
```

## Executando o Projeto

1. Clone o repositório
2. Configure o banco de dados Oracle
3. Defina as credenciais do banco de dados via variáveis de ambiente
4. Execute o comando: `mvn spring-boot:run`
5. A aplicação estará disponível em `http://localhost:8080`