/*
Ex2
Scrivere una funzione che popola un array con numeri interi casuali di valore 1-10

Ex2Bis
Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore 1-10.
Successivamente il programma deve stampare un messaggio per l’utente dicendo se nell’array ci sono elementi duplicati o no

Ex2Tris (solitaria) - DIFFICILE, consiglio di farlo per ultimo
Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore 1-10.
Successivamente il programma deve stampare gli elementi duplicati
 */

package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise6 {
    static void main() {
        int[] array = new int[10];
        popolaArray(array);
        System.out.println(Arrays.toString(array));
        boolean duplicati = verificaDuplicati(array);
        if (duplicati){
            System.out.println("All'interno dell'array sono presenti uno o più duplicati.");
            stampaDuplicati(array);
        }
    }
    // #1 generare una funziona che genera numeri random
    static int generaNumeriCasuali(){
        double number = Math.random();
        return (int) Math.floor(number*10)+1;
    }
    static void popolaArray(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = generaNumeriCasuali();
        }
    }
    static boolean verificaDuplicati(int[]array){
        for (int i = 0; i < array.length-1; i++){
            for (int j = i+1; j < array.length; j++){
                if (array[i] == array[j]){
                    return true;
                }
            }
        }
        return false;
    }
    static void stampaDuplicati(int[]array){
        int[] duplicati = new int[array.length/2];
        int counter = 0;

        for (int i = 0; i < array.length-1; i++){
            for (int j = i+1; j < array.length; j++){
                if (array[i] == array[j]){
                    boolean found = false;
                    for (int k = 0; k < counter; k++){ //iterando su duplicati
                        if (duplicati[k] == array[i]){
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        duplicati[counter] = array[i];
                        counter++;
                    }
                }
            }
        }
        System.out.println("I dupplicati sono i numeri: ");
        for (int k = 0; k < counter; k++) {
            System.out.println(duplicati[k]);
        }
    }
}
