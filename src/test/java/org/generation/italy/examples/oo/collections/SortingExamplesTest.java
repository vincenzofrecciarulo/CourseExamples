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
        numbers = new ArrayList<>(List.of(27, 2 , 6, 55, 3, 93,5));
        strings = new ArrayList<>(List.of("ciao", "pippo", "sono", "a", "tutti"));
        c1 = new Cat("Silvestro", "Nero", LocalDate.of(2001,3,22), 150);
        c2 = new Cat("Garfield", "Arancione", LocalDate.of(2005,5,19), 180);
        c3 = new Cat("Paw", "White", LocalDate.of(2000,3,28), 100);

        cats = new ArrayList<>(List.of(c1,c2,c3));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sortList() {
        SortingExamples.sortList(numbers);
        assertEquals(List.of(2,3,5,6,27,55,93), numbers);

    }

    @Test
    void sortListString(){
        SortingExamples.sortListOfStrings(strings);

        assertEquals(List.of("a", "ciao", "pippo", "sono", "tutti"), strings);
    }

    @Test
    void sortListOfCats(){
        SortingExamples.sortListOfCats(cats);

        assertEquals(List.of(c3,c1,c2),cats);
    }

    @Test
    void sertListCatsAge(){
        SortingExamples.sortListOfCatsByAge(cats);
        assertEquals(List.of(c2,c1,c3),cats);
    }

}