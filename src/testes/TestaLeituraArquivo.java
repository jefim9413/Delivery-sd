package testes;

import pojos.Pedido;
import streams.PedidoInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestaLeituraArquivo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("pedidos.bin");
        PedidoInputStream pis = new PedidoInputStream(fis);
        Pedido p1 = pis.readPedido();
        Pedido p2 = pis.readPedido();
        fis.close();

        System.out.println("Pedido 1: " + p1.getId() + ", " + p1.getData() + ", " + p1.getValorTotal());
        System.out.println("Pedido 2: " + p2.getId() + ", " + p2.getData() + ", " + p2.getValorTotal());
    }
}
