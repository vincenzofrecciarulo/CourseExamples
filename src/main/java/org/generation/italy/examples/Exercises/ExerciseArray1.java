package org.generation.italy.examples.Exercises;

public class ExerciseArray1 {
    /*
    Crea una matrice 3×3 di interi e inizializzala con i valori da 1 a 9.
    Stampala a schermo in forma di griglia (3 righe, 3 colonne).
     */
    static void main() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j < matrix[1].length; j++){
                IO.print(matrix[i][j]);
            }
            IO.println();
        }
    }
}
