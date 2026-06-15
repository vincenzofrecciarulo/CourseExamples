package org.generation.italy.examples.oo.practiceexercises.battleship;

import java.util.HashMap;

public class Grid {

    private final static int dim=10;
    private char[][]battleCamp;


    public Grid() {
        this.battleCamp=new char[dim][dim];
    }
    public void createBattleCamp(){
        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                battleCamp [i][j]='b';
            }
        }
    }

    public void addBoatToGrid(BoatTypes bt, Coordinate c, String inputO) {
        if (inputO.equals("v")){
            for(int i=0;i<bt.getDimension();i++){
                battleCamp [c.getRow() + i][c.getColumn()] ='n';



            }

        }

    }
}
