package ru.ufa.pepolushkin.rmilearn.base;

/**
 * Created by Pavel Polushkin on 08.10.14 22:49 UTC+6(MSK+2)
 * Created with IntelliJ IDEA 13
 */
public class CardUtils {

    static public void validateCard(Card card) {
        if (card == null) {
            throw new NullPointerException("card can not be null");
        }
    }
}
