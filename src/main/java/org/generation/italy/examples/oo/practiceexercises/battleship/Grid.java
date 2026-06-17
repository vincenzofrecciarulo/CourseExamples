package org.generation.italy.examples.oo.practiceexercises.battleship;

import java.util.Arrays;
import java.util.HashMap;

public class Grid {

    private final static int dim=10;
    private final static char ORIZONTAL='H';
    private final static char VERTICAL='V';
    private Character[][]battleCamp;


    public Grid() {
        this.battleCamp=new Character[dim][dim];
        createBattleCamp();
    }



    public void createBattleCamp() {
        for(int i=0;i< dim;i++){
            for(int j=0;j<dim;j++){
                battleCamp[i][j]='?';
            }
        }
    }

    public void printBattleCamp(){
        for(int i=0;i< dim;i++){
            for(int j=0;j<dim;j++){
                IO.print(battleCamp[i][j]+" ");
            }
            IO.println();
        }
    }

    public boolean chooseDirectionAndPlaceBoat(BoatTypes bt,char direction,char row,int col) {
        int r = row - 'A';
        boolean isNotValid=true;
        while (isNotValid) {
            switch (direction) {
                case 'V':
                    for (int i = 0; i < bt.getDimension(); i++) {
                        if (!isFreeCell(r + i, col))
                            return isNotValid;
                    }
                    for (int k = 0; k < bt.getDimension(); k++) {
                        battleCamp[r + k][col] = 'N';
                    }
                    break;
                case 'H':
                    for (int i = 0; i < bt.getDimension(); i++) {
                        if (!isFreeCell(r, col + i))
                            return isNotValid;
                    }
                    for (int j = 0; j < bt.getDimension(); j++) {
                        battleCamp[r][col + j] = 'N';
                    }
                    break;
                default:
                    IO.println("INPUT NOT VALID");
            }
            isNotValid=true;
            return isNotValid;
        }
    }

    public boolean isFreeCell(int rows,int column){
        if(rows<0||rows > dim||column<0||column > dim ){
            return false;
        }
        return battleCamp[rows][column]=='?';
    }






}
