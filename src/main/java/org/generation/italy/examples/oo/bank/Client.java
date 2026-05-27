package org.generation.italy.examples.oo.bank;

import com.generation.library.Console;

//un client ha nome, cognome, data di nascita e sesso. puo' possedere da 0 a 5 account(array di account).
// avra un metodo add acoount, non puo aggiungere piu di 5 account. deve avere anche un metodo remove account
//che prende di input i e rimuove l'account selezionato, se selezioniamo un account inesistente dira' false.
//Il cliente avra un metodo get total balance che dira il balance di tutti i suoi conti.
//ultimo metodo transfer: prendo in input 2 interi e 1 double, e trasferisci i soldi se disponibili (da posizionei a
// posizione j una cifra amount.
public class Client {
    public String name;
    public String surname;
    public String birth;
    public String gender;
    public Accounts[] account = new Accounts[5];




    public Client(String name, String surname, String birth, String gender) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.gender = gender;
    }

    public static Client register() {
        System.out.println("registrati inserendo il nome, cognome, data di nascita e sesso.");
        System.out.println("Nome: ");
        String name =Console.readString();
        System.out.println("Cognome: ");
        String surname =Console.readString();
        System.out.println("Data di nascita: ");
        String birth =Console.readString();
        System.out.println("Sesso: ");
        String gender =Console.readString();
        System.out.println("Il cliente e' stato registrato correttamente!");
        return new Client (name, surname, birth, gender);
    }

    public void login() {
        System.out.println("Per effettuare il login dimmi il nome e cognome.");
        String rispLogin = Console.readString();
        if (rispLogin.equalsIgnoreCase(this.name + " "+ this.surname)) {
            System.out.println("Login effettuato correttamente, puoi procedere.");
            Operations.Operations(this);
        } else
            System.out.println("Accesso negato, riprova.");

    }

    public void openAccount() {
        int place = -1;
        for (int i=0; i < account.length; i++) {
            if (account[i] == null) {
                place = i;
                break;
            }
        }
        if (place ==-1) {
            System.out.println("Hai gia' 5 conti registrati, non puoi registrarne altri!");
            return;
        }
        System.out.println("Inserisci nome conto: ");
        String accName = Console.readString();
        System.out.println("Inserisci saldo iniziale: ");
        double balance = Console.readDouble();
        account[place] = new Accounts(accName, balance);
        System.out.println("Il conto e' stato registrato correttamente!");
    }

    public void visualize() {
        for (int i = 0; i < account.length; i++) {
            if (account[i] != null) {
                System.out.println("Conto " + i + " - Nome: " + account[i].accName + " - Saldo: " + account[i].balance());
            }
        }
    }

}

