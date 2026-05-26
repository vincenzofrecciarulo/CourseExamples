package org.generation.italy.examples.Exercises;

public class ExerciseArray2 {
    /*
    Data una matrice 4×4 riempita con valori a tua scelta, calcola e stampa la somma totale di tutti gli elementi.
     */
    static void main() {
        int[][] matrix = {{2, 6, 3, 2}, {1, 8, 0, 2}, {6, 5, 1, 8}, {0, 2, 5, 4}};
        int sum = 0;

        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j < matrix[1].length; j++){
                sum+= matrix[i][j];
            }
        }
        IO.println(sum);
    }
}
