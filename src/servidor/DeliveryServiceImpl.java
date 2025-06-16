package servidor;

import rmi.DeliveryService; 
import pojos.Pedido; 

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;
import com.google.gson.Gson;

public class DeliveryServiceImpl extends UnicastRemoteObject implements DeliveryService {
    private List<Pedido> pedidos;
    private int proximoId;
    private Gson gson;

    public DeliveryServiceImpl() throws RemoteException {
        pedidos = new ArrayList<>();
        proximoId = 1;
        gson = new Gson();
    }

    @Override
    public String criarPedido(String pedidoJson) throws RemoteException {
        Pedido p = gson.fromJson(pedidoJson, Pedido.class);
        p.setId(proximoId++);
        pedidos.add(p);
        return gson.toJson(p);
    }

    @Override
    public String consultarPedido(int id) throws RemoteException {
        for (Pedido p : pedidos) {
            if (p.getId() == id)
                return gson.toJson(p);
        }
        return null;
    }

    @Override
    public String listarPedidos() throws RemoteException {
        return gson.toJson(pedidos);
    }

    @Override
    public String avaliarPedido(int id, int nota, String comentario) throws RemoteException {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                p.setAvaliacaoNota(nota);
                p.setAvaliacaoComentario(comentario);
                return gson.toJson(p);
            }
        }
        return null;
    }
}
