package org.generation.italy.examples.arrays;

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
    void findMaxAndMin() {
        int[] test = {-24,56,-56,11,11,33};
        String result = Exercise5.findMaxAndMin(test);
        String expected = "Valore massimo " + 56 + " Valore minimo " + -56;
        assertEquals(expected,result);
    }

    @Test
    void find_average_double(){
        double[] test = {5.0,5.0,5.0,5.0};
        double result =Exercise5.findAverageDouble(test);
        double expected = 5.0;
        assertEquals(expected,result);
    }
}