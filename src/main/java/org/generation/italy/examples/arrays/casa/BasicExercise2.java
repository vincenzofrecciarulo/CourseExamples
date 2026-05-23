package org.generation.italy.examples.arrays.casa;

public class BasicExercise2 {
    //2)Scrivi una main che crea due variabili intere e le passa a una funzione che riceve questi due valori e ritorna la loro somma.
    // La main stampera' il risultato

    public static void main(String[] args) {        //void esegue il programma e basta
        int x=3;                                    //creo le due variabili
        int y=5;

        int sum= result(x,y);                       //richiamo il metodo nella main
        System.out.println("Il risultato della somma è: "+ sum);    //stampo a video la somma(sum)
     }

    public static int result(int x, int y){ //il metodo è static perchè la main anche è static
        return x+y;

        //creo il metodo che calcola la somma che sarà di tipo int perchè mi ritorna un intero.

     }




    }



