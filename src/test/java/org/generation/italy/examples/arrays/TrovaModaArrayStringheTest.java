package org.generation.italy.examples.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TrovaModaArrayStringheTest {
   String[] words;
    @BeforeEach
    void setUp() {
        words = new String[]{"pippo","pluto","pluto","mickey","pluto","mickey"};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void trovaModaStringhe() {
        String mode = TrovaModaArrayStringhe.trovaModaStringhe(words);
        assertEquals("pluto",mode);
    }
}