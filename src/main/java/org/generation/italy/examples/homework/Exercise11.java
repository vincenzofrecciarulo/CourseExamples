package org.generation.italy.examples.homework;

import java.util.Arrays;

public class Exercise11 {
    /*
    11) Crea una semplice implementazione di gioco di battaglia navale in cui il giocatore gioca contro il computer.
     */

    static void playNavalBattle(){
        int[][] playerBoard = new int[9][9];
        int[][] cpuBoard = new int[9][9];

        final int oneTileShip = 5;
        final int twoTileShip = 3;
        final int threeTileShip = 2;
        final int fourTileShip = 1;

        IO.println("=========================");
        IO.println("Benvenuti a battaglia navale");
        IO.println("=========================");


    }

    static void printBoard(String[][] trisMatrix){
        for (String[] matrix : trisMatrix) {
            IO.println(Arrays.toString(matrix));
        }
    }

    static boolean tryInsertShip(int[][] shipBoard, Direction direction, int shipLength){
        return true;
    }

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}
