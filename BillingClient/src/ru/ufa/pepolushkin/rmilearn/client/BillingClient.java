package ru.ufa.pepolushkin.rmilearn.client;

import ru.ufa.pepolushkin.rmilearn.base.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Pavel Polushkin on 08.10.14 23:59 UTC+6(MSK+2)
 * Created with IntelliJ IDEA 13
 */
public class BillingClient {

	public static void main(String[] args) throws Exception {

		System.out.println("Starting...");
		//String serviceName = "rmi://localhost/BillingService";
		//BillingService service = (BillingService) Naming.lookup(serviceName);
		Registry registry = LocateRegistry.getRegistry("localhost");
		BillingService service = (BillingService) registry.lookup("BillingService");
		System.out.println("Done...");

		addNewCardRemote(new Card(1, "Pavel"), service);
		addNewCardRemote(new Card(2, "Sasha"), service);
		addNewCardRemote(new Card(3, "Datateh"), service);

		System.out.println("Cards created");

		List<CardOperationCommand> list = new ArrayList<>(1000);
		Random r = new Random();
		CardOperationCommand command;
		int cardNumber;
		boolean marker;
		for (int i = 0; i < 1000; i++) {
			cardNumber = r.nextInt(3) + 1;
			marker = r.nextBoolean();
			command = new CardOperationChangeBalance(
					cardNumber,
					marker ? 1 : -1,
					new Date()
			);
			list.add(command);
		}
		CardOperation cardOperation = new CardOperation(list);
		service.processOperations(cardOperation);

		System.out.println(service.getCard(1));
		System.out.println(service.getCard(2));
		System.out.println(service.getCard(3));
	}

	private static void addNewCardRemote(Card card, BillingService service) throws RemoteException {
		if (!service.addNewCard(card)) {
			System.out.println("Card " + card + " already exists!");
		}
	}
}
