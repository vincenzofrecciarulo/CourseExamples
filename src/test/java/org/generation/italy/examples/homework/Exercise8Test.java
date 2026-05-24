package org.generation.italy.examples.homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise8Test {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sumMatrixes() {
        int[][] firstMatrix = {
                {1,4,5},
                {3,2,6}
        };

        int[][] secondMatrix = {
                {1,4,5,4},
                {3,2,6,3},
                {1,3,5,7},
        };

        int[][] result = Exercise8.sumMatrixes(firstMatrix,secondMatrix);

        int[][] expected = {
                {2,8,10,4},
                {6,4,12,3},
                {1,3,5,7}
        };

        assertArrayEquals(expected,result);

    }
}