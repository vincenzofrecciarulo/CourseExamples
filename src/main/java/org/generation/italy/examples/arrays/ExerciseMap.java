package org.generation.italy.examples.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseMap {
    /* esercizio 1:
 creare una funzione statica che riceva in input un array di stringhe, e restituisca la moda
 di queste stringhe (l'elemento che appare più volte) l'algoritmo deve avere efficienza O(n)
 se ci sono più mode, ne ritorna una a caso */



        public static void moda (List < String > string) {

            HashMap<String, Integer> strings = new HashMap<>();
            int maxCount = 0;
            String s1 = "";
            for (String s : string) {
                if (strings.containsKey(s)) {
                    strings.put(s, strings.get(s) + 1);
                } else {
                    strings.put(s, 1);
                }
            }

            for (Map.Entry<String, Integer> entry : strings.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    s1 = entry.getKey();
                }
            }
            IO.println(s1);
        }

    }

