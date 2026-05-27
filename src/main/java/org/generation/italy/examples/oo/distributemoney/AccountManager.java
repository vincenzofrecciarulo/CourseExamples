package org.generation.italy.examples.oo.distributemoney;

public class AccountManager {

    public double totale;

    public AccountManager(double totale) {
        this.totale = totale;
    }

    public void distribute(boolean[] scelti) {

        int count = 0;

        // conta account selezionati
        for (boolean b : scelti) {
            if (b) count++;
        }

        if (count == 0) {
            System.out.println("Nessun account selezionato.");
            return;
        }

        double quota = totale / count;

        System.out.println("\n--- Distribuzione patrimonio ---");

        for (int i = 0; i < 5; i++) {

            double valore = scelti[i] ? quota : 0;

            System.out.println("Account " + (i + 1) + ": " + valore + " €");
        }
    }
}