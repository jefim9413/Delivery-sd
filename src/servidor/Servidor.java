package servidor;

import rmi.DeliveryService;  
import servidor.DeliveryServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            DeliveryServiceImpl service = new DeliveryServiceImpl();
            Naming.rebind("rmi://localhost/DeliveryService", service);
            System.out.println("Servidor RMI pronto!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
