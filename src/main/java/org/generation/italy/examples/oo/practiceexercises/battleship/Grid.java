package org.generation.italy.examples.oo.practiceexercises.battleship;

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

    public boolean placeBoat(Player p,BoatTypes bt, String direction, char row, int col) {
        int r = row - 'A';
        int c=col-1;
        boolean isValid=false;

            switch (direction.toUpperCase()) {
                case "V":
                    for (int i = 0; i < bt.getDimension(); i++) {
                        if ((r+i)>=dim||!isFreeCell(r + i, c)) {
                            IO.println("You cannot place it here!!");
                            return false;
                        }
                    }
                    for (int k = 0; k < bt.getDimension(); k++) {
                        battleCamp[r + k][c] = 'N';
                        }
                    IO.println("Boat placed successfully");
                    isValid=true;
                    break;
                case "H":
                    for (int i = 0; i < bt.getDimension(); i++) {
                        if ((c+i)>=dim||!isFreeCell(r , c + i)) {
                            IO.println("You cannot place it here!!");
                            return false;
                        }
                    }
                    for (int j = 0; j < bt.getDimension(); j++) {
                                battleCamp[r][c + j] = 'N';
                    }
                    IO.println("Boat placed successfully");
                    isValid=true;
                    break;
                default:
                    IO.println("INPUT NOT VALID");
                    isValid=false;
            }
        return isValid;
    }

    public boolean isFreeCell(int rows,int column){
        return battleCamp[rows][column]=='?';
    }






}
