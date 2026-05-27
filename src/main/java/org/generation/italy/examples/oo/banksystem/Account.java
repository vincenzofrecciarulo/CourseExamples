package org.generation.italy.examples.oo.banksystem;

public class Account {
    /*Creare una classe che rappresenti un conto corrente un saldo di tipo double
     un metodo per ritirare e in'altro per depositare
     Quando viene creato un account sarà possibile specificare il saldo iniziale
    // Il contocorrente deve avere un metoodo che permette di trasferire denaro
     ad un'altro  contocorrente
     */

    double balance;

    public Account (double balance){
        this.balance = balance;
    }

    public double deposit(double amount){
         balance += amount;
         return balance;
    }

    public boolean withdraw(double amount){
        if(balance <amount){
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transfer(double amount,Account target){
        if(balance <amount){
            return false;
        }
        target.balance += amount;
        balance-=amount;
        return true;

    }

    public boolean transfer2 (double amount,Account target){
       boolean success =  withdraw(amount);
       if(success){
           double finalBalance = target.deposit(amount);
           return true;
       }
        return false;
    }

}
