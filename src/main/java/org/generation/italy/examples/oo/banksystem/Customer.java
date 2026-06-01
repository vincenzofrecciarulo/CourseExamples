package org.generation.italy.examples.oo.banksystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
    private final String name;
    private final String surname;
    private final LocalDate dob;
    private final boolean female;
    private final ArrayList<Account> accounts;

    public Customer(String name, String surname, LocalDate dob, boolean female, ArrayList<Account> accounts) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.female = female;
        this.accounts = accounts;
    }
    //questo costruttore invoca il costruttore in alto
    public Customer(String name, String surname, LocalDate dob, boolean female) {
        this(name, surname, dob, female, new ArrayList<>());
    }
    public Customer(String name, String surname, LocalDate dob){
        this(name, surname, dob, true);
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

    public double getSpecialAccountBalance(){
        if(accounts.isEmpty()){
            return 0;
        }
        double balance = accounts.getFirst().getBalance();
        if(female){
            for(Account a : accounts){
                if(a.getBalance() > balance){
                    balance = a.getBalance();
                }
            }
        }else{
            for(Account a : accounts){
                if(a.getBalance() < balance){
                    balance = a.getBalance();
                }

            }
        }
        return balance;
    }
}
