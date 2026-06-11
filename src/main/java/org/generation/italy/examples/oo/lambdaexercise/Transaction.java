package org.generation.italy.examples.oo.lambdaexercise;

public class Transaction {
    private Guest g;
    private int amount;

    public Transaction(Guest g, int amount) {
        this.g = g;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "g=" + g +
                ", amount=" + amount +
                '}';
    }

    public Guest getG() {
        return g;
    }

    public int getAmount() {
        return amount;
    }
}
