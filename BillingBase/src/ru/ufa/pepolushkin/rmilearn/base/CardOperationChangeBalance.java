package ru.ufa.pepolushkin.rmilearn.base;

import java.util.Date;

/**
 * Created by Pavel Polushkin on 08.10.14 0:45 UTC+6(MSK+2)
 * Created with IntelliJ IDEA 13
 */
public class CardOperationChangeBalance implements CardOperationCommand {

	private int cardNumber;
	private double amount;
	private Date operationDate;

	public CardOperationChangeBalance(int cardNumber, double amount, Date operationDate) {
		this.cardNumber = cardNumber;
		this.amount = amount;
		this.operationDate = operationDate;
	}

	@Override
	public int getCardNumber() {
		return cardNumber;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public Date getOperationDate() {
		return operationDate;
	}

	@Override
	public void process(Card card) {
		card.setBalance(card.getBalance() + amount);
	}
}
