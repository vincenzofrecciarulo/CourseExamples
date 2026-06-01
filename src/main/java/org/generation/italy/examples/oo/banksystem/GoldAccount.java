package org.generation.italy.examples.oo.banksystem;

public class GoldAccount extends Account{
    private final double bonus; //bonus se sei cliente gold
    private final int monthlyOperations; // conta quamte operazioni fai in un mese

    public GoldAccount(double balance, String serialNumber, double bonus, int monthlyOperations){
        super(balance,serialNumber);
        this.bonus = bonus;
        this.monthlyOperations = monthlyOperations;
    }
}
