package org.generation.italy.examples.Exercises;

public class ExerciseArray5 {
/*
Scrivi un metodo che riceve una matrice N×M e
restituisce la sua trasposta (una matrice M×N dove righe e colonne sono scambiate).
 */
    static void main() {
        int[][] matrix = new int[matrixSize()][matrixSize()];

        assignValues(matrix);
        printMatrix(matrix);
        transposed(matrix);
        printMatrix(transposed(matrix));
    }

    private static int matrixSize() {
        int number;
        number = (int)(Math.random()*5)+1;
        return number;
    }

    private static void assignValues(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[1].length; j++){
                matrix[i][j] = (int)(Math.random()*30)+1;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[1].length; j++){
                IO.print(matrix[i][j] + "       ");
            }
            IO.println();
        }
    }

    private static int[][] transposed(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[1].length; j++){
                matrix[i][j] = matrix[j][i];
            }
        }
        return matrix;
    }

}
