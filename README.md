# Atividade 2: Desenvolvimento de API REST com Spring Boot

Este projeto consiste em uma API REST para gerenciamento e autenticação de usuários, desenvolvida como parte da Tarefa 02. A aplicação permite o ciclo completo de CRUD de usuários e possui um endpoint dedicado para validação de login, agora com suporte total a integração com Frontend (CORS) e segurança configurada.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 4.0.2** (Versão atualizada)
- **Spring Security** (Proteção e controle de acesso)
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

### Endpoint de Autenticação (`/auth`)

| Método   | Endpoint      | Descrição                                                          |
| -------- | ------------- | ------------------------------------------------------------------ |
| **POST** | `/auth/login` | Valida as credenciais (login e senha) contra os dados cadastrados. |

---

## 📝 Relatório de Desenvolvimento

### 1. Etapas Realizadas

- **Arquitetura em Camadas:** Uso de `UserService` para centralizar a lógica de negócio e persistência em memória, permitindo que múltiplos controllers acessem os mesmos dados.
- **Configuração de Segurança:** Implementação de uma classe `SecurityConfig` utilizando `SecurityFilterChain` para desabilitar CSRF e permitir o acesso público controlado às rotas de cadastro e login.
- **Integração Cross-Origin (CORS):** Configuração de uma política global de CORS para permitir que o frontend (Angular na porta 4200) consuma a API com segurança, tratando inclusive as requisições de _preflight_ (OPTIONS).

### 2. Desafios e Soluções

- **Conflito de CORS:** O navegador bloqueava as requisições do Angular por falta de cabeçalhos de permissão. A solução foi a implementação de um `CorsConfigurationSource` customizado no Spring Security.
- **Gestão de Dependências:** Durante o desenvolvimento, enfrentamos erros de inicialização de beans (`UserDetailsService`). Resolvemos configurando explicitamente a cadeia de filtros de segurança para evitar a geração de senhas automáticas pelo Spring Boot.
- **Ciclo de Vida do Servidor:** Conflitos de porta (Endereço já em uso) foram gerenciados através da limpeza de processos pendentes no ambiente Linux antes da execução.

### 3. Possíveis Melhorias

- **Persistência em Banco:** Migração da lista em memória para banco de dados persistente (H2/PostgreSQL).
- **JWT:** Substituição da autenticação simples por tokens JWT para tornar a API _stateless_.

---

## 🏃 Como Replicar

1. Certifique-se de ter o Java 17 e Maven instalados.
2. No diretório `atividade-2`, execute: `mvn spring-boot:run`.
3. A API estará disponível em `http://localhost:8080`.

---
