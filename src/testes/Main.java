package testes;

import pojos.Avaliavel;
import pojos.Pedido;
import pojos.PedidoBebida;
import pojos.PedidoComida;
import pojos.PedidoSobremesa;
import pojos.Restaurante;

public class Main {
    public static void main(String[] args) {
        Restaurante r = new Restaurante("Pizzaria do Zé");
        PedidoComida pc = new PedidoComida(1, "2024-05-26", 50.0, "Entregue", "Pizza Calabresa");
        PedidoBebida pb = new PedidoBebida(2, "2024-05-26", 7.0, "Entregue", "Refrigerante");
        PedidoSobremesa ps = new PedidoSobremesa(3, "2024-05-26", 12.0, "Entregue", "Pudim");

        r.adicionarPedido(pc);
        r.adicionarPedido(pb);
        r.adicionarPedido(ps);

        pc.avaliar(5, "Pizza deliciosa!");
        pb.avaliar(4, "Bebida gelada.");
        ps.avaliar(5, "Sobremesa maravilhosa!");

        for (Pedido p : r.getPedidos()) {
            System.out.println(
                p.getClass().getSimpleName() + ": " +
                p.getId() + " - " +
                p.getAvaliacaoComentario()
            );
        }
    }
}
