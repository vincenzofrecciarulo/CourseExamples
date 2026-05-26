package org.generation.italy.examples.Exercises;

import java.util.Arrays;

public class ExerciseArray6 {
/*
Data una matrice 3×3 e un vettore (array monodimensionale) di 3 elementi,
calcola il prodotto matrice-vettore e stampa il vettore risultante.
 */
    static void main() {
        //dichiaro una matrice 3x3
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        //dichiaro un vettore monodimensionale
        int[] vector = {1, 2, 3};
        //dichiaro la matrice prodotto
        int[] matrixProduct = new int[matrix.length];
        //calcolo la matrice prodotto
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j < vector.length; j++){
               int product = matrix[i][j] * vector[j];
               matrixProduct[i] += product;
            }
        }
        //stampo il vettore prodotto
        IO.println(Arrays.toString(matrixProduct));
    }
}
