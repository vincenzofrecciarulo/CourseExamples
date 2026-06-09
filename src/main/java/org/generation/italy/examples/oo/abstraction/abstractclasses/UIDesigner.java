package org.generation.italy.examples.oo.abstraction.abstractclasses;

import java.time.LocalDate;
import java.util.ArrayList;

public class UIDesigner extends Person {
    private ArrayList<String> artisticTalents;
    private boolean hasExposed;

    public UIDesigner(String name, String surname, LocalDate dateofbirth, char gender,
                      boolean hasExposed, String... talents) {
        super(name, surname, dateofbirth, gender);
        this.hasExposed = hasExposed;
        this.artisticTalents = new ArrayList<>();

    }
}
