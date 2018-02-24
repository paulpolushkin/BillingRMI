package ru.ufa.pepolushkin.rmilearn.server;

import ru.ufa.pepolushkin.rmilearn.base.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * Created by Pavel Polushkin on 08.10.14 0:34 UTC+6(MSK+2)
 * Created with IntelliJ IDEA 13
 */
public class BillingServiceImpl extends UnicastRemoteObject implements BillingService {

	final private HashMap<Integer, Card> table = new HashMap<>();

	public BillingServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public boolean addNewCard(Card card) throws RemoteException {
		CardUtils.validateCard(card);
		int cardNumber = card.getCardNumber();
		synchronized (table) {
			if (table.get(cardNumber) != null) {
				return false;
			}
			table.put(cardNumber, card);
		}
		return true;
	}

	@Override
	public void processOperations(CardOperation command) throws RemoteException {
		synchronized (table) {
			HashMap<Integer, Card> temp = (HashMap<Integer, Card>) table.clone();
			CardOperationAdapter adapter = new CardOperationAdapter(command, table);
			try {
				adapter.process();
			} catch (Exception e) {
				System.err.println(e);
				table.clear();
				table.putAll(temp);
			}
		}
	}

	@Override
	public Card getCard(int cardNumber) throws RemoteException {
		return table.get(cardNumber);
	}
}
