package org.generation.italy.examples.chatgpt.exceptions;

public class Esercizio1 {
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println(numbers[2]);

        // System.out.println(numbers[10]); // ArrayIndexOutOfBoundsException
        // Ora riscriviamo questa parte in questo modo:
        try {
            System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indice non valido!");
        }

        System.out.println("Programma terminato");
    }
}
