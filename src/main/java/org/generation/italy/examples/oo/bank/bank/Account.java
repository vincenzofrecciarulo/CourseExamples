package org.generation.italy.examples.oo.bank.bank;

public class Account {
    private String accName; // private!
    private double balance;

    public Account(String accName, double balance) {
        this.accName = accName;
        this.balance = balance;
    }

    public String getAccName() {
        return this.accName;
    }

    public double getBalance() {
        return this.balance;
    }
}
