package org.generation.italy.examples.arrays.exercisemap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseMapTest {

    List<String> strings = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Collections.addAll(strings,
                "Ciao",
                "Ciao",
                "Ciao",
                "Pippo",
                "Pippo",
                "Treno",
                "Treno",
                "Treno",
                "Treno",
                "Franco",
                "Franco",
                "Franco",
                "Franco");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStringMode() {
        assertEquals("Treno", ExerciseMap.getStringMode(strings));
    }
}