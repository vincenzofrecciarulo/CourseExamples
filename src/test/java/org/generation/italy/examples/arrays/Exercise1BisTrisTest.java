package org.generation.italy.examples.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Exercise1BisTrisTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void invertArray() {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8};
        Exercise1BisTris.invertArray(testArray);
        int[] expected = {8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(expected, testArray);
    }
}