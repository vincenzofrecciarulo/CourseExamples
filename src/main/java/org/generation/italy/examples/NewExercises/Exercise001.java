package org.generation.italy.examples.NewExercises;

//1)Scrivi una funzione main che crea due variabili intere ,
// poi una che rappresenta la somma delle due e stampa il risultato.

public class Exercise001 {
    public static int[][] somme = new int[][] {
            {1, 1},
            {2, 2},
            {3, 3},
            {4, 4},
            {5, 5},
            {6, 6},
            {7, 7},
    };
    public static void main (String[] args) {
        for (int i = 0; i < somme.length; i++) {
            int st = somme[i][0];
            int nd = somme[i][1];
            int tot = st+nd;
            System.out.println(st + " + " + nd + " = " + tot);
        }
    }
}
