package pojos;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nome;
    private List<Pedido> pedidos;

    public Restaurante() {
        pedidos = new ArrayList<>();
    }

    public Restaurante(String nome) {
        this.nome = nome;
        this.pedidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
}
