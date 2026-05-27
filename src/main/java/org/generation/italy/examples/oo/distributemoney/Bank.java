package org.generation.italy.examples.oo.distributemoney;

// Funzione che riceve in input 5 numeri double la cui somma fa 1,
// il metodo redistribuisce i soldi fra i vari account in proporzione a questi numeri.
// Esempio (0.5,0.5,0,0,0) tutto il patrimonio va equo tra i primi due account

public class Bank {
    public static void main(String[] args) {

        double totale = Double.parseDouble(
                IO.readln("Inserisci il patrimonio totale: ")
        );

        boolean[] scelti = new boolean[5];

        System.out.println("\nOra decidi su quali accounts vuoi redistribuire il patrimonio.");

        for (int i = 0; i < 5; i++) {

            scelti[i] = IO.readln(
                    "Usare account " + (i + 1) + " (yes/no)? "
            ).equalsIgnoreCase("yes");
        }

        // creazione oggetto
        AccountManager manager = new AccountManager(totale);

        // esecuzione logica
        manager.distribute(scelti);
    }
}