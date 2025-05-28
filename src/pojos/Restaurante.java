package pojos;
import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nome;
    private List<Pedido> pedidos;

    public Restaurante(String nome) {
        this.nome = nome;
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public String getNome() { return nome; }
}
