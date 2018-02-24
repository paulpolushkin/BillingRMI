package ru.ufa.pepolushkin.rmilearn.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Pavel Polushkin on 08.10.14 23:52 UTC+6(MSK+2)
 * Created with IntelliJ IDEA 13
 */
public class BillingServiceEntryPoint {

    public static void main(String[] args) throws Exception {

        //System.out.println("Initializing BillingService...");
        //String serviceName = "rmi://localhost/BillingService";
        BillingServiceImpl service = new BillingServiceImpl();
        //Naming.rebind(serviceName, service);
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.rebind("BillingService", service);
    }
}
