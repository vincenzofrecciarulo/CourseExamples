package org.generation.italy.examples.oo.lambdaandstreams;
import org.generation.italy.examples.oo.lambdaandstreams.Guest;
public class Transaction {
    private Guest g;
    private int amount;
    public Transaction(Guest g, int amount) {
        this.g = g;
        this.amount = amount;
    }
    public Guest getGuest() { return g; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
    @Override
    public String toString() {
        return "Transazione di " + g + ": " + amount + "€";
    }
}
