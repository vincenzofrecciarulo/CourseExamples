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
        numbers = new ArrayList<>(List.of(15, 13, 16, 28, 3, 18, 50, 1, 100));
        // le maiuscole sfasano il sorting (e compareTo) di String. le stringhe, comunque, verranno ordinate
        // in ordine alfabetico, e verranno comparati i loro valori ASCII.
        // questo perché le maiuscole hanno tutte codici ASCII minori delle minuscole.
        strings = new ArrayList<>(List.of("ciao", "Giovanni", "sono", "tutti", "a"));
        c1 = new Cat("Cutiepie", "white", LocalDate.now(), 10);
        c2 = new Cat("Fluffyshit", "yellow", LocalDate.now(), 8);
        c3 = new Cat("Wowie", "black", LocalDate.now(), 4);
        cats = new ArrayList<>(List.of(c1, c2, c3));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sortList() {
        SortingExamples.sortList(numbers);
        assertEquals(List.of(1, 3, 13, 15, 16, 18, 28, 50, 100), numbers);
    }

    @Test
    void sortListOfStrings() {
        SortingExamples.sortListOfStrings(strings);
        assertEquals(List.of("Giovanni", "a", "ciao", "sono", "tutti"), strings);
    }

    @Test
    void sortListOfCats() { // we've overridden compareTo in Cat so sort them by ascending weight
        SortingExamples.sortListOfCats(cats);
        assertEquals(List.of(c3, c2, c1), cats);
    }
}