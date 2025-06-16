package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DeliveryService extends Remote {
    String criarPedido(String pedidoJson) throws RemoteException;
    String consultarPedido(int id) throws RemoteException;
    String listarPedidos() throws RemoteException;
    String avaliarPedido(int id, int nota, String comentario) throws RemoteException;
}
