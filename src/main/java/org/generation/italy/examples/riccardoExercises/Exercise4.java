package org.generation.italy.examples.riccardoExercises;

import com.sun.security.jgss.GSSUtil;

public class Exercise4 {
    static void main() {
        /*
        Scrivi una funzione che richiede all utente di inserire la parola yes oppure no e continua
        a chiedere finche'l utente non inserisce una delle opzioni corrette.
        Dopodiche' ritorna la stringa al chiamante.*/

         String choice = chooseYesOrNo();
         System.out.println(choice);
    }
      public static String chooseYesOrNo (){
        String prompt = IO.readln("Digita yes o no ");

        while ((!(prompt.equals("yes"))) && (!(prompt.equals("no")))){
            prompt = IO.readln("Digita yes o no ");
        }

        return prompt;

     }

}

