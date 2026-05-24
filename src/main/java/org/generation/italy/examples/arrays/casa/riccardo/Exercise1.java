package org.generation.italy.examples.arrays.casa.riccardo;

// Scrivi una funzione main che crea due variabili intere.
// Poi crea una che rappresenta la somma delle due variabili intere e stampa il risultato.

public class Exercise1 {
    public static void main(String[] args){
        String firstNumberStr = IO.readln("Inserisci il primo numero intero: ");
        int firstNumber = Integer.parseInt(firstNumberStr);

        String secondNumberStr = IO.readln("Inserisci il secondo numero intero: ");
        int secondNumber = Integer.parseInt(secondNumberStr);

        sumAndPrint(firstNumber,secondNumber);
    }

    public static void sumAndPrint(int firstNum, int secondNum){
        int sum = firstNum + secondNum;
        System.out.println("Il risultato della somma è: " + sum);
    }
}