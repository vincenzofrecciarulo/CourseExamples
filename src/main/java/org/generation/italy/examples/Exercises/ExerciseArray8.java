package org.generation.italy.examples.Exercises;

import java.util.Arrays;

public class ExerciseArray8 {
/*
Scrivi un metodo che ruota una matrice quadrata N×N di 90 gradi in senso orario.
Stampa la matrice originale e quella ruotata.
 */
    static void main() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];

        printMatrix(matrix);
        IO.println();
        IO.println();
        rotatedMatrix = rotation(matrix);
        printMatrix(rotatedMatrix);

    }

    private static int[][] rotation(int[][] matrix) {
        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                rotatedMatrix[j][matrix.length - i - 1] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.printf("%-4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
