package org.generation.italy.examples.oo.bank.bank;

import com.generation.library.Console;

import java.time.LocalDate;
import java.util.ArrayList;

//un client ha nome, cognome, data di nascita e sesso. puo' possedere da 0 a 5 account(array di account).
// avra un metodo add acoount, non puo aggiungere piu di 5 account. deve avere anche un metodo remove account
//che prende di input i e rimuove l'account selezionato, se selezioniamo un account inesistente dira' false.
//Il cliente avra un metodo get total balance che dira il balance di tutti i suoi conti.
//ultimo metodo transfer: prendo in input 2 interi e 1 double, e trasferisci i soldi se disponibili (da posizionei a
// posizione j una cifra amount.
public class Client {
    private String name;
    private String surname;
    private LocalDate birth;
    private boolean gender;
    private ArrayList<Account> accounts;

    public Client(String name, String surname, LocalDate birth, boolean gender, ArrayList<Account> accounts) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.gender = gender;
        this.accounts = accounts;
    }

    public Client(String name, String surname, LocalDate birth, boolean gender) {
        this(name, surname, birth, gender, new ArrayList<>());
    }

    public Client() {

    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public static Client register() {
        System.out.println("registrati inserendo il nome, cognome, data di nascita e sesso.");
        System.out.println("Nome: ");
        String name =Console.readString();
        System.out.println("Cognome: ");
        String surname =Console.readString();
        System.out.println("Giorno di nascita: ");
        int dayBirth = Console.readInt();
        System.out.println("Mese di nascita: ");
        int moBirth = Console.readInt();
        System.out.println("Anno di nascita: ");
        int yeBirth = Console.readInt();
        LocalDate birth = LocalDate.of(yeBirth, moBirth, dayBirth);

        boolean gender = false;
        boolean valid = false;

        while (!valid) {
            System.out.println("Sesso (M/F): ");
            String inputGender = Console.readString();

            if (inputGender.equalsIgnoreCase("M") ||
                    inputGender.equalsIgnoreCase("Maschio")) {
                gender = true;
                valid = true;
            } else if (inputGender.equalsIgnoreCase("F") ||
                    inputGender.equalsIgnoreCase("Femmina")) {
                gender = false;
                valid = true;
            } else {
                System.out.println("Valore non valido, inserisci M/Maschio o F/Femmina!");
            }
        }
        System.out.println("Il cliente e' stato registrato correttamente!");
        return new Client (name, surname, birth, gender);

    }

    public void login() {
            System.out.println("Per effettuare il login dimmi il nome e cognome.");
            for (int i=2; i>-1; i--) {
                String rispLogin = Console.readString();
                if (i > 0 && rispLogin.equalsIgnoreCase(this.name + " " + this.surname)) {
                    System.out.println("Login effettuato correttamente, puoi procedere.");
                    Operations.Operation(this);
                } else if (i > 0) {
                    System.out.println("Accesso negato, ti sono rimasti " + i + " tentativi:");
                } else {
                    System.out.println("Accesso negato, disconnessione.");
                    System.exit(0);
                }
            }
    }

    public void openAccount() {
        if (accounts.size() >= 5) {
            System.out.println("Hai gia' 5 conti registrati, non puoi registrarne altri!");
            return;
        }
        System.out.println("Inserisci nome conto: ");
        String accName = Console.readString();
        System.out.println("Inserisci saldo iniziale: ");
        double balance = Console.readDouble();
        accounts.add(new Account(accName, balance));
        System.out.println("Il conto e' stato registrato correttamente!");
    }

    public void visualize() {
        if (accounts.isEmpty()) {
            System.out.println("Nessun conto registrato!");
            return;
        }
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("Conto " + i +
                    " - Nome: " + accounts.get(i).getAccName() +
                    " - Saldo: " + accounts.get(i).getBalance());
        }
    }

}

