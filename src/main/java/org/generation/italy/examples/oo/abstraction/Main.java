package org.generation.italy.examples.oo.abstraction;

import java.time.LocalDate;

public class Main {
    void main() {
        UIDesigner u = new UIDesigner("Ciccio","Pasticcio",
                LocalDate.of(1998,7,4), 'M',false,
                "Disegno astratto", "Disegno tecnico","Composizione","Graphic Designer");

        FullstackDeveloper g = new FullstackDeveloper("Giovanni","Cataldo",
                LocalDate.of(2001,5,2), 'M',
                LocalDate.of(2019,7,2), "Python","Java","JavaScript","Rust","C");

        Manager m = new Manager(" Francesco","Pipillo",LocalDate.of(1993,5,22),
                'M',true);

        m.onboardNewHire(u);
        m.onboardNewHire(g);
    }
}
