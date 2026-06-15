package org.generation.italy.examples.battleship;

import java.util.Arrays;

public class BattleShip {
    final int ROW = 8;
    final int COL = 9;

    Moves[][] table = new Moves[ROW][COL];
    Ship[] ships = new Ship[5];

    public void initShips() {

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

    public void initialization() {
        for (Moves[] moves : table) {
            Arrays.fill(moves, Moves.WATER);
        }
    }

    public boolean placeShip(Ship ship, Orientation orientation, int x, int y) {
        int dim = ship.getSize();

        if (x < 0 || y < 0) {
            return false;
        }

        if (orientation == Orientation.VERTICAL) {
            if (x + dim > table.length) {
                return false;
            }

            //controlla se non si sovrappongono
            for (int i = 0; i < dim; i++) {
                if (table[x + i][y] == Moves.SHIP) {
                    return false;
                }
            }

            //posiziona e registra coordinate
            int[] rows = new int[dim];
            int[] col = new int[dim];

            for (int i = 0; i < dim; i++) {
                table[x + i][y] = Moves.SHIP;
                rows[i] = x + i;
                col[i] = y;
            }
            ship.setCoordinationX(rows);
            ship.setCoordinationY(col);
            ship.setOrientation(orientation);
            return true;
        } else { // HORIZONTAL
            if (y + dim > table[0].length) {
                return false;
            }

            for (int i = 0; i < dim; i++) {
                if (table[x][y + i] == Moves.SHIP) {
                    return false;
                }
            }

            int[] rows = new int[dim];
            int[] col = new int[dim];

            for (int i = 0; i < dim; i++) {
                table[x][y + i] = Moves.SHIP;
                rows[i] = x;
                col[i] = y + i;
            }
            ship.setCoordinationX(rows);
            ship.setCoordinationY(col);
            ship.setOrientation(orientation);
            return true;
        }
    }

    public boolean isSunk(Ship ship) {
        for (int i = 0; i < ship.getCoordinationX().length; i++) {
            int row = ship.getCoordinationX()[i];
            int col = ship.getCoordinationY()[i];
            if (table[row][col] != Moves.HIT) {
                return false;
            }
        }
        return true;
    }

    public void fire(int x, int y) {
        if (table[x][y] == Moves.SHIP) {
            table[x][y] = Moves.HIT;
            for (Ship ship : ships) {
                if (isSunk(ship)) {
                    for (int i = 0; i < ship.getCoordinationX().length; i++) {
                        table[ship.getCoordinationX()[i]][ship.getCoordinationY()[i]] = Moves.SUNK;
                    }
                }
            }
        } else if (table[x][y] == Moves.WATER) {
            table[x][y] = Moves.MISS;
        }
    }

    public void printTable() {
        for (Moves[] moves : table) {
            for (Moves move : moves) {
                System.out.print(move + " ");
            }
            System.out.println();
        }

    }
}
