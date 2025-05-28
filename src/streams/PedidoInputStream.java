package streams;
import java.io.InputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import pojos.Pedido;

public class PedidoInputStream extends InputStream {
    private InputStream in;

    public PedidoInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }

    public Pedido readPedido() throws IOException {
        byte[] intBytes = new byte[4];
        byte[] doubleBytes = new byte[8];

        in.read(intBytes);
        int id = ByteBuffer.wrap(intBytes).getInt();

        in.read(intBytes);
        int dataLen = ByteBuffer.wrap(intBytes).getInt();

        byte[] dataBytes = new byte[dataLen];
        in.read(dataBytes);
        String data = new String(dataBytes, "UTF-8");

        in.read(doubleBytes);
        double valorTotal = ByteBuffer.wrap(doubleBytes).getDouble();

        // O status pode ser preenchido como "Desconhecido" por simplicidade
        return new Pedido(id, data, valorTotal, "Desconhecido");
    }
}
