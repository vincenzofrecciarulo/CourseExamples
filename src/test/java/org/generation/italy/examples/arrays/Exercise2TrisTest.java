package org.generation.italy.examples.arrays;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Exercise2TrisTest {

    @BeforeEach
        void setUp() {
        }

        @AfterEach
        void tearDown() {
        }


        @Test
        void test_findDuplicates() {
            int[] input = {3, 7, 1, 3, 9, 10, 7, 2, 4, 5};

            int[] expected = {1, 1, 2, 1, 1, 0, 2, 0, 1, 1};

            int[] result = Exercise2Tris.rollCall(input);

            assertArrayEquals(expected, result, "L'array dei flag non corrisponde!");
        }
    }
