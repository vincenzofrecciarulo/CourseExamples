package org.generation.italy.examples.battaglianavale;
//ogni player ha due griglie per vedere colpiti/affondati
//ogni player una portaerei che ha 5 caselle, una corazzata occupa 4, un incrociatore 3, sommergibile 3, un cacciatore 2 (17 caselle)
//griglia 10x10

import java.util.Arrays;

public class Board {
    private static final int SIZE = 10;
    private final CellState[][] grid;

    public Board() {
        this.grid = new CellState[SIZE][SIZE];
        Arrays.stream(grid).forEach(row -> Arrays.fill(row, CellState.EMPTY));
    }

    public CellState fireAt(int row,int col) {
        CellState current = grid[row][col];
                if(current == CellState.HIT||current == CellState.MISS){
                    return CellState.ALREADY_HIT;
                }
                if (current==CellState.SHIP) {
                    grid[row][col]=CellState.HIT;
                    return CellState.HIT;
                } else if (current==CellState.EMPTY) {
                    grid[row][col]=CellState.MISS;
                    return CellState.MISS;
                }
                return current;
    }



    public void printBoard(boolean hideShips) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                CellState cell = grid[i][j];

                if (hideShips && cell == CellState.SHIP) {
                    cell = CellState.EMPTY;
                }

                System.out.print(cell.getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public boolean placeShips(Ship ship, int startRow, int startCol, boolean isHorizontal) {
        int shipSize = ship.getSize();
        //Controllo se le navi escono fuori dalla board
        if (isHorizontal){
            if (startCol + shipSize > SIZE) return false;
        }
        else {
            if (startRow + shipSize > SIZE) return false;
        }
        //Controllo se le navi si sovrappongono durante l'inserimento
        for (int i = 0; i < shipSize; i++) {
            int currentRow = isHorizontal ? startRow : startRow + i;
            int currentCol = isHorizontal ? startCol + i : startCol;

            if (grid[currentRow][currentCol] == CellState.SHIP) {
                return false;
            }
        }

        // 3. Posizionamento effettivo
        for (int i = 0; i < shipSize; i++) {
            int currentRow = isHorizontal ? startRow : startRow + i;
            int currentCol = isHorizontal ? startCol + i : startCol;

            grid[currentRow][currentCol] = CellState.SHIP;
        }

        return true;
    }

}