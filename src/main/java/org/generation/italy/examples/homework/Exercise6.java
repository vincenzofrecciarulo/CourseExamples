package org.generation.italy.examples.homework;

public class Exercise6 {

    /*
    6) Scrivi una funzione che riceve in input un numero intero n e ritorna un array che contiene i primi n numeri della serie di Fibonacci
     */

    static int[] calculateFibonacci(int length) throws Exception {
        int[] fibonacci = new int[length];

        if(length < 2){
            throw new Exception();
        }
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for(int i = 2, beforeLast = 0, lastOne = 1; i < length; i++, beforeLast++, lastOne++ ){
            fibonacci[i] = fibonacci[beforeLast] + fibonacci[lastOne];

        }

        return fibonacci;

    }
}
