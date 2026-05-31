package org.generation.italy.examples.Exercises.Exercise1.Objects;

public class BankAccount {
    /*
    Crea una classe ContoBancario con:

numero conto
saldo

Il saldo non deve poter diventare negativo.

Implementa:

deposita(importo)
preleva(importo)
getSaldo()
Vincoli
non è possibile depositare importi negativi
non è possibile prelevare più del saldo disponibile
Obiettivo
     */
    private int accountNumber;
    private double balance;

    public double deposit(double amount){
        if(amount <= 0){
            return balance;
        }
        balance += amount;
        return balance;
    }
    public boolean isBalanceUnavailable(double amount){
        return !(balance >= amount);
    }
    public boolean transfer(double amount){
        if(isBalanceUnavailable(amount)){
            return false;
        }
        balance -= amount;
        return true;
    }
    public double getBalance(){
        return balance;
    }
}
