package org.generation.italy.examples.NewExercises;

import java.util.HashMap;
import java.util.Map;

public class Exercise010 {

    static void main() {
        Map<String, Integer> parole = new HashMap<>();

        while (true) {
            String name = IO.readln("Aggiungi il nome (invio per uscire): ");

            if (name.isEmpty()) {
                break;
            }

            if (parole.containsKey(name)) {
                parole.put(name, parole.get(name) + 1);
            } else {
                parole.put(name, 1);
            }
        }

        System.out.println(parole);
    }
}