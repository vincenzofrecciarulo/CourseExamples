package org.generation.italy.examples.oo.abstraction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class UIDesigner extends Person {
    private ArrayList<String> artisticTalents;
    private boolean hasExposed;

    public UIDesigner(String name, String surname, LocalDate dateofbirth, char gender, boolean hasExposed,
                      String... talents) {
        super(name, surname, dateofbirth, gender);
        this.hasExposed = hasExposed;
        this.artisticTalents = new ArrayList<>();
 //     for (String talent : talents) {
 //         artisticTalents.add(talent);
 //     }
        Collections.addAll(artisticTalents, talents);
    }

    @Override
    public void startWorking() {
        System.out.println("Io non lavoro, sono un artista!");
    }

    @Override
    public void assignTask() {
        System.out.println("Disegno quello che mi pare.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n").append(hasExposed ? "Sono un artista famoso." : "Non mi conosce nessuno...");
        if (artisticTalents.isEmpty()) {
            sb.append("\n Non ho molti talenti artistici... ");
        } else {
            for (String talent : artisticTalents) {
                sb.append("\n").append(talent);
            }
        }
        return sb.toString();
    }
}
