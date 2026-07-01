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
    void testStepsCount() {
        String[] path = {"", "U", ""};
        int steps = Exercise5.walk(path, 1);
        assertTrue(steps >= 1);
        System.out.println("\n"+(steps-1));
    }

}