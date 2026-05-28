package org.generation.italy.examples.oo.banksystem;

import java.time.LocalDate;

// dimostrando l'ereditarietà. ipotizziamo una versione mariuola della classe Account
public class CaimanAccount extends Account {              // CaimanAccount IS a Account

//    public CaimanAccount() {
//        super();              // questo è il default di una costruttore di default di una classe figlia. se abbiamo un costruttore di default
//    }                        //  nella classe madre, possiamo non scrivere questo costruttore, sarà implicito.

    // ci chiediamo per prima cosa se vogliamo espandere lo stato della classe madre
    // le variabili private della classe madre saranno presenti in questa, ma non saranno accessibili direttamente.
    private String secretCode;
    private double percentTaxEvasion;

    // dobbiamo dargli in input anche le variabili della classe madre, e passarle al costruttore della classe madre.
    // oltre a questo, dobbiamo settare le eventuali variabili in più che abbiamo nella classe figlia.
    public CaimanAccount(double balance, String serialNumber, LocalDate openDate, String secretCode, double percentTaxEvasion) {

        super(balance, serialNumber, openDate);
        this.secretCode = secretCode;
        this.percentTaxEvasion = percentTaxEvasion;

    }
}
