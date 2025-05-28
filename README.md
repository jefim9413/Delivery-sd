
# Sistema de Controle de Delivery de Comida

Trabalho prático – Sistemas Distribuídos  
Universidade Federal do Ceará – Campus de Quixadá  
Professor: Rafael Braga  
Aluno:Jefferson Marques e Elenildo       
Período: 2025.1

---

## Descrição

Este projeto implementa um sistema de controle de delivery de comida usando Java, abordando os conceitos de orientação a objetos, serialização personalizada, comunicação via arquivos e sockets TCP.  
O objetivo é demonstrar a comunicação entre processos e a transmissão de objetos usando streams customizados.

---

## Estrutura do Projeto

- **Pacote `pojos`**  
  - `Pedido` (superclasse)
  - `PedidoComida`, `PedidoBebida`, `PedidoSobremesa` (subclasses)
  - `Restaurante` (agregação de pedidos)
  - `Avaliavel` (interface)

- **Pacote `streams`**  
  - `PedidoOutputStream` (serialização manual)
  - `PedidoInputStream` (desserialização manual)

- **Pacote `testes`**  
  - `Main` (testes POJO)
  - `TestaEscritaArquivo` (salva pedidos em arquivo)
  - `TestaLeituraArquivo` (lê pedidos do arquivo)
  - `ServidorPedido` (servidor TCP)
  - `ClientePedido` (cliente TCP)

---

## Como Compilar e Rodar

1. Abra o terminal na pasta `src/` do projeto.

2. Compile todos os arquivos:
    ```
    javac pojos/*.java streams/*.java testes/*.java
    ```

3. Execute os testes conforme desejar:

    - Teste POJO:
      ```
      java testes.Main
      ```
    - Escrever pedidos no arquivo:
      ```
      java testes.TestaEscritaArquivo
      ```
    - Ler pedidos do arquivo:
      ```
      java testes.TestaLeituraArquivo
      ```
    - Teste TCP (Sockets):
      1. Rode o servidor:
         ```
         java testes.ServidorPedido
         ```
      2. Em outro terminal, rode o cliente:
         ```
         java testes.ClientePedido
         ```

---

## Organização dos arquivos

```
src/
│
├── pojos/
│   ├── Avaliavel.java
│   ├── Pedido.java
│   ├── PedidoComida.java
│   ├── PedidoBebida.java
│   ├── PedidoSobremesa.java
│   └── Restaurante.java
│
├── streams/
│   ├── PedidoOutputStream.java
│   └── PedidoInputStream.java
│
└── testes/
    ├── Main.java
    ├── TestaEscritaArquivo.java
    ├── TestaLeituraArquivo.java
    ├── ServidorPedido.java
    └── ClientePedido.java
```

---

## Observações

- O arquivo `pedidos.bin` é gerado na raiz do projeto durante os testes com arquivos.
- Para o teste com sockets, execute o servidor antes do cliente.
- O código está documentado e segue a orientação a objetos, com exemplos de uso de interface, agregação e herança.

---
