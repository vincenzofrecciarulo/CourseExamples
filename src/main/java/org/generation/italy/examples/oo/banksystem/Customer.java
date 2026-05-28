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

        if(accounts.isEmpty()) {
            return 0;
        }

        // we need to declare balance after the empty check, otherwise if accounts ArrayList is empty it will throw after getFirst()
        double balance = accounts.getFirst().getBalance();

        if (female) {
            for (Account a : accounts) {
                // checks for new max balance
                if (a.getBalance() > balance) {
                    balance = a.getBalance();
                }
            }
        } else {
            for (Account a : accounts) {
                // checks for new min balance
                if (a.getBalance() < balance) {
                    balance = a.getBalance();
                }
            }
        }
        return balance;
    }
}
