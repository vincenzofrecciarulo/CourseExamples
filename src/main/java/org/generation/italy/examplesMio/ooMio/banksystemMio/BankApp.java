package org.generation.italy.examplesMio.ooMio.banksystemMio;

public class BankApp {

    public static void main(String[] args) {

        // Creiamo un client
        Client mario = new Client("Mario", "Rossi", "01/01/1990", "M");

        // Creiamo qualche account
        Account a1 = new Account(1000);
        Account a2 = new Account(500);
        Account a3 = new Account(250);
        Account a4 = new Account(250);
        Account a5 = new Account(250);


        // Aggiungiamo gli account
        System.out.println(mario.addAccount(a1));
        System.out.println(mario.addAccount(a2));
        System.out.println(mario.addAccount(a3));
        System.out.println(mario.addAccount(a4));
        System.out.println(mario.addAccount(a5));

        // Saldo totale
        System.out.println("Totale: " + mario.getTotalBalance());

        // Rimuoviamo l'account in posizione 1 (a2)
        System.out.println(mario.removeAccount(1));
        System.out.println("Totale dopo rimozione: " + mario.getTotalBalance());

        // Transfer dal conto 0 al conto 1 (a1 → a3)
        System.out.println(mario.transfer(0, 1, 200));
        System.out.println("Totale (invariato): " + mario.getTotalBalance());

        // Caso illegale
        System.out.println(mario.removeAccount(10));

        // Caso somma 5 input
        System.out.println("---------------");
        mario.divide(0.2, 0.3, 0.1, 0.4, 0);


        //Stampa finale
        System.out.println(mario);
    }
}
