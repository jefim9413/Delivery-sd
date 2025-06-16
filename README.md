# Trabalho 2 - Comunicação Remota com Java RMI

## Tema: Sistema de Delivery de Pedidos (Reimplementação com RMI)

Trabalho prático – Sistemas Distribuídos  
Universidade Federal do Ceará – Campus de Quixadá  
Professor: Rafael Braga  
Aluno:Jefferson Marques e Elenildo       
Período: 2025.1
---

### Descrição

Este projeto consiste em um sistema de delivery implementado no modelo cliente-servidor utilizando Java RMI.\
O objetivo é demonstrar a comunicação entre processos (cliente e servidor) usando chamada remota de métodos (RMI), além de aplicar conceitos de serialização por valor (usando JSON/Gson), herança, agregação, e boas práticas de organização de código em Java.

---

### Estrutura de Pastas

```
src/
├── pojos/
│   ├── Pedido.java
│   ├── PedidoComida.java
│   ├── PedidoBebida.java
│   ├── PedidoSobremesa.java
│   ├── Restaurante.java
│   └── Avaliavel.java
│
├── rmi/
│   └── DeliveryService.java
│
├── servidor/
│   ├── DeliveryServiceImpl.java
│   └── Servidor.java
│
├── cliente/
│   └── Cliente.java
│
└── libs/
    └── gson-2.13.1.jar
```

---

### Entidades e Requisitos

- **Pedido:** superclasse base para pedidos
- **PedidoComida, PedidoBebida, PedidoSobremesa:** subclasses (herança)
- **Restaurante:** agrega (tem-um) uma lista de pedidos
- **Avaliavel:** interface para avaliação de pedidos

**Requisitos atendidos:**

- Mínimo de 4 entidades, 2 heranças, 2 agregações
- Métodos remotos via RMI para criar, listar, consultar e avaliar pedidos
- Serialização/deserialização por valor via JSON usando Gson

---

### Como compilar e rodar

#### **Pré-requisitos**

- Java JDK instalado (>= 8)
- Biblioteca Gson (`gson-2.13.1.jar`) baixada na pasta `libs`

#### **1. Compilar os arquivos**

No terminal, dentro da raiz do projeto:

```bash
javac -cp "libs/gson-2.13.1.jar" src/pojos/*.java
javac -cp "libs/gson-2.13.1.jar;src" src/rmi/*.java src/servidor/*.java src/cliente/*.java
```

*(No Linux/Mac, troque **``** por **``** se necessário.)*

#### **2. Rodar o Servidor**

```bash
java -cp "libs/gson-2.13.1.jar;src" servidor.Servidor
```

#### **3. Rodar o Cliente**

Em outro terminal:

```bash
java -cp "libs/gson-2.13.1.jar;src" cliente.Cliente
```

---

### Observações

- **O servidor já inicia o RMI Registry internamente (não precisa rodar ****\`\`**** manualmente).**
- Todos os métodos de comunicação remota usam passagem por valor com JSON.
- O código segue o padrão de pacotes Java para facilitar a organização e modularização.

---

### Exemplo de Uso (Operações)

- Criar vários pedidos de forma interativa
- Listar pedidos cadastrados
- Consultar um pedido específico pelo ID
- Avaliar um pedido (nota e comentário)
- Todos os pedidos e avaliações são transmitidos e armazenados via métodos remotos
- **O cliente agora exibe os dados de cada pedido em formato amigável para humanos**

---

### Exemplos de Entradas e Saídas

**Menu exibido no cliente:**
```
=== MENU ===
1 - Criar pedido
2 - Listar pedidos
3 - Consultar pedido por ID
4 - Avaliar pedido
0 - Sair
Escolha uma opção:
```

**Exemplo de criação de pedidos:**
```
Escolha uma opção: 1
Data do pedido: 2024-06-14
Valor total: 50.00
Status: Entregue

Pedido criado:
ID: 1
Data: 2024-06-14
Valor Total: R$50.0
Status: Entregue
Avaliação: [Não avaliado]
```

**Exemplo de listagem de pedidos:**
```
Escolha uma opção: 2

Pedidos cadastrados:
ID: 1
Data: 2024-06-14
Valor Total: R$50.0
Status: Entregue
Avaliação: [Não avaliado]
-------------
ID: 2
Data: 2024-06-15
Valor Total: R$75.5
Status: Em andamento
Avaliação: [Não avaliado]
-------------
```

**Exemplo de consulta por ID:**
```
Escolha uma opção: 3
Digite o id do pedido para consultar: 2

Pedido encontrado:
ID: 2
Data: 2024-06-15
Valor Total: R$75.5
Status: Em andamento
Avaliação: [Não avaliado]
```

**Exemplo de avaliação de pedido:**
```
Escolha uma opção: 4
Digite o id do pedido para avaliar: 2
Nota: 5
Comentário: Excelente serviço!

Pedido avaliado:
ID: 2
Data: 2024-06-15
Valor Total: R$75.5
Status: Em andamento
Avaliação: 5 estrelas
Comentário: Excelente serviço!
```

---

**Observação:**  
Agora, as informações dos pedidos são apresentadas de maneira amigável para facilitar a visualização e compreensão dos dados.

---


### Referências

- Livro-texto da disciplina, seção 5.2
- Documentação oficial do Java RMI
- Documentação Gson: [https://github.com/google/gson](https://github.com/google/gson)

---

