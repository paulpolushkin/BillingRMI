package ru.ufa.pepolushkin.rmilearn.base;

import java.util.Map;

/**
 * Created by Pavel Polushkin on 08.10.14 22:55 UTC+6(MSK+2)
 * Created with IntelliJ IDEA 13
 */
public class CardOperationAdapter {

    private CardOperation cardOperation;
    private Map<Integer, Card> table;

    public CardOperationAdapter(CardOperation cardOperation, Map<Integer, Card> table) {
        this.cardOperation = cardOperation;
        this.table = table;
    }

    public void process() throws Exception {
        for (CardOperationCommand command : cardOperation.getCommands()) {
            int cardNumber = command.getCardNumber();
            Card card = table.get(cardNumber);
            if (card == null) {
                throw new NotExistsCardOperationException();
            }
            command.process(card);
        }
    }
}
