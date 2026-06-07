package org.generation.italy.examplesMio.ooMio.banksystemMio;

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
        return  removed;
    }

    public boolean removeAccount(Account toRemove){
        boolean removed = accounts.remove(toRemove);
        return removed;
    }

    public double getTotalBalance(){
        double sum = 0;
//        for(int i = 0; i < accounts.size(); i++){
//            Account x = accounts.get(i);
//              x = new Account(50); l'arraylist non cambia poichè viene modificata una copia e non l'originale
//            sum += x.getBalance();
//        }
        //in un for each non posso cambiare il contenuto di un array
        //nel ciclare su delle strutture dati spesso vorremmo usare un ITERATORE
        for(Account x : accounts){
            sum += x.getBalance();
        }
        return sum;
    }
}