package org.generation.italy.examples.oo.battleship;

import java.util.Random;

public class BattleStart {
    public static void main() {
        Random random = new Random();
        BattleShip game = new BattleShip();

        game.initialization();
        game.initShips();

        for (Ship ship : game.ships) {
            boolean placed = false;
            while (!placed) {
                Orientation orientation = random.nextBoolean() ? Orientation.VERTICAL : Orientation.HORIZONTAL;
                int x = random.nextInt(game.ROW);
                int y = random.nextInt(game.COL);
                placed = game.placeShip(ship, orientation, x, y);
            }
        }

        System.out.println("Benvenuto a Battaglia Navale!");

        while (!allSunk(game)) {
            // game.printTable();
            int x = readInt("Inserisci riga (0-" + (game.ROW - 1) + "): ");
            int y = readInt("Inserisci colonna (0-" + (game.COL - 1) + "): ");

            if (x < 0 || x >= game.ROW || y < 0 || y >= game.COL) {
                System.out.println("Coordinate fuori dalla griglia, riprova.");
                continue;
            }

            game.fire(x, y);
        }
        System.out.println("Hai affondato tutte le navi! Hai vinto!");
    }

    private static int readInt(String message) {
        try {
            return Integer.parseInt(IO.readln(message).trim());
        } catch (NumberFormatException e) {
            System.out.println("Valore non valido, riprova.");
            return readInt(message);
        }
    }

    private static boolean allSunk(BattleShip game) {
        for (Moves[] row : game.table) {
            for (Moves cell : row) {
                if (cell == Moves.SHIP || cell == Moves.HIT) return false; // Lazy evaluation - short circuit
            }
        }
        return true;
    }
}
