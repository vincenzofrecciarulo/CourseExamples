package org.generation.italy.examples.oo.battleship;

public class Battleship {
    final int ROW = 8;
    final int COL = 9;

    Moves[][] table = new Moves[ROW][COL];
    Ship[] ships = new Ship[5];

    Ship ship1 = new Ship(2);
    Ship ship2 = new Ship(3);
    Ship ship3 = new Ship(3);
    Ship ship4 = new Ship(4);
    Ship ship5 = new Ship(5);



    public void initialization(){
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                table[i][j] = Moves.WATER;
            }
        }
    }
}
