package org.generation.italy.examples.arrays.casa.riccardo;

// Scrivi una funzione che riceve in input un numero intero e ritorna il fattoriale di quel numero

public class Exercise5 {
    public static void main(String[] args){
        String numberStr = IO.readln("Inserisci un numero intero: ");
        int number = Integer.parseInt(numberStr);

        int factorial = returnFactorial(number);
        System.out.println("Il fattoriale del numero " + number + " è: " + factorial);
    }

    public static int returnFactorial(int num){
        int product = 1;

        for(int i = 1; i<num; i++){
            product = product * (num-i);
        }

        int fact = num*product;
        return fact;
    }
}
