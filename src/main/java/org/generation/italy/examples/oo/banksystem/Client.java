package org.generation.italy.examples.oo.banksystem;
// Un client ha un nome, un cognome, una data di nascita e un sesso
// Inoltre puo avere da 0 a 5 account associati a lui



public class Client {
    // Attributi
    public String name;
    public String surname;
    public String dateOfBirth;
    public char gender;
    public static int MAX_ACCOUNT = 5;
    public Account[] accounts = new Account[MAX_ACCOUNT]; //max 5
    public int currentAccount;


    // Costruttore
    public Client(String name, String surname, String dateOfBirth, char gender){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    // Metodi

    // ha un metodo addAccount che aggiunge a un array di Account un account
    // e non deve aggiungere oltre il limite (deve ritornare un boolean)
    public boolean addAccount(Account account){
        if (currentAccount >= accounts.length) {
            return  false;
        }
        accounts[currentAccount] = account;
        currentAccount++;
        return true;
    }

    // inoltre deve avere un metodo removeAccount che prende come input un numero i
    // che rimuove un account nella posizione i dell'array
    // anche questo deve ritornare true o false a seconda se ha rimosso o meno
    public boolean removeAccount(int accountPosition){
        // controlla il numero dato in input se non valido è false
        if (accountPosition <= 0 || accountPosition > currentAccount) return false;
        // se supera il primo controllo, iniziamo con il ciclo, il numero che viene messo in input dall'utente
        // sarà diverso dall'indice reale dell'account.
        // il ciclo continua finchè l'indice è minore della quantita di account che abbiamo.
        for (int i = accountPosition - 1; i < currentAccount - 1; i++ ) {
            // l'account con quell'indice lo sovrascriviamo con quello dopo
            accounts[i] = accounts[i + 1];
        }
        // account presente nell'ultima posizione diventa null e diminuiamo il numero di account
        currentAccount--;
        accounts[currentAccount] = null;
        return true;
    }

    // inoltre il cliente avra un metodo getTotalBalance che restituisce il balance totale di tutti i suoi conti
    public double getTotalBalance(){
        double sum = 0;
        for (int i = 0; i < currentAccount; i++){
            sum += accounts[i].balance;
        }
        return sum;
    }

    // OPZIONALE ha un ultimo metodo di nome transfer che prende come input due interi i e j, e un double amount che
    // trasferisce da un conto in posizione i a uno in posizione j di una cifra amount
    // deve ritornare un boolean
    public boolean transfer(int from, int to, double amount){
        if (currentAccount < 1 || from == to) return false;
        if (from > currentAccount || to > currentAccount) return false;
        boolean isTransferred = accounts[from-1].transfer2(amount,accounts[to-1]);
        return isTransferred;
    }
}
