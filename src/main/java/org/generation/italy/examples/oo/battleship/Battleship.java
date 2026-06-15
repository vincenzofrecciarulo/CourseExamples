package org.generation.italy.examples.oo.battleship;

import java.util.Arrays;

public class Battleship {
        final int ROW = 8;
        final int COL = 9;

        Moves[][] table = new Moves[ROW][COL];
        Ship[] ships = new Ship[5];

    public void initShips(){

        Ship ship1 = new Ship(2);
        Ship ship2 = new Ship(3);
        Ship ship3 = new Ship(3);
        Ship ship4 = new Ship(4);
        Ship ship5 = new Ship(5);

        ships[0] = ship1;
        ships[1] = ship2;
        ships[2] = ship3;
        ships[3] = ship4;
        ships[4] = ship5;

    }

    public void initialization(){
        for (Moves[] moves : table) {
            Arrays.fill(moves, Moves.WATER);
        }
    }

    public void placeShip(Ship ship, Orientation orientation, int x, int y){
        if(orientation == Orientation.HORIZONTAL){
            for(int i = 0; i < ship.getSize(); i++){
                if(table[x][y + i] == Moves.SHIP){
                    return;
                }
                    table[x][y + i] = Moves.SHIP;
            }
        } else{
            for (int i = 0; i < ship.getSize(); i++){
                if(table[x + i][y] == Moves.SHIP){
                    return;
                }
                table[x + i][y] = Moves.SHIP;
            }

        }
    }

    public void printTable(){
        for (Moves[] moves : table) {
            for (Moves move : moves) {
                System.out.print(move + " ");
            }
            System.out.println();
        }
    }

}
