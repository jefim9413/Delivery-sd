package testes;

import pojos.Pedido;
import streams.PedidoOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestaEscritaArquivo {
    public static void main(String[] args) throws IOException {
        Pedido[] pedidos = {
            new Pedido(1, "2024-05-26", 50.0, "Entregue"),
            new Pedido(2, "2024-05-26", 7.0, "Entregue")
        };
        FileOutputStream fos = new FileOutputStream("pedidos.bin");
        PedidoOutputStream pos = new PedidoOutputStream(pedidos, pedidos.length, fos);
        pos.writePedidos();
        fos.close();
        System.out.println("Pedidos gravados no arquivo pedidos.bin!");
    }
}
