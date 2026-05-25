package org.generation.italy.examples.arrays.casa;

import com.generation.library.*;

public class BasicExercise3 {
    //Scrivi una funzione che riceve in input due stringhe e un carattere
    // e ritorna true se la prima stringa contiene quel carattere un numero di volte superiore alla seconda


    public static void main(String[] args) {

        System.out.println("Inserisci una stringa: "); //input per inserire la  stringa
        String s1 = Console.readString();

        System.out.println("Inserisci un'altra stringa: "); //input per inserire la stringa
        String s2 = Console.readString();

        System.out.println("Inserisci un carattere: ");    //input per inserire il  carattere
        char c1 = Console.readString().charAt(0);          //così prende il primo carattere della stringa

        // char è il tipo di variabile per indicare un singolo carattere. es "a".

        boolean result = containsMoreTimes(s1,s2,c1);          //richiamo la funzione nel main
        System.out.println("Il risultato è: " + result);       //stampo il risultato a video

    }

    public static boolean containsMoreTimes(String s1, String s2, char c1) {

        int counter1 = 0;                                 //dichiaro il contatore per la stringa 1 (s1)

        // per il ciclo for: parto dalla posizione 0 (la prima lettera)
        //i < s1.length()continuo finché non arrivo alla fine della stringa
        //i++ad ogni giro vado alla lettera successiva

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == c1) {
                counter1++;

                //Ad ogni giro del ciclo:
                //s1.charAt(i) → prende la lettera alla posizione i
                // == c1 -> la confronta con il carattere cercato
                //Se sono uguali -> counter1++ incrementa il contatore di 1
            }

        }

        int counter2 = 0;                                     //dichiaro il contatore per la stringa 2 (s2)

        //per il ciclo for: parto dalla posizione 0 (la prima lettera)
        //i < s1.length()continuo finché non arrivo alla fine della stringa
        //i++ad ogni giro vado alla lettera successiva

        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == c1) {
                counter2++;

                //Ad ogni giro del ciclo:
                //s2.charAt(i) → prende la lettera alla posizione i
                // == c1 -> la confronta con il carattere cercato
                //Se sono uguali -> counter2++ incrementa il contatore di 1
            }
        }
        boolean charMoreTimes = false;                        //creo la variabile di tipo booleana per restituire true o false

        if (counter1 > counter2) {
            charMoreTimes = true;                             //se il contatore per la s1 ha trovato piu' volte (e quindi è maggiore) il carattere
            // rispetto al contatore per la s2
        } else {
            charMoreTimes = false;
        }                                                //la mia booleana sarà true altrimenti false.

        return charMoreTimes;


    }
}


