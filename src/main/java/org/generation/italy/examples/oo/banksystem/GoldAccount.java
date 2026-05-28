package org.generation.italy.examples.oo.banksystem;

// dimostrando ancora polimorfismo. aggiungiamo un NUOVO tipo che estende Account e lavorerà coi metodi che
// abbiamo GIA' SCRITTO per account
public class GoldAccount extends Account {
    private double bonus;
    private int monthlyOperations;

    // diamo prima le variabili della classe madre, p
    public GoldAccount(double balance, String serialNumber, double bonus, int monthlyOperations) {
        super(balance, serialNumber);
        this.bonus = bonus;
        this.monthlyOperations = monthlyOperations;
    }
}
