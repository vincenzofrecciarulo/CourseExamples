package org.generation.italy.examples.oo.banksystem;

public class Account {
    // creare una classe che rappresenti un conto corrente, con un saldo
    // di tipo double, un metodo per ritirare denaro e uno per depositarlo (deposit deve ritornare il saldo totale dopo il deposito).
    // withdraw deve ritornare un booleano, vero se c'è abbastanza denaro per prelevare, falso altrimenti.
    // Quando viene creato un Account, dev'essere possibile specificare il saldo iniziale.
    // Il conto corrente deve avere anche un metodo che permetta di trasferire denaro in un altro conto corrente.

    // INCAPSULAMENTO: rendere PRIVATO lo STATO delle nostre classi. con private!
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public boolean withdraw(double amount) {
        if (isBalanceUnavailable(amount)) {
            return false;
        }
        balance -= amount;
        return true;
    }

    // IMPORTANT: we pass a variable of type Account as parameter! It's our other account
    // to which we would like to transfer money
    public boolean transfer(double amount, Account target) {
        if (isBalanceUnavailable(amount)) {
            return false;
        }
        target.balance += amount;
        balance -= amount;        // same as saying this.balance -= amount
        return true;
    }

    // another way to write the transfer method would be this, reusing deposit and withdraw
    // this is good to use only if the logic of the methods we call in here
    // will be FOREVER LINKED (if we later introduce for ex. a penalty/tax on withdraw but not on deposit,
    // this will break). it's not always optimal to reuse other methods - it depends.
    public boolean transfer2(double amount, Account target) {
        // it's as if we wrote this.withdraw(amount). the default is the current object:
        // by default, if we don't say otherwise, we reference THE OBJECT ON WHICH WE CALLED THE METHOD (this).
        boolean success = withdraw(amount);
        if (success) {
            double finalBalance = target.deposit(amount);
            return true;
        }
        return false;
    }

    // demonstrating PRIVATE HELPER METHODS for classes.
    // they're methods we'll need only inside the class itself, for other methods which we'll make public.
    private boolean isBalanceUnavailable(double amount) {
        return !(balance >= amount);
    }
}

