package org.generation.italy.examples.arrays.Battaglia;

import java.util.Arrays;
import java.util.List;

public class Player {

    private String name;
    private Board myBoard;
    private List<Ship> fleet;

    public Player(String name) {
        this.name = name;
        this.myBoard = new Board();
        this.fleet = Arrays.stream(ShipType.values())
                .map(type -> new Ship(type))
                .toList();
    }

    public boolean hasLost() {
        return fleet.stream().allMatch(Ship::isSunk);
    }

    public String getName() {
        return name;
    }

    public Board getMyBoard() {
        return myBoard;
    }

    public List<Ship> getFleet() {
        return fleet;
    }


}
