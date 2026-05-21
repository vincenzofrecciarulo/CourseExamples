package org.generation.italy.examples.arrays;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class Exercise4LezioneTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void invert_test() {
        int[] arr = {0, 3, 4, 6, 9, 2, 15, 18, 29, 784, 32};
        Exercise3Lezione.invert(arr);
        int[] expected = {32, 784, 29, 18, 15, 2, 9, 6, 4, 3, 0};
        assertArrayEquals(expected, arr);
    }

    @Test
    void has_unique_numbers_returns_true_for_unique_numbers() {
        int[] numbersTest = {1, 2, 3, 4, 5, 6, 7};
        boolean distinct = Exercise4Lezione.hasUniqueNumbers(numbersTest);
        assertTrue(distinct);
    }

    @Test
    void has_unique_numbers_returns_false_for_duplicates() {
        int[] numbersTest = {1, 2, 3, 4, 5, 6, 6};
        boolean distinct = Exercise4Lezione.hasUniqueNumbers(numbersTest);
        assertFalse(distinct);
    }
}