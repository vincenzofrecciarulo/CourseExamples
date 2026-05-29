package org.generation.italy.examples.NewExercises;

import com.generation.library.Console;

public class Exercise007Main {
    public static void main(String []args) {

        System.out.println("SCEGLI LA GRANDEZZA QUADRATA DELLA MATRICE!");
        System.out.println();
        int n = Console.readInt();

        int[][] matrice = Exercise007.creaMatrice(n);

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
    }
}
