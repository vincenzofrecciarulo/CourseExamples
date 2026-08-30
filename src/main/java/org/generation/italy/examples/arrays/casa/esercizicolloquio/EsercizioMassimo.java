package org.generation.italy.examples.arrays.casa.esercizicolloquio;

public class EsercizioMassimo {
    public static int massimo(int[] numeri) {
        int max = numeri[0];
        // completa tu: confronta ogni elemento e aggiorna max se serve
        for(int i = 0; i < numeri.length; i++){
            if(numeri[i] > max){
                max = numeri[i];
            }
        }
        return max;
    }
}