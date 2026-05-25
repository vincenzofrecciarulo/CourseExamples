package org.generation.italy.examples.riccardoExercises;

import javax.xml.transform.Source;
import java.util.Arrays;

public class Exercise8 {
    static void main() {
        /*
        Scrivi una funzione che riceve in input due matrici bideminsionali e
        ritorna la matrice che rappresenta la somma delle matrici
         */
        int[][] matrix1 = new int[3][2];
        matrix1 = createIntMatrix(matrix1);

        int[][] matrix2 = new int[3][2];
        matrix2 = createIntMatrix(matrix2);

        int[][] sum = sumMatrix(matrix1,matrix2);


        printMatrix(matrix1);
        System.out.println();
        printMatrix(matrix2);
        System.out.println();
        printMatrix(sum);
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

    public static int[][] sumMatrix(int[][] m1,int[][] m2){
        int rows = m1.length;
        int columns = m1[0].length;
        int [][] sum = new int[rows][columns];

        for (int i =0;i<m1.length  ;i++){
            for(int j =0;j<m1[i].length;j++){
                sum[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return sum;
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }


}
