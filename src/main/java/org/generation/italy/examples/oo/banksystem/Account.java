package org.generation.italy.examples.oo.banksystem;

import java.time.LocalDate;

public class Account {
    /*Creare una classe che rappresenti un conto corrente un saldo di tipo double
     un metodo per ritirare e in'altro per depositare
     Quando viene creato un account sarà possibile specificare il saldo iniziale
    // Il contocorrente deve avere un metoodo che permette di trasferire denaro
     ad un'altro  contocorrente
     */

    //l'incapsulamento è il rendere privato i nostri oggetti
    //uno stato pubblico non è più libero di evolvere, perchè se lo cambi invalidi tutto il codice che lo utilizza
    protected double balance;
    protected String serialNumber;
    protected LocalDate openDate;

      public Account() {

      }

    public Account (double balance){
        //super();
        this.balance = balance;
        this.serialNumber="";
        this.openDate=LocalDate.now();
    }

    public Account(double balance, String serialNumber){
        this(balance); //il this può solo essere fatto come prima istruzione(qua prima invoco il costruttore sopra,
                        // poi sovrascrivo eventualmente il valore di alcuni parametri)
        this.serialNumber=serialNumber;
    }

    public Account(double balance, String serialNumber, LocalDate openDate){
        this(balance, serialNumber);
        this.openDate=openDate;
    }

    public double deposit(double amount){
        balance += amount;
        return balance;
    }

    public boolean withdraw(double amount){
        if(isBalanceUnavailable(amount)){
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transfer(double amount,Account target){
        if(isBalanceUnavailable(amount)){
            return false;
        }
        target.balance += amount;
        balance-=amount;
        return true;

    }
    //metodo helper
    private boolean isBalanceUnavailable(double amount){
        return !(balance >= amount);
    }

    public boolean transfer2 (double amount,Account target){
        boolean success =  withdraw(amount);
        balance+=10;
        if(success){
            double finalBalance = target.deposit(amount);
            return true;
        }
        return false;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double newBalance){
        if(newBalance >= 0){        //condizione di guardia, per non avere balance negativo
            balance = newBalance;
        }
    }
}
