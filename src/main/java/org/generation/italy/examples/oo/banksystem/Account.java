package org.generation.italy.examples.oo.banksystem;

public class Account {

    double balance;
    public Account (double balance) {
        this.balance = balance;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public boolean withdraw(double amount){
    if (balance<amount) {
        return false;
    }
    balance -= amount;
    return true;
    }

    public boolean transfer(double amount, Account target){
        if (balance<amount) {
            return false;
        }
        target.balance+= amount;
        balance-=amount;
        return true;
    }

    public boolean transfer2(double amount, Account target){
        boolean success = withdraw(amount);
        if(success){
            double finalBalance = target.deposit(amount);
            return true;
        }
        return false;
    }
}
