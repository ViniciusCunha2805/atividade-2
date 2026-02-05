# Atividade 2: Desenvolvimento de API REST com Spring Boot

Este projeto consiste em uma API REST para gerenciamento e autenticação de usuários, desenvolvida como parte da Tarefa 02. A aplicação permite o ciclo completo de CRUD de usuários e possui um endpoint dedicado para validação de login.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Maven** (Gerenciador de dependências)

---

## 🛠️ Documentação da API

### Endpoints de Usuários (`/users`)

| Método     | Endpoint         | Descrição                                                    |
| ---------- | ---------------- | ------------------------------------------------------------ |
| **POST**   | `/users`         | Cadastra um novo usuário no sistema.                         |
| **GET**    | `/users`         | Retorna a lista de todos os usuários cadastrados.            |
| **PUT**    | `/users/{login}` | Atualiza os dados de um usuário existente com base no login. |
| **DELETE** | `/users/{login}` | Remove um usuário do sistema.                                |

**Exemplo de Corpo de Requisição (JSON):**

```json
{
  "name": "Vinicius Cunha",
  "login": "vini123",
  "password": "senha_segura"
}
```

### Endpoint de Autenticação (`/auth`)

| Método   | Endpoint      | Descrição                                                          |
| -------- | ------------- | ------------------------------------------------------------------ |
| **POST** | `/auth/login` | Valida as credenciais (login e senha) contra os dados cadastrados. |

**Exemplo de Resposta:**

- **Sucesso (200 OK):** `"Login successful"`
- **Falha (401 Unauthorized):** `"Invalid login or password"`

---

## 📝 Relatório de Desenvolvimento

### 1. Etapas Realizadas

- **Arquitetura em Camadas:** Diferente de uma implementação simples, optei por criar uma camada de **Service** (`UserService`). Isso permitiu que o `UserController` e o `AuthController` compartilhassem a mesma instância da lista de usuários em memória, garantindo a integridade dos dados entre os contextos de cadastro e login.
- **Injeção de Dependência:** Utilizei a injeção via construtor para integrar o Service aos Controllers, seguindo as melhores práticas do Spring Framework.
- **Padronização REST:** Implementei o uso de `ResponseEntity` para garantir que a API retorne códigos de status HTTP semanticamente corretos (ex: 201 para criação, 401 para falha de autenticação).

### 2. Desafios e Soluções

- **Compartilhamento de dados:** O maior desafio foi garantir que o controlador de autenticação enxergasse os usuários criados no controlador de cadastro. A solução foi o desacoplamento da lógica para um componente `@Service` único.
- **Gestão de Portas:** Conflitos com a porta 8080 (usada na Atividade 1) foram resolvidos através do monitoramento de processos e containers ativos no ambiente de desenvolvimento.

### 3. Possíveis Melhorias

- **Persistência de Dados:** Integração com banco de dados H2 ou PostgreSQL via Spring Data JPA.
- **Segurança:** Implementação do **Spring Security** com autenticação baseada em tokens JWT (Stateless).
- **Validações:** Adição de anotações `@Valid` e `@NotBlank` para validação automática de campos no modelo.

---

## 🏃 Como Replicar

1. Certifique-se de ter o Java 17 e Maven instalados.
2. Clone o repositório ou extraia o código-fonte.
3. No diretório raiz, execute: `mvn spring-boot:run`.
4. Utilize o comando `curl` ou ferramentas como Postman/Insomnia para interagir com os endpoints descritos acima.

---
