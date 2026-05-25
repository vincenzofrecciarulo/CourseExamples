package org.generation.italy.examples.NewExercises;

//3)Scrivi una funziona che riceve in input due stringhe
// e un carattere, e ritorna true se la prima stringa contiene
// quel carattere un numero di volte superiore alla seconda


//fare boolean, true se compare piu volte stringa0 che stringa1,
//false se compare meno volte.
//creare 2array di stringe(bidimensionale), comparare il carattere
//dove compare piu volte

import com.generation.library.Console;

public class Exercise003Main {
    public static void main(String[] args) {
        System.out.println("Qual'è la tua prima parola?");
        String Parola1 = Console.readString();
        System.out.println("Qual'è la tua seconda parola?");
        String Parola2 = Console.readString();
        System.out.println("Quale carattere vuoi controllare?");
        char carattere = Console.readString().charAt(0);

        boolean risultato = Exercise003.compare(Parola1, Parola2, carattere);
        System.out.println(risultato);

    }
}
