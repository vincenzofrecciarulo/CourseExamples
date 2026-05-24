package org.generation.italy.examples.arrays.casa.riccardo;

// Scrivi una funzione che riceve in input un numero intero n
// e ritorna un array che contiene i primi n numeri della serie di Fibonacci

public class Exercise6 {
    public static void main(String[] args){
        int number;

        do{
            String numberStr = IO.readln("Inserisci un numero intero maggiore o uguale a 1: ");
            number = Integer.parseInt(numberStr);
            if (number < 1) {
                System.out.println("Reinserisci di nuovo il numero.");
                System.out.println("\n");
            }
        }while(number < 1);

        System.out.println("Questo numero rappresenterà la quantità di numeri presenti nella serie di Fibonacci!");
        System.out.println("\n");
        System.out.println("La serie di Fibonacci è: ");
        int[] serieFib = returnFibonacci(number);
        for (int i = 0; i < serieFib.length; i++) {
                System.out.print(serieFib[i] + " ");
        }

    }

    public static int[] returnFibonacci(int num) {

        int[] sumArrayFib = new int[num];

        if (num == 1) {
            sumArrayFib[0] = 0;
            return sumArrayFib;
        } else {
            sumArrayFib[0] = 0;
            sumArrayFib[1] = 1;

            for (int i = 2; i < num; i++) {
                sumArrayFib[i] = sumArrayFib[i - 1] + sumArrayFib[i - 2];
            }

            return sumArrayFib;
        }
    }
}
