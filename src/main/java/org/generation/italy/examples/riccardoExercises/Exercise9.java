package org.generation.italy.examples.riccardoExercises;

import java.util.Arrays;

public class Exercise9 {
    static void main() {

        /*
        Scrivi una funzione che riceve in input due matrici bidimensionali e ritorna la matrice
        che e' loro prodotto. (sai come si calcola il prodotto tra matrici?)

         */

        int[][] matrix1 = new int[2][2];
        matrix1 = createIntMatrix(matrix1);

        int[][] matrix2 = new int[2][2];
        matrix2 = createIntMatrix(matrix2);

        printMatrix(matrix1);
        System.out.println();
        printMatrix(matrix2);
        System.out.println();
    }

    public static int[][] createIntMatrix (int[][]numbers){
        int rows = numbers.length;
        int columns = numbers[0].length;

        int [][] matrix = new int[rows][columns];
        for (int i = 0; i<matrix.length;i++){
            for (int j =0; j<matrix[i].length;j++)
                matrix[i][j] = (int)((Math.random()*10)+1);
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static int[][] productMatrix (int[][] m1,int[][]m2){
        int rows = m1.length;
        int columns = m1[0].length;
        int columnsM2 = m2[0].length;

        int [][] product = new int[rows][columnsM2];

        for (int i = 0; i<m1.length;i++){
            for (int j= 0; j<columnsM2;j++){
                for (int k = 0; k<m1[0].length;k++){
                       
                }

            }
        }

         return product;
    }

}
