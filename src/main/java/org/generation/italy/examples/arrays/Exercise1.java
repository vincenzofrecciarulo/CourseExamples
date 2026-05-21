package org.generation.italy.examples.arrays;

public class Exercise1 {
    // dato un array di 10 elementi, di qualunque tipo, invertire l'ordine degli elementi
    void main() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // il modo più semplice per farlo è creare un altro array e copiarci gli elementi
        // al contrario, poi ricopiare il nuovo array nel primo.
        // in questo caso non è necessario, teniamoci l'array temporaneo.

        // inizializziamo l'array temp. in questo modo si riempie di 0
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            temp[arr.length - 1 - i] = arr[i];
        }
        System.out.println(temp); // this prints the memory address pointing to the array, not the array
        printArray(temp);
    }

    static void printArray(int[] a){   // this is what Array.toString() does
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
        /*
        we could write this with a for-each.
        this way, the variable j itself gets filled
        with the contents of the array, but
        we won't have a counter,
        which we may need depending on the case.

        for (int j : a) {
            System.out.println(j);
        }
        */
    }
}
