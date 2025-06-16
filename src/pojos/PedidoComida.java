package pojos;


public class PedidoComida extends Pedido {
    private String pratoPrincipal;

    public PedidoComida() {
        super();
    }

    public PedidoComida(int id, String data, double valorTotal, String status, String pratoPrincipal) {
        super(id, data, valorTotal, status);
        this.pratoPrincipal = pratoPrincipal;
    }

    public String getPratoPrincipal() {
        return pratoPrincipal;
    }

    public void setPratoPrincipal(String pratoPrincipal) {
        this.pratoPrincipal = pratoPrincipal;
    }
}
