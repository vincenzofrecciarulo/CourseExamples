package org.generation.italy.examples.oo.lambdaandstreams;

import java.time.LocalDate;


public class Transaction {
    private Guest g;
    private int amount; //prezzo pagato nella transazione


    public Transaction(Guest g, int amount) {
        this.g = g;
        this.amount = amount;
    }

    public Guest getG() {
        return g;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "g=" + g +
                ", amount=" + amount +
                '}';
    }
}

