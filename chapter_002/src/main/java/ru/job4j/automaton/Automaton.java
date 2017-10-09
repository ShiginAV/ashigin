package ru.job4j.automaton;

/**
 * Automaton.
 * @author Aleksandr Shigin
 * @version $Id$
 * @since 0.1
 */
public class Automaton {
    /*** Types of coins.*/
    private int[] coinsType = {1, 2, 5, 10};
    /*** Quantity coins by type.*/
    private int[] coinsQuantity = {10, 10, 10, 10}; //1, 2, 5, 10
    /**
     * Get coins quantity.
     * @return - getCoinsQuantity
     */
    public int[] getCoinsQuantity() {
        return coinsQuantity;
    }
    /**
     * Add coins by type.
     * @param coin - coins type
     * @param qty - coins quantity
     */
    public void addCoins(int coin, int qty) {
        int pos = 0;
        for (int value : coinsType) {
            if (value == coin) {
                this.coinsQuantity[pos] += qty;
            }
            pos++;
        }
    }
    /**
     * Enough coins in automaton.
     * @param coins - quantity of change
     * @return - true or false
     */
    private boolean enoughCoins(int coins) {
        int available = 0;
        for (int i = 0; i < coinsQuantity.length; i++) {
            available += this.coinsType[i] * this.coinsQuantity[i];
        }
        return available >= coins;
    }
    /**
     * Buy.
     * @param priceStuff - price
     * @param coins - coins
     * @return - string
     */
    public String buy(int priceStuff, int coins) {
        if (priceStuff > coins) {
            return "Not enough money for buy!!!";
        }

        if (!this.enoughCoins(coins - priceStuff)) {
            return "Not enough coins for change!!!";
        }

        int pos = 3;
        int balance = coins - priceStuff;
        while (balance > 0) {
            if (this.coinsQuantity[pos] != 0 && balance >= this.coinsType[pos]) {
                balance -= this.coinsType[pos];
                this.coinsQuantity[pos]--;
            } else {
                pos--;
            }
        }
        return "Change: " + (coins - priceStuff);
    }
}
