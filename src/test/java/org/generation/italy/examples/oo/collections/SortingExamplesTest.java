package org.generation.italy.examples.oo.collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortingExamplesTest {
    List<Integer> numbers;
    List<String> strings;
    List<Cat> cats;
    Cat c1;
    Cat c2;
    Cat c3;
    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>(List.of(27,13,2,67,15));
        strings = new ArrayList<>(List.of("ciao", "pippo", "sono", "a", "tutti"));
         c1 = new Cat("silvestro","nero", LocalDate.of(2025,7,12), 2 );
         c2 = new Cat("pippo","bianco", LocalDate.of(2024,2,28), 6 );
         c3 = new Cat("titti","arancione", LocalDate.of(2026,1,28), 1 );
        cats = new ArrayList<>(List.of(c1,c2,c3));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sortList() {
        SortingExamples.sortList(numbers);
        assertEquals(List.of(2,13,15,27,67), numbers);
    }

    // Abbiamo eseguito il metodo TDD(Test-Driven Development) -> prima nel test e poi nel codice di produzione
    // Vantaggi -> fase creativa(forse), scrivere codice più utilizzabile sempre
    @Test
    void sortListString(){
        SortingExamples.sortListOfStrings(strings);
        // genera errore, le maiuscole hanno un valore hash minore delle minuscole
        assertEquals(List.of("a", "ciao","pippo", "sono","tutti"),strings);
    }

    @Test
    void sortListCats(){
        SortingExamples.sortListOfCats(cats);
        assertEquals(List.of(c3,c1,c2), cats);
    }

    @Test
    void sortListCatsByAge() {
        SortingExamples.sortListOfCatByAge(cats);
        assertEquals(List.of(c3,c1,c2), cats);
    }
}