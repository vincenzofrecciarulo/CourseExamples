package org.generation.italy.examples.arrays.casa;

public class BasicExercise4 {

    //Scrivi una funzione che richiede all utente di inserire la parola yes oppure no e
    // continua a chiedere finche'l utente non inserisce una delle opzioni corrette. Dopodiche' ritorna la stringa al chiamante.


    public static void main(String[] args){

        String answer1= "yes";  //dichiaro la variabile di tipo Stringa "yes"
        String answer2="no";   //dichiaro la variabile di tipo Stringa  "no"

        String finalAnswer= returnAnswer(answer1,answer2);     //richiamo il metodo nella main(chiamante)
        System.out.println("La risposta è: " + finalAnswer );  //stampo a video la risposta inserita correttamente
                                                               //che può essere "yes" oppure "no" altrimenti ricomincerà il ciclo.

    }

    static String returnAnswer(String s1,String s2){ //creo la funzione String che richiamerò nel main
        String answer;                               //dichiaro la variabile answer
        do {
            System.out.println("Inserisci yes or no: "); //utilizzo il ciclo dowhile per verificare se la parola inserita è "yes"
                                                         //oppure "no"
             answer=IO.readln();                         //salvo la risposta nella variabile answer

        }while(!answer.equals(s1) && !answer.equals(s2));  //finchè answer non(!) sarà uguale a "yes" e non(!) sarà uguale a "no"
                                                           //continua il ciclo.

        return answer;                                     //ritornerà la risposta corretta "yes" or "no".


    }


}
