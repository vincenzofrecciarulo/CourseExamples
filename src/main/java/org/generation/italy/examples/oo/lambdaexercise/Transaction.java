package org.generation.italy.examples.oo.lambdaexercise;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Transaction {
    private Guest g;
    private int amount;

    public Transaction(Guest g, int amount) {
        this.g = g;
        this.amount = amount;
    }

    public boolean isMinor(Guest guest){
        if (ChronoUnit.YEARS.between(g.getDateOfBirth(), LocalDate.now()) < 18){

            return true;
        }
        return false;
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
