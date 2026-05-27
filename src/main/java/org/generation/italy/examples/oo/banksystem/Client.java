package org.generation.italy.examples.oo.banksystem;

public class Client {
    /*
    un Client ha nome, cognome, data di nascita e sesso.
    ogni client può possedere tra 0 e 5 account (avrà un array di account) e avrà un metodo
    addAccount per aggiungere un nuovo account. addAccount deve ovviamente tenere conto di questo limite (booleane, false...)
    dovrà anche avere un metodo removeAccount, che prende in input un intero i e rimuoverà l'account del cliente in posizione i.
    se gli passo una posizione "illegale", non rimuove niente e ritorna false.
    inoltre, il Client avrà un metodo getTotalBalance, che restituisce la somma dei balance di tutti i suoi Account.
    OPZIONALE: un ultimo metodo transfer, che prende in input due interi i e j e un double amount, e trasferisce denaro
    dal conto i al conto j, sempre tenendo conto che questi due conti esistano, e che l'account che trasferisce denaro
    abbia balance > amount (amount è quanto stiamo cercando di trasferire). anche questo ritornerà un boolean.

    POI: una funzione che riceve in input 5 numeri double compresi tra 0 e 1 la cui somma fa 1, e il metodo deve
    ridistribuire i soldi nei vari account in base a questi numeri.

    UTILIZZARE INT da 1 a 100, NON DOUBLE da 0 a 1. SONO MENO PRECISI ed è pericoloso. Altrimenti dovremmo paragonarli con
    un delta, ma sarebbe comunque pericoloso per l'inesattezza dei double.
    */
    public String name;
    public String surname;
    public String birthDate;
    public String gender;
    public Account[] accounts = new Account[5];  // references default to null
    public int accountCounter = 0;

    public Client(String name, String surname, String birthDate, String gender) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    // ovviamente qua ho sbagliato. rifarlo utilizzando il parametro a
    public boolean addAccount(Account a) {
        if (accountCounter > 5) {
            System.out.println("Too many accounts! You can have max 5. ");
            return false;
        } else {
            for (int i = 0; i < accounts.length; i++) {
                if(accounts[i] == null) {
                    accounts[i] = new Account(0);
                    accountCounter++;
                    return true;
                }
            }
        }
    }



}
