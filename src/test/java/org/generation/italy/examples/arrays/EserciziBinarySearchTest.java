package org.generation.italy.examples.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EserciziBinarySearchTest {

    @Test
    void indexOf_return_2() {
        int[] numbers = { 1, 20, 32, 44, 85, 200, 440, 29310};

        int result = EserciziBinarySearch.indexOf(numbers, 32);

        int expected = 2;

        assertEquals(expected, result);
    }

    @Test
    void indexOf_odd_array_return_2() {
        int[] numbers = { 1, 20, 32, 44, 85,  440, 29310};

        int result = EserciziBinarySearch.indexOf(numbers, 32);

        int expected = 2;

        assertEquals(expected, result);
    }

    @Test
    void indexOf_array_length_1_return_0() {
        int[] numbers = {32};

        int result = EserciziBinarySearch.indexOf(numbers, 32);

        int expected = 0;

        assertEquals(expected, result);
    }

    @Test
    void indexOf_array_length_2_return_1() {
        int[] numbers = {31,32};

        int result = EserciziBinarySearch.indexOf(numbers, 32);

        int expected = 1;

        assertEquals(expected, result);
    }

    @Test
    void indexOf_array_length_3_return_2() {
        int[] numbers = {31,32,33};

        int result = EserciziBinarySearch.indexOf(numbers, 33);

        int expected = 2;

        assertEquals(expected, result);
    }
}