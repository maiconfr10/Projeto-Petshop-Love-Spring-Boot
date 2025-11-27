# PetshopLove – Documentação Completa

## 📌 Sumário

1. Visão Geral do Projeto
2. Modelo Conceitual (DER)
3. Modelo Lógico
4. Diagrama de Classes
5. Estrutura da API
6. Cadastro e Autenticação de Usuários (BCrypt + JWT)
7. Explicação Completa das Rotas da API
8. Como funciona a Autenticação JWT (fluxo detalhado)
9. Exemplos de JSON para testes
10.JSONs de Teste Finais (Resumo)
11.Checklist Rápido para Recriar o Banco e Testar o Sistema
12.Passo a Passo para Apagar e Recriar o Banco (MySQL)
13.Subir a Aplicação e Gerar Tabelas com Hibernate
14.Inserir Perfis (ADMIN, COMUM)
15.Gerar Senha BCrypt (2 Métodos)
16.Inserir Usuário Admin Manualmente (SQL)
17.Criar Usuário via API (Alternativa Recomendada)
18.Testar Autenticação JWT (Postman)
19.Erros Comuns e Como Resolver
20.Scripts SQL Completos para Inicialização

---

# 🐾 1. Visão Geral do Projeto

O **PetshopLove** é um sistema de gerenciamento para pet shops, permitindo controlar clientes, animais, serviços, atendimentos e usuários com diferentes perfis de acesso. O sistema foi construído em **Java + Spring Boot**, usando autenticação **JWT**, criptografia **BCrypt** e mapeamento ORM com **JPA/Hibernate**.

---

# 🧩 2. Modelo Conceitual (DER)

Representa as entidades principais do sistema e seus relacionamentos.

**Entidades:** Cliente, Animal, Serviço, Atendimento, Usuário e Perfil.

**Associações chave:**

* Um Cliente possui vários Animais (1:N)
* Um Animal possui vários Atendimentos (1:N)
* Atendimento contém vários Serviços (N:N)
* Usuário possui vários Perfis (N:N)

---

# 🗄 3. Modelo Lógico

Descrição das tabelas e chaves estrangeiras.

**Tabelas principais:**

* cliente(id, nome, telefone, email)
* animal(id, nome, especie, raca, idade, id_cliente)
* servico(id, descricao, preco)
* atendimento(id, data, id_animal, observacoes)
* atendimento_servico(id_atendimento, id_servico)
* usuario(id, nome, email, senha)
* perfil(id, nome)
* usuario_perfil(id_usuario, id_perfil)

---

# 🏗 4. Diagrama de Classes

Contém as classes do backend e seus relacionamentos por meio de JPA.

Inclui entidades: Cliente, Animal, Servico, Atendimento, UsuarioEntitie, Perfil.

---

# 🌐 5. Estrutura da API

### Pastas principais:

* **controllers** – controladores REST
* **services** – regras de negócio
* **repositories** – camada de persistência
* **validacoes** – DTOs e responses
* **configs** – segurança JWT
* **usuario** – gerenciamento de usuários

---

# 🔐 6. Cadastro e Autenticação de Usuários (BCrypt + JWT)

### 🔸 Criptografia com BCrypt

Senhas não são armazenadas em texto puro. Antes de salvar, a senha é criptografada:

```java
usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
```

O README deve instruir o usuário a gerar senhas usando:

* [https://bcrypt-generator.com/](https://bcrypt-generator.com/)
* Ou pelo terminal usando Spring Security.

### 🔸 Perfis de Acesso

Os perfis padrão são:

* **ADMIN** → acesso total
* **COMUM** → acesso limitado

### 🔸 Autenticação via JWT

O login gera um token JWT válido por 24 horas.

Endpoint: **POST /auth/login**

Envio:

```json
{
  "email": "admin@petshop.com",
  "senha": "123456"
}
```

Resposta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

O token deve ser usado como:

```
Authorization: Bearer TOKEN_AQUI
```

---

# 📡 7. Explicação das Rotas da API (com exemplos JSON)

## 🧍 Cliente

### ➤ Criar cliente (POST /cliente)

```json
{
  "nomeCliente": "Carlos Silva",
  "teleCliente": "21988887777",
  "emailCliente": "carlos.silva@gmail.com"
}
```

### ➤ Listar clientes (GET /cliente)

Acesso: ADMIN ou COMUM.

---

## 🐶 Animal

### ➤ Criar animal (POST /animal)

```json
{
  "nomeAnimal": "Rex",
  "especie": "Cachorro",
  "raca": "Labrador",
  "idade": "3 anos",
  "idCliente": 1
}
```

---

## 🛁 Serviço

### ➤ Criar serviço (POST /servico)

```json
{
  "descricao": "Banho e Tosa",
  "preco": 80.0
}
```

---

## 📋 Atendimento

### ➤ Criar atendimento (POST /atendimento)

```json
{
  "data": "2025-11-10",
  "animal": { "idAnimal": 1 },
  "observacoes": "Animal tranquilo durante o atendimento"
}
```

### ➤ Associar serviço ao atendimento

**POST /atendimento-servico/{idAtendimento}/{idServico}**

Exemplo:

```
POST /atendimento-servico/1/1
```

### ➤ Calcular valor total

**GET /servico/com-total**

---

# 🔑 8. Autenticação JWT – Funcionamento Completo

### **1️⃣ Usuário faz login enviando email e senha**

Spring Security valida a senha com BCrypt.

### **2️⃣ Se estiver correto, o sistema gera um token JWT**

Esse token contém:

* subject (email)
* emissor
* data de expiração
* assinatura HS256

### **3️⃣ O usuário envia o token em todas as requisições**

`Authorization: Bearer SEU_TOKEN`

### **4️⃣ O filtro JwtFilter intercepta a requisição**

* Extrai o token
* Valida a assinatura
* Recupera o usuário
* Insere no SecurityContext

### **5️⃣ Spring libera ou bloqueia o endpoint conforme o perfil**

Configurações definidas no `SecurityConfigurations`.

---

# 🧪 9. JSONs de exemplo

(Os mesmos já listados acima para facilitar o uso no Postman.)

---
🗂️ 10. Recriação Completa do Banco de Dados (MySQL)
🔥 1) Apagar o banco antigo e recriar do zero

Abra o terminal MySQL e execute:

-- 1. conectar
mysql -u root -p

-- 2. apagar o banco antigo
DROP DATABASE IF EXISTS petshoplove;

-- 3. criar novamente
CREATE DATABASE petshoplove CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 4. selecionar banco
USE petshoplove;


Se estiver usando outro usuário/schema, ajuste conforme necessário.

🚀 11. Subir a Aplicação (gerar tabelas via Hibernate)

Após recriar o banco, inicie a aplicação:

Pelo IDE (Spring Boot Run)

Ou terminal:

mvn spring-boot:run


O Hibernate criará automaticamente as tabelas conforme o valor de:

spring.jpa.hibernate.ddl-auto=update


Espere aparecer:

Started ProjetoPetshopLoveApplication

👤 12. Inserir Perfis (ADMIN, COMUM)

Após as tabelas serem criadas, execute:

USE petshoplove;

INSERT INTO perfil (nome) VALUES ('ADMIN'), ('COMUM');

SELECT id, nome FROM perfil;


Anote os IDs retornados — normalmente:

1 → ADMIN  
2 → COMUM

🔐 13. Gerar Senha Criptografada (BCrypt)

Você tem duas opções:

✔ Opção A — Gerar via Java (recomendado)

Crie uma classe utilitária:

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GerarSenha {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}


Execute a classe e copie o hash gerado.

✔ Opção B — Gerador online

Pode usar:

https://bcrypt-generator.com/

(Não recomendado para produção)

🔑 Exemplo de hash válido (apenas exemplo):
$2a$12$taetSBrCiXxixuqcDzzMXOl0YKvbqinHqckWQkFft.SoBToiscyBW

👨‍💼 14. Criar Usuário Admin Manualmente (via SQL)

Use o ID do perfil ADMIN (geralmente 1):

INSERT INTO usuario (nome, email, senha) 
VALUES ('Administrador', 'admin@petshop.com', '$2a$12$taetSBrCiXxixuqcDzzMXOl0YKvbqinHqckWQkFft.SoBToiscyBW');


Ver o ID gerado:

SELECT id_usuario FROM usuario WHERE email = 'admin@petshop.com';


Supondo que seja 1, associe ao perfil:

INSERT INTO usuario_perfil (usuario_id, perfil_id) VALUES (1, 1);

🌐 15. Criar Usuário via API (opcional)

Se você implementou o controller:

POST /usuario


Body:

{
  "nome": "Administrador",
  "email": "admin@petshop.com",
  "senha": "123456"
}


O service irá criptografar automaticamente.

🔎 16. Testar Autenticação JWT
Login:
POST http://localhost:8080/auth/login


Body:

{
  "email": "admin@petshop.com",
  "senha": "123456"
}


Resposta:

{ "token": "eyJ..." }


Use no Postman:

Authorization → Bearer TOKEN_AQUI

❗ 17. Erros Comuns
❌ 401 Unauthorized

→ Email ou senha inválidos
→ Hash incompatível
→ Usuário não criado

❌ 403 Forbidden

→ O token é válido, mas o perfil não tem permissão
→ Verifique tabela usuario_perfil

❌ Erro de FK ao subir a aplicação

→ Banco recriado parcialmente
→ Execute novamente:

DROP DATABASE; CREATE DATABASE;

📜 18. Scripts SQL Completos (prontos para uso)
USE petshoplove;

INSERT INTO perfil (nome) VALUES ('ADMIN'), ('COMUM');

INSERT INTO usuario (nome, email, senha) VALUES 
('Administrador', 'admin@petshop.com', '$2a$12$taetSBrCiXxixuqcDzzMXOl0YKvbqinHqckWQkFft.SoBToiscyBW');

INSERT INTO usuario_perfil (usuario_id, perfil_id) VALUES (1, 1);

📦 19. JSONs de Teste (Resumo Final)
Cliente
{
  "nomeCliente": "Carlos Silva",
  "teleCliente": "21988887777",
  "emailCliente": "carlos.silva@gmail.com"
}

Animal
{
  "nomeAnimal": "Rex",
  "especie": "Cachorro",
  "raca": "Labrador",
  "idade": "3 anos",
  "idCliente": 1
}

Serviço
{
  "descricao": "Banho e Tosa",
  "preco": 80.0
}

Atendimento
{
  "data": "2025-11-10",
  "animal": { "idAnimal": 1 },
  "observacoes": "Animal tranquilo"
}

Associação
POST /atendimento-servico/1/1

🧭 20. Checklist Final para Executar Agora

⛔ Parar aplicação

🔥 DROP DATABASE IF EXISTS petshoplove;

🆕 Criar banco

▶️ Subir app (Hibernate cria as tabelas)

🧩 Inserir perfis

🔐 Gerar hash BCrypt

👨‍💼 Inserir usuário admin

🔗 Associar perfil ADMIN

🔑 Testar login

✔ Testar rotas com token


