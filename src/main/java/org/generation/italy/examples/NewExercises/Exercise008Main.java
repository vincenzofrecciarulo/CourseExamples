package org.generation.italy.examples.NewExercises;

import com.generation.library.Console;

public class Exercise008Main {
    public static void main (String[] args) {

         int[][] Matrice01 = {
                {5, 12},
                {3, 1},
                {42, 24},
                {5, 85},
                {8, 21},
                {44, 4},
                {2, 28},
                {9, 9},
                {55, 2},
                {7, 31},
        };

         int[][] Matrice02 = {
                {1, 4},
                {23, 71},
                {13, 62},
                {66, 1},
                {23, 24},
                {8, 28},
                {31, 30},
                {5, 33},
                {1, 2},
                {7, 25},
        };

         int[][] risultato = Exercise008.sommaMatrici(Matrice01, Matrice02);

        for (int i = 0; i < risultato.length; i++) {
            System.out.println(risultato[i][0] + ", " + risultato[i][1]);
        }
    }
}
