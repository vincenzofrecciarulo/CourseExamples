package org.generation.italy.examples.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise3BisTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void populateArrayRandInts() {
        int[] array = new int[500];
        Exercise3Bis.populateArrayRandInts(array);
        for (int j : array) {
            assertTrue(j >= -100, "Value should have been >= -100");
            assertTrue(j <= 100, "Value should have been <= 100");
        }
    }

    @Test
    void findMax() {
        int[] array = {4, 18, 20, 28, 39493, 3, 19291, 10, 15, 3, 3, 5};
        assertEquals(39493, Exercise3Bis.findMax(array));
    }

    @Test
    void findMin() {
        int[] array = {4, 18, 20, 28, 39493, 3, 19291, 10, 15, 3, 3, 5};
        assertEquals(3, Exercise3Bis.findMin(array));
    }
}