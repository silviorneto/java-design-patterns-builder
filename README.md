# Padrões de Projetos com Java
O objetivo deste estudo foi experimentar alguns padrões de projeto em Java, mais especificamente o padrão *Builder*, embora outros padrões estejam presentes neste projeto como _Singleton_, _Strategy_ e _Facade_.

- Singleton: Utilizado por padrão no Spring Framework através da anotação Autowired;
- Strategy: As interfaces usadas nas implementações dos Service;
- Facade: Interface para busca do CEP através da API do Via Cep; e
- Builder: Builder para montagem dos combos de acordo com o recebido via request.

## A aplicação
A aplicação simula um endpoint de uma pizzaria para realização de pedidos. Os pedidos são Combos e existem três: `FAMILIA`, `VEGETARIANO` e `COMPLETO`.
Para montagem dos combos foi criado um builder chamado `OrderBuilder` que constrói os pedidos de forma flexível, fazendo uso do paradigma funcional para deixar o código mais legível.

## Como rodar a aplicação.
### Crie um cliente

**POST** `/clients`

Exemplo de requisição:
```json
{
  "name": "John Doe",
  "address": {
    "cep": "01310930"
  }
}
```
Obs: A interface com via Cep faz a busca do endereço a partir do cep.

### Crie um pedido
**POST** `/order/combo`

Exemplo de requisição:
```json
{
  "client_id": 1,
  "combo_number": 1 // OPÇÕES: 1, 2 OU 3
}
```

## Acessando a documentação
Rode a aplicação e acesse o endpoint `/swagger-ui/index.html`. Por exemplo, se estiver rodando localmente, acesse através do `http://localhost:8080/swagger-ui/index.html`: 

## Melhorias futuras
- Teste unitários
- Documentação mais explícita
- Tratamento de erro
