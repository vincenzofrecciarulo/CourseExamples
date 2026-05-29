package org.generation.italy.examples.NewExercises;

import com.generation.library.Console;

public class Exercise004 {
    public static String AskYesNo() {

       String Risposta;
        do {
            System.out.println("Risposta con 'yes' oppure 'no'");
            Risposta = Console.readString();
        } while (!Risposta.equalsIgnoreCase("yes") && !Risposta.equalsIgnoreCase("no"));
        return Risposta;

    }
}
