package org.generation.italy.examples.arrays.oo.banksistem;
public class Account {

    /*
    Creare una classe che rappresenti un conto corrente con un saldo di tipo double.
    Un metodo per ritirare e un altro per depositare.

    Quando viene creato un account sarà possibile specificare il saldo iniziale.

    Il contocorrente deve avere un metodo che permette di trasferire denaro
    ad un altro contocorrente.
    */

    // Incapsulamento = rendere privati gli attributi
    private double balance;

    // Costruttore
    public Account(double balance) {
        this.balance = balance;
    }

    // Getter
    public double getBalance() {
        return balance;
    }

    // Setter
    public void setBalance(double newBalance) {
        if (newBalance >= 0) {
            balance = newBalance;
        }
    }

    // Deposito
    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    // Prelievo
    public boolean withdraw(double amount) {

        if (amount <= 0 || balance < amount) {
            return false;
        }

        balance -= amount;
        return true;
    }

    // Trasferimento diretto
    public boolean transfer(double amount, Account target) {

        if (amount <= 0 || balance < amount) {
            return false;
        }

        target.balance += amount;
        balance -= amount;

        return true;
    }

    // Trasferimento usando withdraw e deposit
    public boolean transfer2(double amount, Account target) {

        boolean success = withdraw(amount);

        if (success) {
            target.deposit(amount);
            return true;
        }

        return false;
    }
}