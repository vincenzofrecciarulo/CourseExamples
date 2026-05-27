package org.generation.italy.examples.oo.banksystem;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
    private String name;
    private String surname;
    private LocalDate dateofbirth;
    private boolean female;
    private ArrayList<Account> accounts;

    public Customer(boolean female, LocalDate dateofbirth, String surname, String name, ArrayList<Account> accounts) {
        this.female = female;
        this.dateofbirth = dateofbirth;
        this.surname = surname;
        this.name = name;
        this.accounts = accounts;
    }

    // another Constructor for when we don't have a list of Accounts
    public Customer(String name, String surname, LocalDate dateofbirth, boolean female) {
        this(name, surname, dateofbirth, female, new ArrayList<>());     // THIS CALLS OUR OTHER CONSTRUCTOR! important af
    }

    public Customer(String name, String surname, LocalDate dateofbirth) {
        this(name, surname, dateofbirth, true); // this calls the Constructor above, that calls the Constructor above...
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public boolean isFemale() {
        return female;
    }

    public double getSpecialAccountBalance(){    // returns highest balance for females, lowest for males
        double balance = 0;
        if (female) {
            for (Account a : accounts) {
                if (a.getBalance() > balance) {
                    balance = a.getBalance();
                }
            }
        } else {
            // setta il minimo al primo elemento dell'arrayList
            for (Account a : accounts) {
                // checka per nuovi minimi, come sopra
            }
        }
        return balance;
    }
}
