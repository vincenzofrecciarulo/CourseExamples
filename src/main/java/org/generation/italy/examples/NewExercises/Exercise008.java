package org.generation.italy.examples.NewExercises;

//8) Scrivi una funzione che riceve in input due matrici bideminsionali e
// ritorna la matrice che rappresenta la somma delle matrici

    public class Exercise008 {
        public static int[][] sommaMatrici(int[][] mat1, int[][] mat2) {
            int righe = mat1.length;
            int colonne = mat1[0].length;
            int[][] risultato = new int[righe][colonne];

            for (int i = 0; i < righe; i++) {
                for (int j = 0; j < colonne; j++) {
                    risultato[i][j] = mat1[i][j] + mat2[i][j];
                }
            }
            return risultato;
        }
    }

