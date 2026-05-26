package org.generation.italy.examples.Exercises;

public class ExerciseArray5 {
/*
Scrivi un metodo che riceve una matrice N×M e
restituisce la sua trasposta (una matrice M×N dove righe e colonne sono scambiate).
 */
    static void main() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("Matrice originale (2x3): ");
        printMatrix(matrix);

        int[][] result = transposed(matrix);

        System.out.println("Matrice trasposta (3x2):");
        printMatrix(result);
    }

    private static int[][] transposed(int[][] matrix) {
        int rows = matrix.length;                //righe della matrice originali
        int columns = matrix[0].length;          //colonne della riga originale

        int [][] transposedMatrix = new int[columns][rows];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
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
