package org.generation.italy.examplesMio.collections;

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
        numbers = new ArrayList<>(List.of(27, 2, 6, 34, 31));
        strings = new ArrayList<>(List.of("belveth", "aatrox", "viego"));

        c1 = new Cat(20, LocalDate.of(2025, 7, 12), "Silvestro", "Nero");
        c2 = new Cat(12, LocalDate.of(2023, 1, 17), "Yuumi", "Grigio");
        c3 = new Cat(10, LocalDate.of(2026, 1, 1), "Maoyorik", "Maculato");

        cats = new ArrayList<>(List.of(c1, c2, c3));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sortList() {
        SortingExamples.sortList(numbers);
        assertEquals(List.of(2, 6, 27, 31, 34), numbers);
    }

    @Test
    void sortListOfString() {
        SortingExamples.sortListOfString(strings);
        assertEquals(List.of("aatrox", "belveth", "viego"), strings);
    }

    @Test
    void sortListOfCats() {
        SortingExamples.sortListOfCats(cats);
        assertEquals(List.of(c3, c2, c1), cats);
    }

    @Test
    void sortListOfCatAge(){
        SortingExamples.sortListOfCatsByAge(cats);
        assertEquals(List.of(c3, c1, c2), cats);
    }
}