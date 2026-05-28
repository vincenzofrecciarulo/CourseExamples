package org.generation.italy.examples.oo.banksystem;

/*
Estende la classe Account, la copia identica, ma la estende, aggiunge altro, diventa erede
super() è obbligatorio per il costruttore dell'erede, è l'invocazione del costruttore di default della classe madre
Una classe figlia può essere vuota finchè la mamma ha costruttore default al suo interno
 */

import java.time.LocalDate;

public class CaimanAccount extends Account {
    private String secretCode;
    private double percentTaxEvasion;

    public CaimanAccount(double balance, String serialNumber, LocalDate openDate, String secretCode, double percentTaxEvasion){
        super(balance, serialNumber, openDate);
//        this.serialNumber = serialNumber;         Nonostante i dati possano essere accessibili è insensato. Viola incapsulamento e ripete codice.
//        this.openDate = openDate;
//        this.balance = balance;
        this.secretCode = secretCode;
        this.percentTaxEvasion = percentTaxEvasion;
    }

    public void evadeTaxes(){
        deposit(percentTaxEvasion*getBalance());
    }

    public double deposit(double amount){
        setBalance() = getBalance() + amount*(1+percentTaxEvasion);
        super.deposit(amount*(1+percentTaxEvasion));
        return getBalance();
    }
}
