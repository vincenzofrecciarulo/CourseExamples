package org.generation.italy.examples.oo.banksystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
    private String name;
    private String surname;
    private LocalDate dob;
    private boolean female;
    private ArrayList<Account> accounts;


    public Customer(String name, String surname, LocalDate dob, boolean female, ArrayList<Account> accounts) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.female = female;
        this.accounts = accounts;
    }

    public Customer(String name, String surname, LocalDate dob, boolean female) {
        this(name, surname, dob, female, new ArrayList<>());    //Invoca il costruttore in alto, il programma lo capisce dagli argomenti che gli passa, così prende tutto che gli è passato dalla classe esterna e poi gli genera un ArrayList vuoto.
    }

    public double getSpecialAccountBalance(){      //ritorna la balance più alta tra gli account se il customer è female o bassa se il customer è maschio
        double balance = 0;
        if (female) {
            for (Account i : accounts) {                    // Vedere come fare per crearli tramite funzione che scorre e va bene per entrambi
                if (i.getBalance()>balance) {
                    balance = i.getBalance();
                }
            }
            balance = balance;
        } else {
            for (Account i : accounts) {

            }

        }
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public boolean isFemale() {
        return female;
    }
}
