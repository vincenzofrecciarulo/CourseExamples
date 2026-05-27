package org.generation.italy.examples.oo.banksystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Accountb> accounts;
    private LocalDate creationDate;

    private static Bank instance = new Bank();
    private Bank(){                         //Solo in questa classe possiamo creare l'oggetto Bank
        accounts = new ArrayList<>();
        creationDate = LocalDate.now();
    }

    public static Bank getInstance() {       // Il get solitamente si chiama come la variabile
        return instance;
    }
}