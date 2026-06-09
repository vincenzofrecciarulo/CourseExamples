package org.generation.italy.examples.oo.modulo009;

import java.time.LocalDate;

public class Main {
    void main() {

        Student s = new Student("Mario", "Rossi", LocalDate.of(1998,11,24),"M");
        Person k = new Teacher("Chiara","Rossi",LocalDate.of(1990,11,24),"f",1500);
        Employee f = new Support("Carlo","Bianchi",LocalDate.of(1983,11,24),"m",1650);

        s.addVote(8, "Matematica");
        s.addVote(7, "Italiano");
        s.addVote(9, "Informatica");
        s.addVote(9, "Informatica");

        System.out.println("Media: " + s.calculateMediumVotes());
        IO.println("Per lo studente "+s.name+" "+s.surname+" Dobbiamo pagare: "+s.getCost()+" euro.");

        System.out.println();
        System.out.println("Per l'impiegato "+k.name+" "+k.surname+", dobbiamo pagare annualmente "+k.getCost()+" euro.");

        System.out.println();
        System.out.println("Per l'impiegato "+f.name+" "+f.surname+", dobbiamo pagare annualmente "+f.getCost()+" euro.");
    }
}
