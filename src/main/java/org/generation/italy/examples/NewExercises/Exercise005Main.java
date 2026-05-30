package org.generation.italy.examples.NewExercises;

//5) Scrivi una funzione che riceve in input un numero
// intero e ritorna il fattoriale di quel numero

import com.generation.library.Console;

public class Exercise005Main {
    public static void main(String[] args) {

        System.out.println("Di quale numero vorresti fare il fattoriale?");
        int numero =Console.readInt();
        numero = Exercise005.Factorial(numero);

        System.out.println("Il fattoriale è: "+numero);


    }
}
