package org.generation.italy.examples.homework;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise4Test {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void askYesOrNo() {
        String result = Exercise4.askYesOrNo();

        String expected = "yes";

        assertEquals(expected, result);
    }
}