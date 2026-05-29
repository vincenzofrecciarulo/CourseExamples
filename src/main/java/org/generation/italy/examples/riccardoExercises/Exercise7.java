package org.generation.italy.examples.riccardoExercises;

import com.generation.library.Console;

import java.util.Arrays;

public class Exercise7 {
    static void main() {
        /*
        Scrivi una funzione che riceve in input un numero n e ritorna un vettore bidimensionale (matrice) n x n in cui
        tutti i valori sono zero tranne quelli sulla diagonale
      */
        System.out.println("Inserisci grandezza matrice ");
        int size = Console.readInt();
        int[][] diagonal =  buildDiagonalMatrix(size);

        printMatrix(diagonal);
    }
    public static int[][] buildDiagonalMatrix(int n){
        int numbers[][] = new int[n][n];

        for (int i =0; i<numbers.length;i++){
            for(int j =0;j<numbers[i].length;j++){
                if(i==j){
                    numbers[i][j]=1;
                }

            }
        }
       return numbers;

    }

   public static void printMatrix(int[][] matrix){
        for (int i = 0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
   }

}
