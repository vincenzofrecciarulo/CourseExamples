package org.generation.italy.examples.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise4Test {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findMax() {
    }

    @Test
    void findAverage() {
    }

    @Test
    void hasUniqueNumbers_returns_true_for_unique_numbers() {
        int[] numbers = {2,4,1 ,55, 3, 9};

        boolean distinct = Exercise4.hasUniqueNumbers(numbers);

        assertTrue(distinct);
    }

    @Test
    void hasUniqueNumbers_returns_false_for_non_unique_numbers() {
        int[] numbers = {2,3,1 ,55,4, 9, 9};

        boolean distinct = Exercise4.hasUniqueNumbers(numbers);

        assertFalse(distinct);
    }

    @Test
    void findModa() {
        int[] numbers = { 2, 3, 3, 44, 52, 5, 66, 77, 77, 77};

        int moda = Exercise4.findModa(numbers);

        int expected = 77;

        assertEquals(expected, moda);
    }

    @Test
    void findModa_return_any_moda_when_same_occurence() {
        int[] numbers = { 2, 3, 3, 44, 52, 5, 66, 77, 77};

        int moda = Exercise4.findModa(numbers);

        int expected = 3;

        assertEquals(expected, moda);
    }
}