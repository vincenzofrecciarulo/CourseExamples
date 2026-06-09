package org.generation.italy.examples.arrays.other;

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
    void hasUniqueNumbers_returns_true_for_unique_numbers() {
        int[] numbersTest = {1,2,3,4,5,6,7};
        boolean distinct = Exercise4.hasUniqueNumbers(numbersTest);
        Assertions.assertTrue(distinct);
    }
    @Test
    void hasUniqueNumbers_returns_false_for_unique_numbers() {
        int[] numbersTest = {1,2,3,4,5,6,6};
        boolean distinct = Exercise4.hasUniqueNumbers(numbersTest);
        Assertions.assertFalse(distinct);
    }
}