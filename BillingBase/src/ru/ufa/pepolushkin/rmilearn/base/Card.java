package ru.ufa.pepolushkin.rmilearn.base;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Pavel Polushkin on 08.10.14 0:08 UTC+6(MSK+2)
 * Created with IntelliJ IDEA 13
 */
public class Card implements Serializable {

    private int cardNumber;
    private String person;
    private Date createDate = new Date();
    private double balance = 0;

    public Card(int cardNumber, String person) {
        this.cardNumber = cardNumber;
        this.person = person;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", person='" + person + '\'' +
                ", createDate=" + createDate +
                ", balance=" + balance +
                '}';
    }
}
