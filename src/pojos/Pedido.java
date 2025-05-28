package pojos;
public class Pedido implements Avaliavel {
    protected int id;
    protected String data;
    protected double valorTotal;
    protected String status;
    protected int avaliacaoNota;
    protected String avaliacaoComentario;

    public Pedido(int id, String data, double valorTotal, String status) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    @Override
    public void avaliar(int nota, String comentario) {
        this.avaliacaoNota = nota;
        this.avaliacaoComentario = comentario;
    }

    public int getId() { return id; }
    public String getData() { return data; }
    public double getValorTotal() { return valorTotal; }
    public String getStatus() { return status; }
    public int getAvaliacaoNota() { return avaliacaoNota; }
    public String getAvaliacaoComentario() { return avaliacaoComentario; }
}
