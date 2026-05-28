package org.generation.italy.examples.oo.banksystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Start {
    static void main() {
        Account a = new Account(1000.0);
        // IO.println(a.balance);
        // a.balance = 0;
        IO.println(a.getBalance());
        a.setBalance(0);
        /*l'incapsulamento è una tecnica di ingegneria del software che rende il privato lo stato di una classe
          in modo da permettere l'evoluzione di questo stato senza ripercussioni fuori dalla classe stessa
        */
        Bank b = Bank.getInstance();
        Account b2 = new Account(1000.0);
        IO.println(a==b2);
        IO.println(a.equals(b2));
        //equals è uguale ad ==, ma a sua differenza può essere ridefinito
        //questo è il metodo utilizzaro da remove
        b.addAccount(a);
        boolean removed = b.removeAccount(b2);
        IO.println(removed);
        removed = b.removeAccount(a);
        IO.println(removed);
        Customer c = new Customer("Ciccio", "Pasticcio", LocalDate.now());

        Account d1 = new Account(100.0);
        Account d2 = new Account(250.0);
        Account d3 = new Account(50.0);

        ArrayList<Account> accounts = new ArrayList<>(List.of(d1, d2, d3));

// female = true → dovrebbe restituire 250.0 (massimo)
        Customer c1 = new Customer("Chiara", "De Santis", LocalDate.now(), true, accounts);
        System.out.println(c1.getSpecialAccountBalance()); // 250.0

// female = false → dovrebbe restituire 50.0 (minimo)
        Customer c2 = new Customer("Mario", "Rossi", LocalDate.now(), false, accounts);
        System.out.println(c2.getSpecialAccountBalance()); // 50.0
    }
}
