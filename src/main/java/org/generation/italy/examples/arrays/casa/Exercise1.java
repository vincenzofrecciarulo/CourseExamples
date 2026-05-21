package org.generation.italy.examples.arrays.casa;

// Stampa gli indirizzi dei vettori

// Ex1:
// Dato un array di 10 elementi di qualunque tipo, invertire l’ordine degli elementi e stampare l'array inverso

// Ex1Bis:
// Dato un array di 10 elementi di qualunque tipo, scrivere una funzione che prenda un array di quel tipo e lo restituisca con gli elementi in ordine inverso

// Ex1Tris:
// Dato un array di 10 elementi di qualunque tipo, scrivere una funzione che prenda un array di quel tipo e lo restituisca con gli elementi in ordine inverso senza utilizzare un array temporaneo (termine tecnico: in-place, cioè gli elementi rimangono sempre all’interno dell’array)

public class Exercise1 {

    public static void main(String[] args){

        int[] array1 = {1,2,3,4,5,6,7,8,9,10};
        int[] array2 = new int[array1.length];

        System.out.println("Questo è l'indirizzo del primo array: ");
        System.out.println(array1);
        System.out.println("Questo è l'indirizzo del secondo array: ");
        System.out.println(array2); // qui praticamente stiamo stampando l'indirizzo di array2 ma noi non vogliamo ottenere ciò

        System.out.println("\n");
        System.out.println("Questo è l'Ex.1!");
        for(int i=0; i<array1.length; i++){
            array2[array1.length-1-i] = array1[i];
        }
        System.out.println("L'array iniziale è: ");
        printArray(array1);
        System.out.println("L'array finale (invertito) è: ");
        printArray(array2);

        System.out.println("\n");
        System.out.println("Questo è l'Ex.1bis!");
        System.out.println("L'array iniziale è: ");
        printArray(array1);
        System.out.println("L'array invertito e messo in un secondo array è: ");
        int[] array3 = {1,2,3,4,5,6,7,8,9,10}; // che sarebbe come l'array1
        reverseInPlace(array3);
        printArray(array3);

        System.out.println("\n");
        System.out.println("Questo è l'Ex.tris (in-place)!");
        System.out.println("L'array iniziale è: ");
        int[] array4 = {1,2,3,4,5,6,7,8,9,10}; // che sarebbe come array1
        printArray(array4);
        System.out.println("L'array invertito e messo in un secondo array è: ");
        int[] invertito = reverse(array4);
        printArray(invertito);
    }

    // EX.1BIS
    static void reverseInPlace(int[] array){
        for(int i = 0; i < array.length / 2; i++){
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }


    // EX1TRIS → in-place
    static int[] reverse(int[] array){

        int[] nuovo = new int[array.length];

        for(int i = 0; i < array.length; i++){
            nuovo[array.length-1-i] = array[i];
        }

        return nuovo;
    }


    // funzione che stampa gli array
    static void printArray(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }
}