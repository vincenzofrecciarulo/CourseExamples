package org.generation.italy.examples.arrays;
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
    void invertTest(){
        int[] a={32,1512,0,51,0,25,1,8,4};
        Exercise3.invertArray(a);
        int[] invertedA={4,8,1,25,0,51,0,1512,32};
        assertArrayEquals(invertedA,a);
    }
}