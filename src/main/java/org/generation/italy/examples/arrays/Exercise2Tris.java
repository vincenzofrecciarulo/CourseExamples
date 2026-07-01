package org.generation.italy.examples.arrays;
import java.util.Arrays;

import static org.generation.italy.examples.arrays.Exercise2.*;

/*
* Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali
* di valore 1-10. Successivamente il programma deve stampare gli elementi duplicati
* */
public class Exercise2Tris {
    static void main(String[] args) {
        int[] numbers=new int[10];
        populateArray(numbers);
        System.out.println("L'ARRAY GENETRATO E': ");
        System.out.println(Arrays.toString(numbers));
        int[] duplicates= rollCall(numbers);
        System.out.println("DUPLICATI TROVATI: ");
        for(int i=0;i<duplicates.length;i++){
            if(duplicates[i]>1){
                System.out.print(i+1);
                System.out.println(" trovato "+duplicates[i]+" volte");
            }
        }

    }
    public static int[] rollCall(int[] numbers) {
        int[] attendance = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            attendance[numbers[i]-1]++;
        }
        return attendance;
    }

}
