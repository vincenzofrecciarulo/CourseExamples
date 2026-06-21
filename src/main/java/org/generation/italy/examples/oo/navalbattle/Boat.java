package org.generation.italy.examples.oo.navalbattle;


import java.util.ArrayList;
import java.util.List;

public class Boat {
    private List<Coordinate>  coordinates;

    public Boat() {
        coordinates = new ArrayList<>();
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void addCoordinate(Coordinate coordinate){
        coordinates.add(coordinate);
    }

    public void removeCoordinate(Coordinate coordinate){
        coordinates.remove(coordinate);
    }
}
