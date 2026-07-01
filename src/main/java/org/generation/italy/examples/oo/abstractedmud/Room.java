package org.generation.italy.examples.oo.abstractedmud;

import org.generation.italy.examples.oo.abstractedmud.entities.Entity;

import java.util.List;

public class Room {
    private String roomName,description;
    private List<Entity> population;
    private Room north,south,east,west;

    public Room(String roomName,String description){
        this.roomName=roomName;
        this.description=description;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public boolean setExit(Room exit, char direction){
        boolean success=false;
        if(getExitAt(direction)==null){
            success=true;
            switch(direction) {
                case 'n':
                    this.setNorth(exit);
                    exit.setSouth(this);
                    break;
                case 's':
                    this.setSouth(exit);
                    exit.setNorth(this);
                    break;
                case 'e':
                    this.setEast(exit);
                    exit.setWest(this);
                    break;
                case 'w':
                    this.setWest(exit);
                    exit.setEast(this);
                    break;
                default:
                    return false;
            }
        }

        return success;
    }
    public Room getExitAt(char direction){
        //enhanced switch per assegnare direttamente il valore
        return switch (direction) {
            case 'n' -> north;
            case 'e' -> east;
            case 's' -> south;
            case 'w' -> west;
            default -> null;
        };
    }
    public String getName(){return roomName;}
    public List<Entity> getPopulation() {
        //restituisce una lista di sola lettura
        return List.copyOf(population);
    }
}
