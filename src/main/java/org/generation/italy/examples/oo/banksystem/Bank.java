package org.generation.italy.examples.oo.banksystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private LocalDate creationDate;

    private static Bank instance = new Bank();
    private Bank(){                         //Solo in questa classe possiamo creare l'oggetto Bank
        accounts = new ArrayList<>();
        creationDate = LocalDate.now();
    }

    public static Bank getInstance() {       // Il get solitamente si chiama come la variabile
        return instance;
    }

    public int addAccount(Account account){
        accounts.add(account);
        return accounts.size();
    }

    public Account removeAccount(int pos){
       Account removed = accounts.remove(pos);
       return removed;
    }

    public boolean removeAccount(Account toRemove){
       boolean removed = accounts.remove(toRemove);
       return removed;
    }

    public double getTotalBalance() {
        double sum = 0;
        for (Account i : accounts)
            sum += i.balance;
        return sum;
    }


}
