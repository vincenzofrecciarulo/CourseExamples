package org.generation.italy.examplesMio.arraysMio;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Exercise3Test {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void invertTest() {
        int[] numArrayTest = {1,2,3,4,5,6,7,8,9,10};
        Exercise3.invert(numArrayTest);
        int[] expected = {10,9,8,7,6,5,4,3,2,1};
        assertArrayEquals(expected, numArrayTest);
    }
}