package org.generation.italy.examples.arrays.casa.riccardo;

// Scrivi una funzione che richiede all'utente di inserire la parola yes oppure no
// e continua a chiedere finche' l'utente non inserisce una delle opzioni corrette.
// Dopodiche' ritorna la stringa al chiamante.

public class Exercise4 {
    public static void main(String[] args){
        String answer = askOptions();
        System.out.println("Hai scelto correttamente una delle due parole ed hai inserito la risposta: " + answer);
    }

    public static String askOptions (){
        String option;

        do{
            option = IO.readln("Inserisci la parola 'yes' oppure 'no': ");
        }while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"));

        return option;
    }
}