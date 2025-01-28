# Simple API CRUD

Este é um projeto de exemplo que implementa uma API RESTFUL simples em Kotlin com Spring Boot, permitindo operações CRUD (Criar, Ler, Atualizar e Deletar) em uma coleção gerenciada em memória.

---

## Tecnologias Utilizadas
- **Kotlin**: Linguagem principal do projeto.
- **Spring Boot**: Framework para criação de aplicações Java/Kotlin.
- **Maven**: Ferramenta de construção e dependências.

---

## Funcionalidades
- Criar um item (`POST`).
- Obter todos os itens (`GET`).
- Obter um item por ID (`GET` com parâmetro de URL).
- Atualizar um item existente (`PUT`).
- Remover um item da lista (`DELETE`).

---

## Modelo de Dados

Os itens neste projeto são representados pela classe `Item`. O modelo básico é:

```kotlin
data class Item(
    val id: Int, // Identificador único do item.
    var nome: String, // Nome do item.
    var descricao: String // Descrição detalhada do item.
)
```

---

## Rotas da API

### Obter todos os itens
- **Método**: `GET`
- **URL**: `/items`
- **Descrição**: Retorna a lista de todos os itens existentes.

---

### Obter um item por ID
- **Método**: `GET`
- **URL**: `/items/{id}`
- **Descrição**: Retorna um item específico pelo seu ID.
- **Exemplo de Resposta**:
    ```json
    {
      "id": 1,
      "nome": "Item de Exemplo",
      "descricao": "Descrição do item de exemplo"
    }
    ```

---

### Criar um novo item
- **Método**: `POST`
- **URL**: `/items/novo-item`
- **Descrição**: Cria um novo item com um ID auto-incrementado.
- **Exemplo de Corpo da Requisição**:
    ```json
    {
      "nome": "Novo Item",
      "descricao": "Descrição do novo item"
    }
    ```
- **Exemplo de Resposta**:
    ```json
    {
      "id": 1,
      "nome": "Novo Item",
      "descricao": "Descrição do novo item"
    }
    ```

---

### Atualizar um item existente
- **Método**: `PUT`
- **URL**: `/items/atualizar-item/{id}`
- **Descrição**: Atualiza os campos `nome` e `descricao` de um item existente.
- **Exemplo de Corpo da Requisição**:
    ```json
    {
      "nome": "Nome Atualizado",
      "descricao": "Descrição Atualizada"
    }
    ```
- **Exemplo de Resposta**:
    ```json
    {
      "id": 1,
      "nome": "Nome Atualizado",
      "descricao": "Descrição Atualizada"
    }
    ```

---

### Deletar um item
- **Método**: `DELETE`
- **URL**: `/items/deletar-item/{id}`
- **Descrição**: Remove um item da lista pelo seu ID.
- **Exemplo de Resposta**:
    ```json
    {
      "id": 1,
      "nome": "Item Deletado",
      "descricao": "Descrição do item deletado"
    }
    ```

---

## Melhorias Futuras
- Persistência em banco de dados utilizando **JPA**.
- Paginação e filtro nos endpoints `GET`.
- Validação adicional para as entradas do usuário.
- Implementação de testes unitários.

---