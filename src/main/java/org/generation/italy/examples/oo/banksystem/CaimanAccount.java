package org.generation.italy.examples.oo.banksystem;

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
        deposit(percentTaxEvasion*getBalance());
    }
    //method override
    @Override
    public double deposit(double amount){
        //balance += amount*(1+percentTaxEvasion);
        super.deposit(amount*(1+percentTaxEvasion));
        return balance;
    }
}

