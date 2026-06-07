package org.generation.italy.examplesMio.arraysMio;
/* dato un array di 10 elementi di qualsiasi tipo, invertire l'ordine degli elementi*/
// Dato un array di 10 elementi di qualunque tipo, scrivere una funzione che prenda un array di quel tipo e lo restituisca con gli elementi in ordine inverso
// Dato un array di 10 elementi di qualunque tipo, scrivere una funzione che prenda un array di quel tipo e lo restituisca con gli elementi in ordine inverso senza utilizzare un array temporaneo (termine tecnico: in-place, cioè gli elementi rimangono sempre all’interno dell’array)

import java.util.Arrays;

public class Exercise1 {
    static void main() {
        int[]  numArray = {1,2,3,4};


      /*  for (int i = 0; i< numArray.length ; i++){
            temp[ numArray.length-1-i] =   numArray[i];
        }*/

        int[] temp = swap(numArray);

        invert(numArray);
        IO.println(Arrays.toString(numArray));

        // printArray(temp, true);

    }

    private static void invert(int[] numArray) {
        for(int i = 0, j = numArray.length - 1; i < j; i++, j--){
            reverse(numArray, i , j);
        }
    }

    public static void reverse(int[] numArray, int i , int j){
        int temp = numArray[i];

        numArray[i] = numArray[j];
        numArray[j] = temp;
    }
    public static int[] swap(int [] array){
        int[] tempArray = new int[array.length];

        for(int i = 0; i < array.length; i++){
           tempArray[array.length - 1 - i] = array[i];

        }
        return tempArray;
    }

    static void printArray(int [] array, boolean visual) {

        if(visual){
            System.out.println(Arrays.toString(array));
        } else {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }

}
