package org.generation.italy.examples.oo.banksystem;

public class Client {
    // Un client ha un nome, un cognome, una data di nascita e un sesso
    // Inoltre puo avere da 0 a 5 account associati a lui e
    // ha un metodo addAccount che aggiunge a un array di Account un account e non deve aggiungere oltre il limite (deve ritornare un boolean)
    // inoltre deve avere un metodo removeAccount che prende come input un numero i che rimuove un account nella posizione i dell'array
    // anche questo deve ritornare true o false a seconda se ha rimosso o meno
    // inoltre il cliente avra un metodo getTotalBalance che restituisce il balance totale di tutti i suoi conti
    // OPZIONALE ha un ultimo metodo di nome transfer che prende come input due interi i e j, e un double amount che
    // trasferisce da un conto in posizione i a uno in posizione j di una cifra amount
    // deve ritornare un boolean
    // un metodo che riceve 5 numeri che la somma fa 1 che rappresenta la percentuale di soldi che va ridistribuita in ogni account

    public String name;
    public String cognome;
    public String data;
    public String sesso;
    public int accountCounter = 0;

    public Account[] accounts = new Account[5];

    public Client(String name, String cognome, String data, String sesso){
        this.name = name;
        this.cognome = cognome;
        this.data = data;
        this.sesso = sesso;
    }

    public boolean addAccount(Account account){
        if(accountCounter > 5){
            return false;
        }
        accounts[accountCounter] = account;
        accountCounter++;
        return true;
    }

    public boolean removeAccount(int i){
        if(i < 0 || i > accountCounter - 1){
            return false;
        }
        accounts[i] = null;
        accountCounter--;
        return true;
    }

    public double getTotalBalance(){
        double totalBalance = 0;
        for(int i = 0; i < accountCounter; i++){
            totalBalance += accounts[i].balance;
        }
        return totalBalance;
    }

    public boolean transfer(int i, int j, double amount){
        if(i < 0 || i > accountCounter - 1 || j < 0 || j > accountCounter - 1 || i == j || amount < 0){
            return false;
        }
        boolean isSuccess = accounts[i].withdraw(amount);
        if(!isSuccess){
            return false;
        }
        accounts[j].deposit(amount);
        return true;
    }

    public boolean ridistribuiteBalance(int[] weights){
        if(weights.length != 4){
            return false;
        }
        int sumWeight = 0;

        return true;
    }
}
