package org.generation.italy.examples.oo.banksystem;

import org.generation.italy.examples.arrays.oo.banksistem.Account;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private LocalDate creationDate;

    private static Bank instance = new Bank();
    private Bank() {

        // Solo in questa classe possiamo creare l'oggetto Bank
        accounts = new ArrayList<>();
        creationDate = LocalDate.now();
    }

    // Il getter solitamente si chiama come la variabile
    public static Bank getInstance() {
        return instance;
    }

    public int addAccount(Account account) {
        accounts.add(account);
        return accounts.size();
    }

    public Account removeAccount(int pos) {
        Account remove = accounts.remove(pos);
        return remove;
    }

    public boolean removeAccount(Account toRemove) {
        boolean removed = accounts.remove(toRemove);
        return removed;
    }
}