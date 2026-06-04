package org.generation.italy.examples.oo.abstraction;

import java.time.LocalDate;

public class Main {
    // when using varargs in a constructor, we can even pass 0 parameters and it will compile
    void main() {
        UIDesigner u = new UIDesigner("Ciccio", "Pasticcio",
                LocalDate.of(1998, 7, 4),
                'M', false,
                "Disegno astratto", "Disegno tecnico", "Composizione", "Graphic design");
        FullstackDeveloper g = new FullstackDeveloper("Giovanni", "Cataldo",
                LocalDate.of(2001, 5, 2), 'M',
                LocalDate.of(2019, 7, 2),
                "Python", "Java", "JavaScript", "Rust", "C");
//        IO.println(u);
//        IO.println(g);
        // this is a problem, we can create Person objects if we want. we can't now that Person is declared as an abstract class!
        // You can't create objects of an abstract class.
//        Person p1 = new Person("Giuseppe", "Cataldo", LocalDate.of(1992, 3, 1), 'M');
        Manager m = new Manager("Francesco", "Franceschi", LocalDate.of(1993, 6,8),
                'M', true);
        m.onboardNewHire(u);   // polymorphic method, we pass both a UIDesigner and a FullstackDeveloper
        m.onboardNewHire(g);
    }
}
