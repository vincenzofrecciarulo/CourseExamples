package org.generation.italy.examples.arrays.casa;
public class Ex1 {

        public static void main() {

            int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //abbiamo creato l'array di numeri

            System.out.println("Array iniziale:");
            printArray(array);//richiama la funzione in basso e stampa l'array iniziale

            reverseInPlace(array);

            System.out.println("Array invertito (in-place):");
            printArray(array);//richiama la funzione in basso e stampa l'array invertito
        }

        // inverte l'array in-place
        static void reverseInPlace(int[] array) { //creo la funzione per invertire i numeri
            for (int i = 0, j = array.length - 1; i < j; i++, j--) { //i va avanti e j va indietro
                int temp = array[i];//utilizzo la variabile temporale per fare un passagg
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // stampa l'array
        static void printArray(int[] array) { //creo questa funzione per stampare a video l'array
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " "); //questo significa che stamperà a video il mio array con uno spazio fra i numeri
            }
            System.out.println();
        }
    }
