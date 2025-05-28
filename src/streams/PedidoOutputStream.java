package streams;
import java.io.OutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import pojos.Pedido;

public class PedidoOutputStream extends OutputStream {
    private Pedido[] pedidos;
    private int numPedidos;
    private OutputStream out;

    public PedidoOutputStream(Pedido[] pedidos, int numPedidos, OutputStream out) {
        this.pedidos = pedidos;
        this.numPedidos = numPedidos;
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    public void writePedidos() throws IOException {
        for (int i = 0; i < numPedidos; i++) {
            Pedido p = pedidos[i];
            // Serializa id (int), data (String), valorTotal (double)
            out.write(ByteBuffer.allocate(4).putInt(p.getId()).array());
            byte[] dataBytes = p.getData().getBytes("UTF-8");
            out.write(ByteBuffer.allocate(4).putInt(dataBytes.length).array());
            out.write(dataBytes);
            out.write(ByteBuffer.allocate(8).putDouble(p.getValorTotal()).array());
        }
    }
}
