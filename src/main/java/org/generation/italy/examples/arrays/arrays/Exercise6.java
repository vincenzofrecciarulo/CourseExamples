//Scrivere una funzione che popola un array con
// numeri interi casuali di valore 1-10
package org.generation.italy.examples.arrays.arrays;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Quanti numeri vuoi inserire nell'array?");
        int n = input.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Inserisci il numero " + (i + 1) + ":");
            array[i] = input.nextInt();
        }

        System.out.println("Numeri inseriti:");

        for (int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }
    }
}