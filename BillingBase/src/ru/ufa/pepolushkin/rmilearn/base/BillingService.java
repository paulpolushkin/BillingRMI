package ru.ufa.pepolushkin.rmilearn.base;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Pavel Polushkin on 08.10.14 0:06 UTC+6(MSK+2)
 * Created with IntelliJ IDEA 13
 */
public interface BillingService extends Remote {

	public boolean addNewCard(Card card) throws RemoteException;

	public void processOperations(CardOperation command) throws RemoteException;

	public Card getCard(int cardNumber) throws RemoteException;

}
