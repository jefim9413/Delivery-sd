package pojos;

public class PedidoBebida extends Pedido {
    private String tipoBebida;

    public PedidoBebida() {
        super();
    }

    public PedidoBebida(int id, String data, double valorTotal, String status, String tipoBebida) {
        super(id, data, valorTotal, status);
        this.tipoBebida = tipoBebida;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }
}
