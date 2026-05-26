package org.generation.italy.examples.oo.banksystem;

public class Account {
    /*
        Creare una classe che rappresenti un conto corrente con saldo di tipo double, un metodo per ritirare e un altro per depositare.
        Quando viene creato un account sarà possibile specificare il saldo iniziale
        Il conto corrente deve avere un metodo che permette di trasferire denaro a un'altro conto corrente.
     */

    double balance;

    public Account (double balance) {
        this.balance = balance;
    }

    public double deposit(double amount){
        balance += amount;

        return balance;
    }

    public boolean withdraw(double amount) {
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transfer (double amount, Account target){
        if (balance < amount) {
            return false;
        }
        target.balance += amount;
        balance -= amount;
        return true;
    }

    public boolean transfer2 (double amount, Account target) {  //Migliore dal punto di vista di non replicabilità del codice, usiamo comandi che già abbiamo
        boolean success = withdraw (amount);
        balance+=10;
        if (success) {
            double finalBalance = target.deposit (amount);
            return true;
        }
        return false;
    }
}
