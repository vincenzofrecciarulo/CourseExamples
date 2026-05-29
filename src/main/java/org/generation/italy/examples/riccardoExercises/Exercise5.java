package org.generation.italy.examples.riccardoExercises;

public class Exercise5 {

    static void main() {
        /*
         Scrivi una funzione che riceve in input un numero intero e ritorna il fattoriale di quel numero.
         */
        long factorial = calculateFactorial(5);
        System.out.println("factorial= " +factorial);

    }
    public static long calculateFactorial(int n){
        long factorial = 1L;
        for (int i =n; i>1;i--){
            factorial *=i;

        }
        return factorial;
    }
}
