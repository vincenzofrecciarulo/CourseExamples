package org.generation.italy.examples.arrays.casa.riccardo;

// Scrivi una main che crea due variabili intere e le passa a una funzione che
// riceve questi due valori e ritorna la loro somma. La main stampera' il risultato.

public class Exercise2 {
    public static void main(String[] args){

        String firstStr = IO.readln("Inserisci il primo numero intero: ");
        int firstNumber = Integer.parseInt(firstStr);

        String secondStr = IO.readln("Inserisci il secondo numero intero: ");
        int secondNumber = Integer.parseInt(secondStr);

        int result = printSum(firstNumber, secondNumber);
        System.out.println("La somma tra i due numeri è: " + result);
    }

    public static int printSum(int firstNum, int secondNum){
        int sum = firstNum + secondNum;
        return sum;
    }
}
