package org.generation.italy.examples.oo.banksystem;

//Creare una classe che rappresenti un conto corrente,
// con saldo tipo double. Un metodo per depositare e ritirare denaro
//Quando viene creato un account, sara possibile specificare il
//saldo iniziale, il conto corrente deve dare la possibilita di
// trasferire denaro ad un altro conto corrente.

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
        System.out.println("AMMONTARE TROPPO ALTO, RIPROVA.");
        return false;
    }
    balance -= amount;
    return true;
    }

    public boolean transfer(double amount, Account target){
        System.out.println("Saldo disponibile: "+balance);
        if (balance<amount) {
            System.out.println("AMMONTARE TROPPO ALTO, RIPROVA.");
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
