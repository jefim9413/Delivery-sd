package testes;

import pojos.Pedido;
import streams.PedidoInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPedido {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Servidor esperando conexão...");
        Socket socket = serverSocket.accept();
        PedidoInputStream pis = new PedidoInputStream(socket.getInputStream());
        Pedido pedidoRecebido = pis.readPedido();
        System.out.println("Pedido recebido: " + pedidoRecebido.getId() + ", " + pedidoRecebido.getData() + ", " + pedidoRecebido.getValorTotal());
        socket.close();
        serverSocket.close();
    }
}
