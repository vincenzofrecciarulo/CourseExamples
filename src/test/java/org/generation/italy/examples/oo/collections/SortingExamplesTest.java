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
    List <Cat> cats;
    Cat c1; Cat c2; Cat c3;
    @BeforeEach
    void setUp() {
        numbers= new ArrayList<>(List.of(27,2,6,56,23,15,83,8,17));
        strings = new ArrayList<>(List.of("ciao","pippo","sono","a","tutti"));

             c1=new Cat("silvestro","nero", LocalDate.of(2020,11,24), 15),
             c2=new Cat("micio","bianco", LocalDate.of(2020,11,20), 20),
             c3=new Cat("puffo","grigio", LocalDate.of(2020,11,21), 10)
        cats = new ArrayList<>(List.of());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sortList() {
        SortingExamples.sortList(numbers);
        assertEquals(List.of(2,6,8,15,17,23,27,56,83), numbers);
    }

    @Test
    void SortingString() {
        SortingExamples.sortListOfStrings(strings);
        assertEquals(List.of("a", "ciao", "pippo","sono","tutti"), strings);
    }

    @Test
    void sortListOfCats() {
        SortingExamplesTest
    }
}