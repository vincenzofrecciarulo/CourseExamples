package org.generation.italy.examples.oo.navalbattle;

import org.generation.italy.examples.oo.navalbattle.enums.BoatSize;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Boat> boats;
    private int smallBoatToDeploy = 4;
    private int mediumBoatToDeploy = 2;
    private int largeBoatToDeploy = 1;

    public Player (){
        boats = new ArrayList<>();
    }

    public void addBoat(Boat boat){
        boats.add(boat);
    }

    public void askToDeployBoat(){
        System.out.printf("""
                Navi da schierare:
                - %s nave/i piccole (lunghezza 1 - Code 1)
                - %s nave/i medie (lunghezza 2 - Code 2)
                - %s nave/i grandi (lunghezza 4 - Code 4)
                
                """, smallBoatToDeploy, mediumBoatToDeploy, largeBoatToDeploy);
    }

    public boolean isBoatAvailable(BoatSize boatSize){
        return switch (boatSize) {
            case SMALL -> smallBoatToDeploy >= 1;
            case MEDIUM -> mediumBoatToDeploy >= 1;
            case LARGE -> largeBoatToDeploy >= 1;
        };
    }

    public void reduceBoatToDeploy(BoatSize boatSize) throws Exception {
        switch (boatSize){
            case SMALL:
                smallBoatToDeploy--;
                break;
            case MEDIUM:
                mediumBoatToDeploy--;
                break;
            case LARGE:
                largeBoatToDeploy--;
                break;
            default:
                throw new Exception("Da aggiungere boatSize logica");
        }
    }

    public boolean areAllBoatsDeployed(){
        return smallBoatToDeploy + mediumBoatToDeploy + largeBoatToDeploy < 1;
    }


}
