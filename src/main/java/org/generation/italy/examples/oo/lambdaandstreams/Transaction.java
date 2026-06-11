package org.generation.italy.examples.oo.lambdaandstreams;

public class Transaction {
    Guest g;
    int amount;

    public Transaction(Guest g, int amount) {
        this.g = g;
        this.amount = amount;
    }

    public Guest getGuest()        { return g; }
    public int getAmount()         { return amount; }
    public boolean belongsTo(Guest guest) { return this.g.equals(guest); }

    @Override
    public String toString() {
        return g + " -> " + amount + "€";
    }
}