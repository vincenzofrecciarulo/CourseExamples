// Un client ha un nome, un cognome, una data di nascita e un sesso
// Un client può avere da 0 a 5 account associati a lui
// Ha un metodo addAccount che aggiunge a un array di Account un account e non deve aggiungere oltre il limite (deve ritornare un boolean)
// Inoltre deve avere un metodo removeAccount che prende in input un intero e rimuove un account nella posizione relativa del suo array di account (se alla posizione non c'è, ritorna false)
// Infine il cliente avrà un metodo getTotalBalance che restituisce la somma delle balance di tutti i suoi conti
// OPZIONALE: metodo transfer prende in input due interi i e j e un double amount e trasferisce l'amount dal conto i al j, restituisce false se non ci sono disponibilità economiche o errati i numeri di conto
// Funzione che riceve in input 5 numeri double la cui somma fa 1, il metodo redistribuisce i soldi fra i vari account in proporzione a questi numeri (0.5,0.5,0,0,0) Tutto il patrimonio va equo tra i primi due account

package org.generation.italy.examples.oo.banksystem;

import java.util.ArrayList;

public class Client {

    public String name;
    public String surname;
    public String dateOfBirth;
    public String gender;
    public Account[] accounts = new Account[5];


    public Client (String name, String surname, String dateOfBirth, String gender) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public boolean addAccount() {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = new Account(0) ;
                return true;
            }
        }
        return false;
    }

    public boolean removeAccount(int removeNumber) {
        int indexToRemove = removeNumber-1;                             //Considero che il numero dell'account da rimuovere sia da 1 a 5, non da 0 a 4
        if (accounts[indexToRemove]==null) {
            return false;
        } else {
            for (int i=indexToRemove; i<accounts.length-1; i++) {
                accounts[i]=accounts[i+1];
            }
            accounts[accounts.length-1] = null;
            return true;
        }
    }

    public double getTotalBalance() {
        double totalBalance = 0;
        for (Account i : accounts) {
            totalBalance += i.balance;
        }
        return totalBalance;
    }

    public boolean transfer(int i, int j, double amount) {
        int indexFrom = i-1;
        int indexTo = j-1;
        if (accounts[indexFrom] == null || accounts[indexTo] == null || accounts[indexFrom].balance < amount) {
            return false;
        }
        accounts[indexTo].deposit(amount);
        accounts[indexFrom].withdraw(amount);
        return true;
    }

    public void spreadBalance (double a, double b, double c, double d, double e) {
        if (a+b+c+d+e != 1)
            return;
        double totalBalance = getTotalBalance();
        accounts[0].balance = totalBalance*a;
        accounts[1].balance = totalBalance*b;
        accounts[2].balance = totalBalance*c;
        accounts[3].balance = totalBalance*d;
        accounts[4].balance = totalBalance*e;
    }

}
