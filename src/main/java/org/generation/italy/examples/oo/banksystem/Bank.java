package org.generation.italy.examples.oo.banksystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bank {
    // SINGLETON. Design pattern per cui
    // CREIAMO UN SOLO OGGETTO per una data classe.
    // In questo esempio, abbiamo una Bank che contiene i vari Account.
    // Vogliamo avere SOLO UN OGGETTO BANK in tutto il progetto.
    // Per farlo, creiamo un oggetto Bank come variabile statica della classe Bank.
    // Ne approfittiamo per vedere anche gli ArrayList.
    private ArrayList<Account> accounts;
    private LocalDate creationDate;

    // for the singleton, the object variable NEEDS TO BE STATIC,
    // otherwise with this line we'd have a Bank object inside every Bank object,
    // and we would finish our memory.
    // this way, instead (private static Bank instance = new Bank()) we have ONLY ONE object, that is inside the class,
    // not the object.
    private static Bank instance = new Bank();   // SINGLETON design pattern. we access the object via getBank method below

    private Bank() {
        accounts = new ArrayList<>();
        creationDate = LocalDate.now();
    }

    public static Bank getInstance() { // SINGLETON design pattern. we can access this object outside
        return instance;              // (the only Bank object that'll ever exist) via Bank.getInstance()
    }

    // demonstrating ArrayLists and other things
    public int addAccount(Account account) {
        accounts.add(account);
        return accounts.size();
    }

    public Account removeAccount(int pos) {
        Account removed = accounts.remove(pos);
        return removed;
    }

    public boolean removeAccount(Account toRemove) {
        boolean removed = accounts.remove(toRemove);     // returns boolean
        return removed;
    }

    public double getTotalBalance() {
        double sum = 0;
//        for (int i=0; i<accounts.size(); i++) {    // iterating on ArrayLists
//            Account x = accounts.get(i);          // getting element at index i in ArrayLists
//            sum += x.getBalance();
//        }

        for (Account x : accounts) {   // for-each loop. in a for-each, we CAN'T CHANGE THE CONTENTS OF THE ARRAY
            sum += x.getBalance();
            // this WOULDN'T CHANGE the contents of the ArrayList. x is a COPY of the elements
            // in the ArrayList, so we wouldn't affect the ArrayList contents at all
//            x = new Account(50);
        }
        return sum;
    }
}
