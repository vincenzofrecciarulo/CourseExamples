package org.generation.italy.examples.oo.asincrone.lambda;

import org.generation.italy.examples.oo.asincrone.ereditarietà.ForeignEmployee;
import org.generation.italy.examples.oo.asincrone.ereditarietà.Person;
import org.generation.italy.examples.oo.asincrone.ereditarietà.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterPerson {

    static void main() {
        List<Person> personList =new ArrayList<>();

        personList.add(new Student("Gianni","Sperti","12-12-12","M",4,"A"));
        personList.add(new ForeignEmployee("Tina","Cipollari",
                        "12-12-12","F","Pescivendola",9000,"Africano"));

        personList.add(new Student("Mavco","Giordano","12-12-15","M",1,"B"));

        personList.add(new ForeignEmployee("Maria","De-Filippi",
                "11-12-49","F","Psicologa",20000,"Francese"));


        Predicate<Person> males = p->p.getG().equals("M");
        personList.removeIf(males);


    }



}
