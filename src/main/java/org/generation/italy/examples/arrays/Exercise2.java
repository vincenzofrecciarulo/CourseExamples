package org.generation.italy.examples.arrays;

import java.util.Arrays;

/* Dato un array di 10 elementi scrivere funzione che popola array con numeri interi casuali da 1 a 10, li stampi,
 e successivamente tramite una funzione, scriva un messaggio se contiene numeri duplicati
 infine il programma deve stampare gli elementi duplicati. FARE QUESTO
*/

public class Exercise2 {
    public static void main(){
        int[]  array= new int[10];
        populateArray(array);
        boolean hasDuplicate = hasDuplicated(array);
        IO.println(Arrays.toString(array));
        if (hasDuplicate) {
            IO.println("\nAll'interno di questo array ci sono almeno due numeri uguali.");
        } else {
            IO.println("\nAll'interno di questo array non esistono numeri uguali.");
        }
        IO.println("\n\nIl numero più basso all'interno dell'array è: " + findMin(array) + "\nIl numero più alto all'interno dell'array è: " + findMax(array));
    }

    public static int findMin(int[] array) {
        int min=array[0];
        for (int i=1; i <array.length; i++) {
            if (array[i]<min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i=1; i<array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void populateArray(int[] array) {
            for(int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*10); // 0 = - 100 /// 200 = 100
        }

    }


    public static boolean hasDuplicated(int[] array) {
        for (int i=0; i< array.length-1; i++) {
                for (int j=i+1; j < array.length; j++) {
                if (array[i]==array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
