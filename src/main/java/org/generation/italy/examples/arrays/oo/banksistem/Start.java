package org.generation.italy.examples.arrays.oo.banksistem;

public class Start {

    static void main() {

        Account a = new Account(1000.0);

        // IO.println(a.balance);
        // a.balance = 0;

        IO.println(a.getBalance());
        a.setBalance(0);

        /*
        l'incapsulamento è una tecnica di ingegneria del software che rende il privato lo stato di una classe
        in modo da permettere l'evoluzione di questo stato senza ripercussioni fuori dalla classe stessa
        */

        Bank b = Bank.getInstance();

    }
}