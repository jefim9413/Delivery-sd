package pojos;

public class Pedido {
    private int id;
    private String data;
    private double valorTotal;
    private String status;
    private int avaliacaoNota;
    private String avaliacaoComentario;

    public Pedido() {}  

    public Pedido(int id, String data, double valorTotal, String status) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public int getAvaliacaoNota() { return avaliacaoNota; }
    public void setAvaliacaoNota(int nota) { this.avaliacaoNota = nota; }
    public String getAvaliacaoComentario() { return avaliacaoComentario; }
    public void setAvaliacaoComentario(String comentario) { this.avaliacaoComentario = comentario; }
}
