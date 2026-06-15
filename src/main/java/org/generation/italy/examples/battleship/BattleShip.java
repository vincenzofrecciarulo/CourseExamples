package org.generation.italy.examples.battleship;

import java.util.Arrays;
import java.util.Random;

public class BattleShip {

    Moves[][] table = new Moves[9][9];

    Ship[] ships = new Ship[5];

    public void setUpShip(){
        Ship portaAerei = new Ship(5);
        Ship corazzata = new Ship(4);
        Ship incrociatori = new Ship(3);
        Ship submarine = new Ship(2);
        Ship yellowSubmarine = new Ship(2);

        ships[0] = portaAerei;
        ships[1] = corazzata;
        ships[2] = incrociatori;
        ships[3] = submarine;
        ships[4] = yellowSubmarine;
    }

    public void initialSetUpTable(){
        for (Moves[] table:table){
            Arrays.fill(table,Moves.WATER);
        }
    }

    public void placeShips(Ship ship, Direction direction, int row, int column){
        if (direction==Direction.VERTICAL) {
            for (int i=0; i<ship.getDimension() ; i++ ) {
                if(table[row+i][column]==Moves.SHIP){
                    return;
                }
                table[row+i][column]=Moves.SHIP;
            }
        } else {
            for (int i=0; i<ship.getDimension(); i++) {
                if(table[row][column+i]==Moves.SHIP){
                    return;
                }
                table[row][column+1]=Moves.SHIP;
            }
        }
    }
}
