package org.generation.italy.examples.arrays;
/*
Ex2Bis
Dato un array di 10 elementi,
scrivere una funzione che popola l’array con numeri interi casuali di valore 1-10.
Successivamente il programma deve stampare un messaggio per l’utente
dicendo se nell’array ci sono elementi duplicati o no
 */
public class Exercise2Bis {

    public static void populateRandomNumbersArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*10)+ 1;
        }

    }
    public static boolean hasUniqueNumbers(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] == arr[j]){
                    return false;
                }
            }
        }
        return true;
    }
}
