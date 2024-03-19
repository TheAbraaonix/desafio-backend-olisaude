<h1 align="center">
  Desafio Backend Oli Saúde
</h1>

API para gerenciar pessoas com problemas de saúde (CRUD) que faz parte [desse desafio](https://github.com/olisaude/teste-dev-backend) de vaga da Oli Saúde.

## Tecnologias

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- SpringDoc OpenAPI 3
- MySQL
- JUnit 5 e Mockito

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- DTOs de requisição e resposta
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3
- Testes unitários

## Como Executar

- Clonar repositório git:
```
git clone https://github.com/TheAbraaonix/desafio-backend-olisaude
```
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman](https://www.postman.com/):

### Criar paciente:
- **Endpoint:** `/customers`
- **Método HTTP:** POST
- **Descrição**: Cria um novo paciente.

Parâmetros da consulta:
- Nenhum.

Corpo da requisição:
```
{
    "name": "Paciente 1",
    "birthDate": "13/02/2003",
    "gender": "MALE",
    "healthProblems": [
        {
            "name": "Doença 1",
            "degree": 1
        },
        {
            "name": "Doença 2",
            "degree": 2
        }
    ]
}
```

Resposta da API:
```
{
    "id": 1,
    "name": "Paciente 1",
    "birthDate": "13/02/2003",
    "gender": "MALE",
    "healthProblems": [
        {
            "name": "Doença 1",
            "degree": 1
        },
        {
            "name": "Doença 2",
            "degree": 2
        }
    ],
    "createdAt": "19/03/2024 18:58:12",
    "updatedAt": null
}
```
### Listar pacientes:
- **Endpoint:** `/customers`
- **Método HTTP:** GET
- **Descrição**: Lista todos os pacientes.

Parâmetros da consulta:
- Nenhum.

Corpo da requisição:
```
{}
```
Resposta da API:
```
[
    {
        "id": 1,
        "name": "Paciente 1",
        "birthDate": "13/02/2003",
        "gender": "MALE",
        "healthProblems": [
            {
                "name": "Doença 1",
                "degree": 1
            },
            {
                "name": "Doença 2",
                "degree": 2
            }
        ],
        "createdAt": "19/03/2024 18:58:12",
        "updatedAt": "null"
    },
    {
        "id": 2,
        "name": "Paciente 2",
        "birthDate": "23/06/2004",
        "gender": "FEMALE",
        "healthProblems": [
            {
                "name": "Doença 3",
                "degree": 1
            }
        ],
        "createdAt": "19/03/2024 19:01:57",
        "updatedAt": "19/03/2024 19:03:31"
    }
]
```

### Listar paciente específico:
- **Endpoint:** `/customers/{id}`
- **Método HTTP:** GET
- **Descrição**: lista um paciente específico.

Parâmetros da consulta:
- `id` (obrigatório)

Corpo da requisição:
```
{}
```

Resposta da API:
```
{
    "id": 1,
    "name": "Paciente 1",
    "birthDate": "13/02/2003",
    "gender": "MALE",
    "healthProblems": [
        {
            "name": "Doença 1",
            "degree": 1
        },
        {
            "name": "Doença 2",
            "degree": 2
        }
    ],
    "createdAt": "19/03/2024 18:58:12",
    "updatedAt": null
}
```

### Listar top 10 pacientes com maior risco:
- **Endpoint:** `/customers/topten`
- **Método HTTP:** GET
- **Descrição**: Lista os 10 primeiros pacientes com maior grau de risco de saúde.

Parâmetros da consulta:
- Nenhum.

Corpo da requisição:
```
{}
```
Resposta da API:
```
[
    {
        "id": 1,
        "name": "Paciente 1",
        "score": 55.0
    }
    {
        "id": 2,
        "name": "Paciente 2",
        "score": 27.5
    },
    
]
```
### Editar paciente:
- **Endpoint:** `/customers/{id}`
- **Método HTTP:** PUT
- **Descrição**: Edita um paciente específico.

Parâmetros da consulta:
- `id` (obrigatório)

Corpo da requisição:
```
{
    "name": "Paciente 1",
        "birthDate": "13/02/2003",
        "gender": "MALE",
        "healthProblems": [
            {
                "name": "Doença 1",
                "degree": 1
            }
        ]
}
``` 
Resposta da API:
```
{
    "id": 1,
    "name": "Paciente 1",
    "birthDate": "13/02/2003",
    "gender": "MALE",
    "healthProblems": [
        {
            "name": "Doença 1",
            "degree": 1
        }
    ],
    "createdAt": "14/03/2024 17:22:31",
    "updatedAt": "19/03/2024 19:10:25"
}
```
### Deletar paciente:
- **Endpoint:** `/customers/{id}`
- **Método HTTP:** DELETE
- **Descrição**: Deleta um paciente específico.

Parâmetros da consulta:
- `id` (obrigatório)

Corpo da requisição:
```
{}
```
Resposta da API:
```
[
    {
        "id": 21,
        "name": "Paciente 1",
        "birthDate": "13/02/2003",
        "gender": "MALE",
        "healthProblems": [
            {
                "name": "Doença 1",
                "degree": 1
            }
        ],
        "createdAt": "14/03/2024 17:22:31",
        "updatedAt": "19/03/2024 19:10:25"
    }
]
```