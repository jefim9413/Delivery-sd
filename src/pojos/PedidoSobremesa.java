package pojos;
public class PedidoSobremesa extends Pedido {
    private String nomeSobremesa;

    public PedidoSobremesa(int id, String data, double valorTotal, String status, String nomeSobremesa) {
        super(id, data, valorTotal, status);
        this.nomeSobremesa = nomeSobremesa;
    }

    public String getNomeSobremesa() { return nomeSobremesa; }
}
