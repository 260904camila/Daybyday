# Daybyday
API do projeto Day by day - Gerenciamento de tarefas


## Integrantes
Camila Cunha RM551785

Nina Rebello RM99509

## Tarefas

- [ ] CRUD de Tarefas
- [ ] CRUD de Categoria
- [ ] CRUD de Usuários

## Documentação da API

### Endpoints
- [Listar Todas as tarefas](#Listar-todas-as-tarefas)
- [Cadastrar Tarefa](#Cadastrar-tarefa)
- [Detalhes da Tarefa](#Detalhes-da-tarefa)
- [Remover tarefa](#Remover-tarefa)
- [Atualizar Tarefa](#Atualizar-tarefa)


## Listar Todas as Tarefas

`GET` /tarefa

Retorna um array com todas as tarefas

### Exemplo de Resposta

```js
[
    { 
        "id": 1,
        "nome": "Lição de casa",
        "imagem": "licao_de_casa"
    }
]
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados das tarefas foram retornados com sucesso
|401|Acesso negado. Você deve se autenticar

---

### Cadastrar Tarefa

`POST` /tarefa

Criar um novo anúncio com os dados enviados no corpo da requisão.

#### Corpo da requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Nome da tarefa que está anunciando.
|imagem|string|✅|O nome da imagem de acordo com a biblioteca Material Images

```js
{
    "nome": "Lição de casa",
    "imagem": "licao_de_casa"
}
```

#### Exemplo de resposta
```js
{   
    "id": 1,
    "nome": "Lição de casa",
    "imagem": "licao_de_casa"
}
```

#### Código de Status

|código|descrição|
|------|---------|
|201|Tarefa cadastrada com sucesso
|400|Dados enviados são inválidos. Verifique o corpo da requisição
|401|Acesso negado. Você deve se autenticar

---

## Detalhes da Tarefa

`GET` /tarefa/`{id}`

Retorna os detalhes da tarefa com o `id` informado como parâmetro de path.

#### Exemplo de Resposta

```js
// requisição para /tarefa/1

{
    "id": 1,
    "nome": "Lição de casa",
    "imagem": "licao_de_casa"
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados da tarefa foram retornados com sucesso
|401|Acesso negado. Você deve se autenticar
|404|Não existe tarefa com o `id` informado

___

### Remover Tarefa

`DELETE` /tarefa/`{id}`

Apaga a tarefa com o `id` especificado no parâmetro path.

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados da tarefa foram retornados com sucesso
|401|Acesso negado. Você deve se autenticar
|404|Não existe tarefa com o `id` informado

___


### Atualizar Tarefa

`PUT` /tarefa/`{id}`

Altera os dados da tarefa especificada no `id`, ultilizando as informações enviadas no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Nome da tarefa que está anunciando.
|imagem|string|✅|O nome da imagem de acordo com a biblioteca Material Images

```js
{
    "id": 1,
    "nome": "Lição de casa",
    "imagem": "licao_de_casa"
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados da tarefa foram retornados com sucesso
|400|Dados enviados são inválidos. Verifique o corpo da requisição
|401|Acesso negado. Você deve se autenticar
|404|Não existe tarefa com o `id` informado

___
