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
}

