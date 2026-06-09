package org.generation.italy.examples.oo.modulo009;

import com.generation.library.Console;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lesson {

        static void main() {
            List<Person> people = new ArrayList<Person>();
            people.add(new Teacher("Kappa", "Kappone", LocalDate.of(1998, 11, 24), "M", 1400));
            people.add(new Support("Maria", "Mariona", LocalDate.of(1998, 11, 24), "f", 1500));
            people.add(new Teacher("Peppo", "Pepppini", LocalDate.of(1998, 11, 24), "M", 1300));
            people.add(new Support("Giuseppina", "Peppa", LocalDate.of(1998, 11, 24), "F", 1500));

            List<Person> female = new ArrayList<Person>();
            for (Person p : people)
                if (p.getGender().equalsIgnoreCase("f"))
                    female.add(p);

            for (Person p : female)
            IO.println(p.getName() + " " + p.getSurname());
        }
}

