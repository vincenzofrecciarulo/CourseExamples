package org.generation.italy.examplesMio.ooMio.mod9;

import java.util.List;

public class Lesson016 {

    static void main() {
        Teacher t = new Teacher("George", "Romano", "1960-01-01", "M", 1000, "Cinema");

        System.out.println(t.getYearlyRetribution());

        Support s = new Support("Jane", "Doe", "1990-01-01", "F", 1000, "Administration");

        System.out.println(s.getYearlyRetribution());

        Student c = new Student("Mario", "Rossi", "2000-01-01", "M", List.of(6, 6, 6, 6, 6 ));

        System.out.println(c.getCost());
    }
}
