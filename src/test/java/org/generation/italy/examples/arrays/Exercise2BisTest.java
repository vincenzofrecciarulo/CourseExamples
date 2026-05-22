package org.generation.italy.examples.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise2BisTest {

    @Test
    void hasUniqueNumbers() {
        int[] testNumbers = {1,1,2,3,4};
        boolean test = Exercise2Bis.hasUniqueNumbers(testNumbers);
        boolean expected = false;
        assertFalse(expected, String.valueOf(test));
    }
}