package org.generation.italy.examples.Exercises;

public class ExerciseArray4 {
/*
Data una matrice 3×3, calcola e stampa la somma di ciascuna riga e la somma di ciascuna colonna separatamente.
 */
    static void main() {
        int[][] matrix = new int[3][3];
        int sumColumn = 0;
        int sumRow = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[1].length; j++){
                matrix[i][j] = (int)(Math.random()*100)+1;
                IO.print(matrix[i][j] + "       ");
            }
            IO.println();
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[1].length; j++){
                sumRow += matrix[i][j];
            }
            IO.println("La somma della riga " + i + " é: " + sumRow);
            sumRow = 0;
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[1].length; j++){
                sumColumn += matrix[j][i];
            }
            IO.println("La somma della colonna " + i + " é: " + sumColumn);
            sumColumn = 0;
        }
    }
}
