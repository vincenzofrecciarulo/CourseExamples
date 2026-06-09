package org.generation.italy.examples.oo.collections;

import org.generation.italy.examples.oo.collections.employee.Exercise1;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise1Test {

    String[] array;

    @BeforeEach
    void setUp() {
        array = new String[]{"pippo", "pluto", "paperino", "pippo", "pippo", "pippo", "pluto"};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getModa() {
        String expected = "pippo";
        String obtained = Exercise1.getModa(array);
        assertEquals(expected, obtained);
    }
}