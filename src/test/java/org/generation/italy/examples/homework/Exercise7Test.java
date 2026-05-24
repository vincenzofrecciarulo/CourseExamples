package org.generation.italy.examples.homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise7Test {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createMatrixWithDiagonals_with_side_of_5() {
        int side = 5;

        int[][] result = Exercise7.createMatrixWithDiagonals(side);

        int[][] expected = {
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };

        assertArrayEquals(expected, result);

    }

    @Test
    void createMatrixWithDiagonals_with_side_of_4() {
        int side = 4;

        int[][] result = Exercise7.createMatrixWithDiagonals(side);

        int[][] expected = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };

        assertArrayEquals(expected, result);

    }
    @Test
    void createMatrixWithDiagonals_with_side_of_2() {
        int side = 2;

        int[][] result = Exercise7.createMatrixWithDiagonals(side);

        int[][] expected = {
                {1,1},
                {1,1},
        };

        assertArrayEquals(expected, result);

    }

    @Test
    void createMatrixWithDiagonals_with_side_of_1() {
        int side = 1;

        int[][] result = Exercise7.createMatrixWithDiagonals(side);

        int[][] expected = {
                {1}
        };

        assertArrayEquals(expected, result);

    }
}