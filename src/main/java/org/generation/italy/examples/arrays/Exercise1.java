package org.generation.italy.examples.arrays;
/*
Ex1
Dato un array di 10 elementi di qualunque tipo, invertire l’ordine degli elementi
 */
public class Exercise1 {
    static void main() {
        int[]  numArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] temp = new int[ numArray.length];

        for (int i = 0; i< numArray.length ; i++){
            temp[ numArray.length-1-i] =   numArray[i];
        }
        printArray(temp);
    }

    static void printArray(int [] array) {
        // enhanced for loop
        for (int x : array) {
            System.out.println(x);
        }
        // classic for loop
        /* for (int i = 0; i<a.length ; i++){
            System.out.println(a[i]);
        } */
    }

}
