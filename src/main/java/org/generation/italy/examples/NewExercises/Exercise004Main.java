package org.generation.italy.examples.NewExercises;

//4) Scrivi una funzione che richiede all utente di inserire la
// parola yes oppure no e continua a chiedere finche'l utente
// non inserisce una delle opzioni corrette. Dopodiche' ritorna
// la stringa al chiamante.

import com.generation.library.Console;

public class Exercise004Main {
    public static void main(String[] args) {
        String risultato = Exercise004.AskYesNo();
        System.out.println("Hai inserito: " + risultato);
    }
}
