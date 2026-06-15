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

    public boolean placeShips(Ship ship, Direction direction, int row, int column){
        int dim = ship.getDimension();
        if (row < 0 || column < 0) return false;
        if (direction == Direction.VERTICAL){
            if (row + dim > table.length) return false;
            for (int i = 0; i < dim; i++){
                if (table[row+i][column] == Moves.SHIP) return false;
            }
            int[] rows = new int[dim];
            int[] cols = new int[dim];
            for (int i = 0; i < dim; i++){
                table[row + i][column] = Moves.SHIP;
                rows[i] = row + i;
                cols[i] = column;
            }
            ship.setRows(rows);
            ship.setColumns(cols);
            ship.setDirection(direction);
            return true;
        } else {
            if (column + dim > table[0].length) return false;
            for (int i = 0; i < dim; i++){
                if (table[row][column + i] == Moves.SHIP) return false;
            }
            int[] rows = new int[dim];
            int[] cols = new int[dim];
            for (int i = 0; i < dim; i++){
                table[row][column + i] = Moves.SHIP;
                rows[i] = row;
                cols[i] = column + i;
            }
            ship.setRows(rows);
            ship.setColumns(cols);
            ship.setDirection(direction);
            return true;
        }

        /*if (direction==Direction.VERTICAL) {
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
         */
    }
    public void printTable(){
        for (int r = 0; r < table.length; r++){
            for (int c = 0; c < table[r].length; c++) {
                System.out.print(table[r][c] == Moves.SHIP ? "S" : ". ");
            }
            System.out.println();
        }
    }
}
