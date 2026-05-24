package org.generation.italy.examples.homework;

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
    void calculateFibonacci_length_of_5() throws Exception {
        int length = 5;

        int[] fibonacci = Exercise6.calculateFibonacci(length);

        int[] expected = {0,1,1,2,3};

        assertArrayEquals(expected, fibonacci);
    }

    @Test
    void calculateFibonacci_length_of_9() throws Exception {
        int length = 9;

        int[] fibonacci = Exercise6.calculateFibonacci(length);

        int[] expected = {0,1,1,2,3,5,8,13,21};
        assertArrayEquals(expected, fibonacci);
    }

    @Test
    void calculateFibonacci_length_of_2() throws Exception {
        int length = 2;

        int[] fibonacci = Exercise6.calculateFibonacci(length);

        int[] expected = {0,1};
        assertArrayEquals(expected, fibonacci);
    }
}