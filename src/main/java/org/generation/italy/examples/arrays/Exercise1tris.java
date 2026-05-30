package org.generation.italy.examples.arrays;

public class Exercise1tris {
    static void main() {
        int[] numbers = {0,1,2,3,4,5,6,7,8,9}; //array di numeri
        //int[] temp = new int[numbers.length]; //array temporale lunghezza numeri

        for (int i = 0; i < numbers.length / 2; i++) {
         int temp = numbers[i];
            numbers [i] = numbers[numbers.length-i-1];
            numbers[numbers.length - 1 - i] = temp;
          //  temp[numbers.length - i-1] = numbers[i];

        }


       // System.out.println("\nL'indirizzo dell'array temporaneo è: \n" + temp + "\nL'indirizzo dell'array originale è: \n" + numbers);
       // System.out.println("\nEcco il risultato dell'esercizio:");
        printArray(numbers);
    }

    static void printArray(int[] pippo) {
        for (int x : pippo) {
           System.out.println(x);

        }
    }
}