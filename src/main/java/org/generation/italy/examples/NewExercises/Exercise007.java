package org.generation.italy.examples.NewExercises;

//7) Scrivi una funzione che riceve in input un numero
// n e ritorna un vettore bidimensionale (matrice) n x n
// in cui tutti i valori sono zero tranne quelli sulla diagonale

public class Exercise007 {
    public static int[][] creaMatrice(int n) {
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            m[i][i] = 1;
        }
        return m;
    }
}
