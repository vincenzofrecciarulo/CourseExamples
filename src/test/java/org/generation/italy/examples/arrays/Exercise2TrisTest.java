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
            // Input con duplicati: 3 e 7
            int[] input = {3, 7, 1, 3, 9, 10, 7, 2, 4, 5};

            // Aspettativa: array di 10 elementi con 1 agli indici 2 (per il 3) e 6 (per il 7)
            int[] expected = {0, 0, 1, 0, 0, 0, 1, 0, 0, 0};

            int[] result = Exercise2Tris.findDuplicates(input);

            assertArrayEquals(expected, result, "L'array dei flag non corrisponde!");
        }
    }
