package org.generation.italy.examples.oo.lamdaexpressions;

public class Transaction {
    private  Guest g;
    private int amount;

    public Transaction(Guest g, int amount) {
        this.g = g;
        this.amount = amount;
    }

    public Guest getGuest() {
        return g;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "g=" + g.toString() +
                ", amount=" + amount +
                '}';
    }
}
