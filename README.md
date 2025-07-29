
# ⚙️ Shopping API

Um repositório com os commits de uma API REST em Java com SpringBoot, com um CRUD voltado para gerenciamento de usuários, produtos e ordem de pedidos, utilizando o H2 como banco de dados relacional para testes.


## 💡 Funcionalidades

- CRUD para cadastro de usuários, produtos, sistema de carrinho, sistema de entrega, cálculo do valor total da ordem de pedido
- Integração com banco de dados H2 para testes
- Organização em sistema de camadas: Resource Layer (Rest Controllers), Service Layer, Data Acess Layer (Data Repository)


## 📃 Documentação da API


### API funcionando pela localhost

```http
  http://localhost:8080/
```

### Retornar todos os usuários

```http
  GET /users
```

### Retornar um usuário (Filtro por ID)

```http
  GET /users/{id}
```

#### Variáveis da URL
| Variável   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `String` | **Obrigatório**. O ID do usuário que deseja buscar |



### Criar um novo usuário

```http
  POST /users
```

#### JSON Body
| Elemento   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `String` | **Obrigatório**. Nome do usuário  |
| `email`      | `String` | **Obrigatório**. Email do usuário |
| `password`      | `String` | **Obrigatório**. Número de telefone do usuário |
| `userLevel`      | `String` | **Obrigatório**. Senha do usuário|

#### Exemplo

```json 
Content-Type: application/json

{ 
    "name": "Lucas Monteiro", 
    "email": "lucas.monteiro@example.com", 
    "password": "12345678",
    "userLevel": "ADMIN"
}
```

### Atualiza os dados de um usuário existente

```http
  PUT /users/{id}
```

#### Variáveis da URL
| Variável   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `String` | **Obrigatório**. O ID do usuário que será atualizado |


#### JSON Body
| Elementos   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `String` | **Opcional**. Nome do usuário  |
| `email`      | `String` | **Opcional**. Email do usuário |
| `phone`      | `String` | **Opcional**. Número de telefone do usuário |

#### Exemplo

```json 
Content-Type: application/json

{ 
    "name": "Lucas Oliveira"
    "email": "lucas.oliveira@example.com", 
    "phone": "987654321"
}
```

### Remover um usuário (Filtro por ID)

```http
  DELETE /users/{id}
```

#### Variáveis da URL
| Variável   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `String` | **Obrigatório**. O ID do usuário que será removido |

### Retornar todos os produtos

```http
  GET /products
```

### Retornar um produto (Filtro por ID)

```http
  GET /users/{id}
```

#### Variáveis da URL
| Variável   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `String` | **Obrigatório**. O ID livro que deseja buscar |

### Retornar todos produtos (Filtro por Descrição)

```http
  GET /products/search?description={description}
```

#### Parâmetros da URL
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `description`      | `String` | **Obrigatório**. Descrição completa ou fragmento da descrição do produto |

#### Exemplo

```json 
GET /products/search?description=senhor%20dos%20aneis

Content-Type: application/json

{ 
    "name": "Livro", 
    "description": "O Senhor dos Anéis - A Sociedade do Anel", 
    "price": 40.0,
    "imgUrl": "livros.com/o-senhor-dos-aneis-a-sociedade-do-anel.png"
}
{ 
    "name": "Livro", 
    "description": "O Senhor dos Anéis - As Duas Torres", 
    "price": 45.0,
    "imgUrl": "livros.com/o-senhor-dos-aneis-as-duas-torres.png"
}
{ 
    "name": "Livro", 
    "description": "O Senhor dos Anéis - O Retorno do Rei", 
    "price": 50.0,
    "imgUrl": "livros.com/o-senhor-dos-aneis-o-retorno-do-rei.png"
}

```

### Criar um novo produto

```
  POST /products
```

#### JSON Body
| Elemento   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `String` | **Obrigatório**. Nome do produto  |
| `description`      | `String` | **Obrigatório**. Descrição do produto |
| `price`      | `Double` | **Obrigatório**. Preço do produto |
| `imgUrl`      | `String` | **Obrigatório**. Endereço da imagem do produto|

#### Exemplo

```json 
Content-Type: application/json

{ 
    "name": "Livro", 
    "description": "O Hobbit", 
    "price": 50.0,
    "imgUrl": "livros.com/o-hobbit.png"
}
```

### Retornar todos as ordens de pedidos

```http
  GET /orders
```

### Retornar uma ordem de pedido (Filtro por ID)

```http
  GET /orders/{id}
```

#### Variáveis da URL
| Variável   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `String` | **Obrigatório**. O ID da ordem de pedido que deseja buscar |


<h1 align="left">💻 Olá, me chamo Lucas!</h1>

###

<p align="left">Estou migrando de carreira para trabalhar com o que sempre gostei. Estou focando meus estudos em Java para me tornar um futuro Dev Backend.</p>

###

<h2 align="left">❔ Sobre mim</h2>

###

<p align="left">🖥️ Técnico em Rede de Computadores pela ETE Epitácio Pessoa<br>⚗️ Técnico em Química pelo IFPE<br>⌛ Estudando ADS pela UNINTER<br>📚 Estudando Java, SpringBoot e criação de CRUD e API<br>🎯 Objetivo: Se tornar um Desenvolvedor Java Backend<br>🎲 Fato Curioso: Sempre fui apaixonado por games, então tenho uns projetos básicos de jogos em Python e GODOT</p>

###

<h2 align="left">📝 Linguagens e ferramentas</h2>

###

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" alt="java logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" alt="spring logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg" height="40" alt="html5 logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg" height="40" alt="css3 logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" height="40" alt="javascript logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/python/python-original.svg" height="40" alt="python logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" height="40" alt="git logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/insomnia/insomnia-original.svg" height="40" alt="insomnia logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" height="40" alt="intellij logo"  />
</div>

###

<h2 align="left">⌛ Em aprendizado</h2>

###

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" height="40" alt="postgresql logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/amazonwebservices/amazonwebservices-line-wordmark.svg" height="40" alt="amazonwebservices logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mongodb/mongodb-original.svg" height="40" alt="mongodb logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/nodejs/nodejs-original.svg" height="40" alt="nodejs logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg" height="40" alt="docker logo"  />
</div>

###
