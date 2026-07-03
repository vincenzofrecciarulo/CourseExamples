package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.DataException;

public class Start {
    static void main() {
        TropicoConsole tropicoConsole = new TropicoConsole();
        try{
            tropicoConsole.startMenu();
        } catch (DataException e) {
            throw new RuntimeException(e);
        }

    }
}
