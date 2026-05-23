package org.generation.italy.examples.homework;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Exercise3Test {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isCharFoundMoreOnFirstString_return_true() {
        String firstString = "Hello world!";

        String secondString = "Hi Lorenzo Pollo!";

        char c  = 'l';

        boolean result = Exercise3.isCharFoundMoreOnFirstString(firstString, secondString, c);

        assertTrue(result);
    }

    @Test
    void isCharFoundMoreOnFirstString_return_false() {
        String firstString = "Hello world!";

        String secondString = "Hi how are you Lorenzo?";

        char c  = 'r';

        boolean result = Exercise3.isCharFoundMoreOnFirstString(firstString, secondString, c);

        assertFalse(result);
    }
}