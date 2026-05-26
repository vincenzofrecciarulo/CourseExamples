package org.generation.italy.examples.oo.banksystem;

// Un client ha un nome, un cognome, una data di nascita e un sesso
// Inoltre puo avere da 0 a 5 account associati a lui e
// ha un metodo addAccount che aggiunge a un array di Account un account e non deve aggiungere oltre il limite (deve ritornare un boolean)
// inoltre deve avere un metodo removeAccount che prende come input un numero i che rimuove un account nella posizione i dell'array
// anche questo deve ritornare true o false a seconda se ha rimosso o meno
// inoltre il cliente avra un metodo getTotalBalance che restituisce il balance totale di tutti i suoi conti
// OPZIONALE ha un ultimo metodo di nome transfer che prende come input due interi i e j, e un double amount che
// trasferisce da un conto in posizione i a uno in posizione j di una cifra amount
// deve ritornare un boolean

public class Client {
    public String name;
    public String surname;
    public String dateOfBirth;
    public String gender;
    public Account[] accounts = new Account[5];   // array che contiene oggetti Account.
    public int numOfCurrentAccounts; // Tiene traccia del numero di account presenti

    // Creiamo ora il costruttore esplicito
    public Client(String name, String surname, String dateOfBirth, String gender) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    // Metodo per aggiungere un account
    public boolean addAccount(Account singleAccount){

        // Scorre tutto l'array
        for(int i = 0; i < accounts.length; i++){
            // Cerca una posizione vuota
            if(accounts[i] == null){
                // Inserisce l'account
                accounts[i] = singleAccount;
                numOfCurrentAccounts++;

                return true;
            }
        }

        // Nessuno spazio disponibile
        return false;
    }


    // Metodo per rimuovere account
    public boolean removeAccount(int accountPosition){

        // Controllo indice valido
        if(accountPosition < 0 || accountPosition >= accounts.length){
            return false;
        }

        // Controllo della presenza dell'account nell'array accounts
        if(accounts[accountPosition] == null){
            return false;
        }

        // Rimozione dell'account
        accounts[accountPosition] = null;
        numOfCurrentAccounts--;

        return true;
    }

    // Metodo che restituisce il balance totale
    public double getTotalBalance(){

        double total = 0;

        // Scorre tutti gli accounts
        for(int i = 0; i < accounts.length; i++){

            // Se l'account esiste
            if(accounts[i] != null){

                // Somma il saldo
                total += accounts[i].balance;
            }
        }

        return total;
    }

    // Metodo transfer tra due account del cliente
    public boolean transfer(int i, int j, double amount){

        // Controllo indice sorgente
        if(i < 0 || i >= accounts.length){
            return false;
        }

        // Controllo indice destinazione
        if(j < 0 || j >= accounts.length){
            return false;
        }

        // Controllo esistenza account
        if(accounts[i] == null || accounts[j] == null){
            return false;
        }

        // Trasferimento
        return accounts[i].transfer2(amount, accounts[j]);
    }
}