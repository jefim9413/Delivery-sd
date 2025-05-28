package testes;

import pojos.Pedido;
import streams.PedidoOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientePedido {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        Pedido[] pedidos = { new Pedido(99, "2024-05-27", 123.45, "Em trânsito") };
        PedidoOutputStream pos = new PedidoOutputStream(pedidos, 1, socket.getOutputStream());
        pos.writePedidos();
        socket.close();
        System.out.println("Pedido enviado ao servidor!");
    }
}
