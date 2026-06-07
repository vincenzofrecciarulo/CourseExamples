package org.generation.italy.examplesMio.ooMio.banksystemMio;

import java.time.LocalDate;

public class CaimanAccount extends Account {
    private String secretCode;
    private double percentTaxEvasion;
    public CaimanAccount(double balance, String serialNumber, LocalDate openDate, String secretCode,
                         double percentTaxEvasion) {
        super(balance, serialNumber, openDate);
        this.secretCode = secretCode;
        this.percentTaxEvasion = percentTaxEvasion;
    }

    public void evadeTaxes(){
        deposit(percentTaxEvasion*getBalance()); //incrementa la balance di tot percento di quello che era prima
    }

    //method override
    @Override //il compilatore legge le annotazioni rispetto ai commenti, con l'annotazione (di compile time) stiamo descrivendo
    public double deposit(double amount){
        // balance += amount*(1+percentTaxEvasion);
        super.deposit(amount*(1+percentTaxEvasion)); // errore: stack overflow, ho una serie infinita di chiamate a deposit, ricorsione: una funzione che richiama se stessa
        return getBalance();  // return balance
    }
}

