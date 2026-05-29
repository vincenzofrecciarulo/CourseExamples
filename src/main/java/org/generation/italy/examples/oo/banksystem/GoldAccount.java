package org.generation.italy.examples.oo.banksystem;

public class GoldAccount extends Account{
    private double bonus; //bonus se sei cliente gold
    private int monthlyOperations; // conta quamte operazioni fai in un mese

    public GoldAccount(double balance, String serialNumber, double bonus, int monthlyOperations){
        super(balance,serialNumber);
        this.bonus = bonus;
        this.monthlyOperations = monthlyOperations;
    }
}
