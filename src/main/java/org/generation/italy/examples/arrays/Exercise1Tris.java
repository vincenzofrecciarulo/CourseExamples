package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*
Ex1Tris (solitaria)
Dato un array di 10 elementi di qualunque tipo,
scrivere una funzione che prenda un array di quel tipo e lo restituisca con gli elementi in ordine inverso
senza utilizzare un array temporaneo (termine tecnico: in-place, cioè gli elementi rimangono sempre all’interno dell’array)

 */
public class Exercise1Tris {
    static void main() {
        int[] numbers = {1,2,3,4,5,6,7,8};
        IO.println(Arrays.toString(numbers));
        reverseArray(numbers);
    }
    public static void reverseArray(int[] arr){
        // Qua prendiamo 2 indici opposti che si vengono incontro
        // proseguirà finché i e minore di j
        for (int i = 0, j = arr.length -1; i < j; i++ , j--){
            swapNumbersInArray(arr, i,j);
        }
        IO.println(Arrays.toString(arr));
    }

    private static void swapNumbersInArray(int[] arr, int i,int j) {
        // qui scambiamo i valori presenti nell'indice correnti grazie a una variabile di appoggio
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
