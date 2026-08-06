package org.generation.italy.examples.oo.homeexercise.gemexercise;

public class Main {
    public static void main(String[] args) {
        Prodotto patatine = new Prodotto("patatine", 1.50, 3);

        double creditoInserito = 2.00;

        System.out.println("Credito iniziale: " + creditoInserito + "€");
        System.out.println("Vuoi comprare: " + patatine.getNome() + (" Prezzo: " + patatine.getPrezzo() + "€"));

        if (creditoInserito >= patatine.getPrezzo()) {
            patatine.scaleProductsQuantity();
            double resto = creditoInserito - patatine.getPrezzo();
            System.out.println("Acquisto riuscito! Il tuo resto è: € " + resto );
        } else {
            System.out.println("Credito insufficiente!");
        }
    }
}
