/*
un Clent ha nome, cognome, data di nascita e sesso.
Ogni client può possedere tra 0 e 5 account (avrà array di account) e avrà un metodo addAccount per aggiungere un nuovo account.
addAccount deve ovviamente tenere conto di questo limite (booleane, false..)
dovrà avere un metodo removeAccount, che prende in input un intero i e rimuoverà l'account del cliente in posizione i.
se gli passo una posizione "illegale", non rimuove niente e ritorna false.
Inoltre il Client avrà un metodo getTotalBalance, che restituisce la somma dei balance di tutti i suoi account.
OPZIONALE: un ultimo metodo transfer, che prende in input due interi i e j ed un double amount, e trasferisce denato.
abbia > amount (amount è quanto siamo cercando di trasferire). Anche questo ritornerà un boolean.
 */

package org.generation.italy.examples.oo.banksystem;

public class Client {
    String name = "";
    String surname = "";
    double birthday;
    String gender = "";

    Account[] accounts = new Account[5];

    int accountCounter = 0;

    public boolean addAccount(Account account){
        if (accountCounter >= 5){
            return false;
        }
        accounts[accountCounter] = account;
        accountCounter++;
        return true;
    }

    public double getTotalBalance(){
        double sumBalance = 0;
        for (int i = 0; i < accountCounter; i++){
            sumBalance = sumBalance + accounts[i].balance;
        }
        return sumBalance;
    }

    public boolean removeAccount(int i){
        if(i < 0 || i >= accountCounter){
            return false;
        }
        return true;
    }
}
