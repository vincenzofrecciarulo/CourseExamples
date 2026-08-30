package org.generation.italy.examples.arrays.casa.esercizicolloquio;
public class EsercizioSommaArray {
    public static int somma(int[] numeri) {
        int totale = 0;
        // completa tu: scorri l'array e aggiungi ogni elemento a totale
        for(int i= 0; i < numeri.length; i++){
            totale += numeri[i];
        }
        return totale;
    }
    public static void main(String[] args) {
        int[] numeri = {1, 2, 3, 4, 5};
        System.out.println(somma(numeri)); // deve stampare 15
    }
}
