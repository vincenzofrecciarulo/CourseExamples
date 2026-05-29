package org.generation.italy.examples.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise5Test {

    @Test
    void checkDuplicates() {
        int[] numbersTest = {1,2,4,4,5,6,7};
        boolean distinct = Exercise5.checkDuplicates(numbersTest);
        assertTrue(distinct);

    }
}