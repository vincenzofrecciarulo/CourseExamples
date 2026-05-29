package org.generation.italy.examples.riccardoExercises;
import  com.generation.library.Console;

import java.util.Arrays;

public class Exercise6 {
    static void main() {
        /*
        Scrivi una funzione che riceve in input un numero intero n e ritorna un array che contiene i primi n numeri
         della serie di Fibonacci.*/

        System.out.println("Inserisci ennesimo numero di Fibonacci ");
        int n = Console.readInt();

        long[] fibonacci = returnFibonacci(n);
        System.out.println(Arrays.toString(fibonacci));

    }
    public static long[] returnFibonacci (int n){
        long[] fibonacci = new long[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2 ; i<fibonacci.length;i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return fibonacci;
    }

}
