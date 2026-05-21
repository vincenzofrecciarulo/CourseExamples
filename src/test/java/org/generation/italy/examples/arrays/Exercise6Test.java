package org.generation.italy.examples.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise6Test {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findMode_unique_numbers() {
        int[] testArray = {4, 5, 6, 7, 8, 9, 10, 11};
        assertEquals(4, Exercise6.findMode(testArray));
    }

    @Test
    void findMode_finds_one_mode() {
        int[] testArray = {4, 5, 6, 7, 8, 8, 9, 10, 11};
        assertEquals(8, Exercise6.findMode(testArray));
    }

    @Test
    void findMode_finds_one_mode_not_sequential() {
        int[] testArray = {10, 11, 12, 10, 11, 12, 10, 11, 12, 11, 13};
        assertEquals(11, Exercise6.findMode(testArray));
    }

    @Test
    void findMode_equal_repetitions() {
        int[] testArray = {10, 11, 12, 10, 11, 12, 10, 11, 12};
        assertEquals(10, Exercise6.findMode(testArray));
    }
}