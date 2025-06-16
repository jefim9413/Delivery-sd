package cliente;

import rmi.DeliveryService;
import pojos.Pedido;

import java.rmi.Naming;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Scanner;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        try {
            DeliveryService service = (DeliveryService) Naming.lookup("rmi://localhost/DeliveryService");
            Gson gson = new Gson();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n=== MENU ===");
                System.out.println("1 - Criar pedido");
                System.out.println("2 - Listar pedidos");
                System.out.println("3 - Consultar pedido por ID");
                System.out.println("4 - Avaliar pedido");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // limpar buffer

                if (opcao == 1) {
                    System.out.print("Data do pedido: ");
                    String data = scanner.nextLine();
                    System.out.print("Valor total: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Status: ");
                    String status = scanner.nextLine();

                    Pedido p = new Pedido(0, data, valor, status);
                    String resposta = service.criarPedido(gson.toJson(p));
                    Pedido criado = gson.fromJson(resposta, Pedido.class);
                    System.out.println("\nPedido criado:");
                    imprimirPedido(criado);

                } else if (opcao == 2) {
                    String lista = service.listarPedidos();
                    List<Pedido> pedidos = gson.fromJson(lista, new TypeToken<List<Pedido>>(){}.getType());
                    System.out.println("\nPedidos cadastrados:");
                    for (Pedido p : pedidos) {
                        imprimirPedido(p);
                        System.out.println("-------------");
                    }

                } else if (opcao == 3) {
                    System.out.print("Digite o id do pedido para consultar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    String pedidoBuscado = service.consultarPedido(id);
                    if (pedidoBuscado == null) {
                        System.out.println("Pedido não encontrado.");
                    } else {
                        Pedido p = gson.fromJson(pedidoBuscado, Pedido.class);
                        System.out.println("\nPedido encontrado:");
                        imprimirPedido(p);
                    }

                } else if (opcao == 4) {
                    System.out.print("Digite o id do pedido para avaliar: ");
                    int id = scanner.nextInt();
                    System.out.print("Nota: ");
                    int nota = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Comentário: ");
                    String comentario = scanner.nextLine();
                    String avaliado = service.avaliarPedido(id, nota, comentario);
                    if (avaliado == null) {
                        System.out.println("Pedido não encontrado.");
                    } else {
                        Pedido p = gson.fromJson(avaliado, Pedido.class);
                        System.out.println("\nPedido avaliado:");
                        imprimirPedido(p);
                    }

                } else if (opcao == 0) {
                    System.out.println("Saindo...");
                    break;

                } else {
                    System.out.println("Opção inválida!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void imprimirPedido(Pedido p) {
        System.out.println("ID: " + p.getId());
        System.out.println("Data: " + p.getData());
        System.out.println("Valor Total: R$" + p.getValorTotal());
        System.out.println("Status: " + p.getStatus());
        if (p.getAvaliacaoNota() > 0) {
            System.out.println("Avaliação: " + p.getAvaliacaoNota() + " estrelas");
            System.out.println("Comentário: " + p.getAvaliacaoComentario());
        } else {
            System.out.println("Avaliação: [Não avaliado]");
        }
    }
}
