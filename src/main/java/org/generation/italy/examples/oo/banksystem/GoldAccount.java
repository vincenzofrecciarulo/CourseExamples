package org.generation.italy.examples.oo.banksystem;

public class GoldAccount extends Account {
    private double bonus;           //bonus clienti gold
    private int monthlyOperations;  //conta quante operazioni son fatte in un mese

    public GoldAccount(double balance, String serialNumber, double bonus, int monthlyOperations){
        super(balance, serialNumber);
        this.bonus = bonus;
        this.monthlyOperations = monthlyOperations;
    }
}
