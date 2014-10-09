package ru.ufa.pepolushkin.rmilearn.base;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Pavel Polushkin on 08.10.14 0:04 UTC+6(MSK+2)
 * Created with IntelliJ IDEA 13
 */
public interface CardOperationCommand extends Serializable {

	public void process(Card card) throws NotExistsCardOperationException;

	public int getCardNumber();

	public double getAmount();

	public Date getOperationDate();

}