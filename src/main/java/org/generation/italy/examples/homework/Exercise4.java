package org.generation.italy.examples.homework;

public class Exercise4 {
    /*
    4) Scrivi una funzione che richiede all utente di inserire la parola yes
     oppure no e continua a chiedere finche'l utente non inserisce una delle
      opzioni corrette. Dopodiche' ritorna la stringa al chiamante.
     */
    void main(){
        askYesOrNo();
    }

    static String askYesOrNo(){
        String input;
        do{
            IO.println("Inserisci 'yes' o 'no':");
            input = IO.readln();
        }while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

        return input;
    }

}
