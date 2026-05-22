# 👤 Nome do Aluno

Bruno Vitor Cordeiro Gomes

---

## 📚 Descrição do Projeto

🎓 Plataforma de Cursos Comunitários

API REST desenvolvida para gerenciamento de uma plataforma de cursos comunitários.

### 🗂️ Entidades Principais

- 👨‍🎓 Aluno
- 👤 PerfilSocial
- 📖 Curso
- 👨‍🏫 Professor
- 📝 Matricula

---

## ▶️ Instruções de Execução

## ✅ Pré-requisitos

- [ ] Java 17 instalado
- [ ] Maven instalado
- [ ] PostgreSQL instalado
- [ ] Criar o banco de dados com o nome `plataforma`
- [ ] Configurar `username` e `password` no `application.properties`

### 🚀 Como Rodar

**1. Clone o repositório:**

**2. Configure as variáveis de ambiente:**

**3. Instale as dependências:**

**4. Execute a aplicação:**

**5. Acesse a aplicação:**

**6. Acesse o Swagger (documentação da API):**

---

## 🛠️ Tecnologias Utilizadas

- ☕ Java 17
- 🍃 Spring Boot
- 🐘 PostgreSQL
- 🗄️ Spring Data JPA
- 🔧 Hibernate
- 📦 Maven
- 📖 Swagger / OpenAPI
- ✅ Bean Validation
- 🐙 Git / GitHub

---

## 📡 Exemplos de Endpoints

---

### 👨‍🎓 Alunos

#### `GET /aluno/{id}` — Buscar aluno por ID
**Resposta (200 OK):**
```json
{
  "id": 2,
  "nome": "Pedro Oliveira",
  "cpf": "46711762037",
  "email": "pedro@email.com",
  "dataNascimento": "2001-01-15"
}
```

---

#### `POST /aluno` — Cadastrar novo aluno
**Body:**
```json
{
  "nome": "Bruno Oliveira",
  "cpf": "76837515020",
  "email": "brunoolv@gmail.com",
  "dataNascimento": "2011-09-15"
}
```
**Resposta (201 Created):**
```json
{
  "id": 6,
  "nome": "Bruno Oliveira",
  "cpf": "76837515020",
  "email": "brunoolv@gmail.com",
  "dataNascimento": "2011-09-15"
}
```

---

#### `PUT /aluno/{id}` — Atualizar aluno
**Body:**
```json
{
  "nome": "Bruno Oliveira",
  "cpf": "76837515020",
  "email": "bruno@gmail.com",
  "dataNascimento": "2011-09-15"
}
```
**Resposta (200 OK):**
```json
{
  "id": 6,
  "nome": "Bruno Oliveira",
  "cpf": "76837515020",
  "email": "bruno@gmail.com",
  "dataNascimento": "2011-09-15"
}
```

---

## 🖼️ Imagem do Swagger

![Swagger UI](./docs/swagger.png)

---

## 📝 Observações Relevantes

- 🪪 **CPF:** Os CPFs precisam ser matematicamente válidos com dígitos verificadores corretos. Acesse o site https://www.4devs.com.br/gerador_de_cpf e gere um, caso dê algum erro.
