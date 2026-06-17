package org.generation.italy.examples.oo.practiceexercises.streamandlambdaexercise.asinc;
/*Creare una List di Person
• Inserirvi dieci Person con dati diversi
• Filtrare le persone al suo interno usando una lambda, eliminando le Person di genere
maschile
• Stampare il risultato

 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonReporter {

    List<Person> people = List.of(
            new Person("Daniele", 'm'),
            new Person("Danilo", 'm'),
            new Person("Daniela", 'f'),
            new Person("Chiara", 'f'),
            new Person("Lucrezia", 'f'));


    public List<Person> filteredByFemale() {
        return people.stream().filter(p -> p.getGender() == 'f').toList();
    }

}
