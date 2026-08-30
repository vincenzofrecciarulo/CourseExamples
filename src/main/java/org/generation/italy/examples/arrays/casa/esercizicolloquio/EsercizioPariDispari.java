package org.generation.italy.examples.arrays.casa.esercizicolloquio;
public class EsercizioPariDispari {
    public static boolean isPari(int numero) {
        if(numero % 2 == 0){
            return true;
        }
        return false;
        // completa tu: restituisci true se il numero è pari, false se dispari
    }

    public static void main(String[] args) {
        System.out.println(isPari(4)); // deve stampare true
        System.out.println(isPari(7)); // deve stampare false
    }
}