package org.generation.italy.examples.oo.battleShip;

public class InputManager {

    // Legge e valida le coordinate (es: "b-7")
    public static Coordinate readCoordinate() {
        while (true) {
            try {
                String input = IO.readln("Inserisci la coordinata riga-colonna della nave (es: b-7):\n");
                String[] parts = input.trim().toLowerCase().split("-");

                if (parts.length != 2) {
                    IO.println("Formato non valido. Usa il trattino (es: b-7).");
                    continue;
                }

                char row = parts[0].charAt(0);
                int column = Integer.parseInt(parts[1]);

                // Controlliamo subito se sono nei limiti della griglia (0-9 e a-j)
                if (row >= 'a' && row <= 'j' && column >= 0 && column <= 9) {
                    return new Coordinate(row, column);
                }

                IO.println("Coordinate fuori dai limiti della griglia (a-j e 0-9).");
            } catch (Exception e) {
                IO.println("Input non valido. Riprova.");
            }
        }
    }

    // Legge e valida l'orientamento (V o O)
    public static char readOrientation() {
        while (true) {
            String input = IO.readln("Inserire l'orientamento della nave (V/O):\n").trim().toUpperCase();
            if (!input.isEmpty()) {
                char orientation = input.charAt(0);
                if (orientation == 'V' || orientation == 'O') {
                    return orientation;
                }
            }
            IO.println("Orientamento inserito non valido. Inserisci V oppure O.");
        }
    }
}
