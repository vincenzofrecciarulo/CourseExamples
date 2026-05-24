package org.generation.italy.examples.homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise9Test {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void matrixProduct() {
    }

    @Test
    void calculateCellValue() throws Exception {
        int[][] firstMatrix = {
                {1,0,2},
                {0,3,-1},
        };

        int[][] secondMatrix = {
                {4,1},
                {-2,2},
                {0,3}
        };

        int[][] result = Exercise9.matrixProduct(firstMatrix, secondMatrix);

        int[][] expected = {
                {4,7},
                {-6, 3}
        };

        assertArrayEquals(expected, result);
    }
}