package org.generation.italy.examples.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise2BisTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void populateArrayRandIntsZeroTen() {
        int[] array = new int[100];
        Exercise2Bis.populateArrayRandIntsZeroTen(array);
        for (int j : array) {
            assertTrue(j >= 1, "Value should have been >= 1");
            assertTrue(j <= 10, "Value should have been <= 10");
        }
    }

    @Test
    void hasDuplicates_returns_true_if_duplicates_found() {
        int[] array = {1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 3, 16};
        assertTrue(Exercise2Bis.hasDuplicates(array));
    }

    @Test
    void hasDuplicates_returns_false_if_duplicates_not_found() {
        int[] array = {1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        assertFalse(Exercise2Bis.hasDuplicates(array));
    }
}