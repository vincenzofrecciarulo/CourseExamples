package org.generation.italy.examples.oo.banksystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
    private String name;
    private String surname;
    private LocalDate dob;
    private boolean female;
    private ArrayList<Account> accounts;


    public Customer(String name, String surname, LocalDate dob, boolean female, ArrayList<Account> accounts) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.female = female;
        this.accounts = accounts;
    }

    public Customer(String name, String surname, LocalDate dob, boolean female) {
        this(name, surname, dob, female, new ArrayList<>());    //Invoca il costruttore in alto, il programma lo capisce dagli argomenti che gli passa, così prende tutto che gli è passato dalla classe esterna e poi gli genera un ArrayList vuoto.
    }

    public Customer(String name, String surname, LocalDate dob){
        this(name,surname,dob,false);                   //'Per creare questa catena ogni costruttore deve passare all'altro sopra di esso il valore mancante, come vogliamo che sia di default
    }

    public Customer(String name, String surname) {
        this(name, surname, null);
    }

    public Customer(String name){
        this(name, "");
    }


    /*
    ritorna la balance più alta tra gli account se il customer è female o bassa se il customer è maschio
    Per non ripetere il codice identico due volte che differiva soltanto nel > e < ho moltiplicato i fattori della condizione
    per 1 se l'account è femmina così non effettuava un bel niente e per -1 se l'account era maschio, così semplicemente
    la condizione vedeva sempre il numero matematicamente più grande, ma che nel caso dei negativi (account maschio) era il numero
    più piccolo, dunque il minore per i numeri positivi reali.
     */
    public double getSpecialAccountBalance(){
        double balance = accounts.get(0).getBalance();
        int maxMin = female ? 1 : -1;
            for (Account i : accounts) {
                if (i.getBalance()*maxMin>balance*maxMin) {
                    balance = i.getBalance();
                }
            }
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public boolean isFemale() {
        return female;
    }
}
