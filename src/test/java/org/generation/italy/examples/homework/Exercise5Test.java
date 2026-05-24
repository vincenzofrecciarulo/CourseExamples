package org.generation.italy.examples.homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise5Test {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void doFactorial_of_5() throws Exception {
        int num = 5;

        int result = Exercise5.doFactorial(num);

        int expected = 120;

        assertEquals(expected, result);
    }

    @Test
    void doFactorial_of_8() throws Exception {
        int num = 8;

        int result = Exercise5.doFactorial(num);

        int expected = 40320;

        assertEquals(expected, result);
    }

    @Test
    void doFactorial_of_1() throws Exception {
        int num = 1;

        int result = Exercise5.doFactorial(num);

        int expected = 1;

        assertEquals(expected, result);
    }

    @Test
    void doFactorial_of_0() throws Exception {
        int num = 0;

        int result = Exercise5.doFactorial(num);

        int expected = 1;

        assertEquals(expected, result);
    }

    @Test
    void doFactorial_of_negative() throws Exception {
        int num = -2;

        assertThrows(Exception.class, () -> Exercise5.doFactorial(num));
    }
}