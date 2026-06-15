package org.generation.italy.examples.battleship;

import java.util.Arrays;

public class BattleStart {

    public static void main() {

        BattleShip battleShip = new BattleShip();

        battleShip.initialSetUpTable();

        battleShip.setUpShip();

        battleShip.placeShips(battleShip.ships[0],Direction.VERTICAL,1,2);

        System.out.println(Arrays.deepToString(battleShip.table)+"\n");
    }
}
