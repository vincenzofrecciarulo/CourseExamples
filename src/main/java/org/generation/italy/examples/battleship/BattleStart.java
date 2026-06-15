package org.generation.italy.examples.battleship;

public class BattleStart {
    public static void main() {
        BattleShip battleship = new BattleShip();
        battleship.initialization();
        battleship.initShips();
        battleship.placeShip(battleship.ships[0], Orientation.VERTICAL, 1, 2);
        battleship.printTable();
    }

}