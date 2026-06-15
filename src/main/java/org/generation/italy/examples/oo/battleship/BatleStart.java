package org.generation.italy.examples.oo.battleship;

public class BatleStart {
    public static void main() {
        Battleship battleship = new Battleship();
        battleship.initialization();
        battleship.initShips();
        battleship.placeShip(battleship.ships[0], Orientation.VERTICAL, 1, 2);
        battleship.printTable();
    }

}
