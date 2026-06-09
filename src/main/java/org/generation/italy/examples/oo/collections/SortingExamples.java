package org.generation.italy.examples.oo.collections;

import java.util.Collections;
import java.util.List;

public class SortingExamples {
    // lavoriamo senza oggetti in questo caso, a fini didattici
    public static void sortList(List<Integer> numbers) {
        Collections.sort(numbers);     // Collections is a utility class. sort works in-place
    }

    public static void sortListOfStrings(List<String> strings) {
        Collections.sort(strings);
    }

    public static void sortListOfCats(List<Cat> cats) {
        // we can't if cats doesn't implement Comparable.
        // we have to implement it and override compareTo.
        // Sort is a POLYMORPHIC METHOD on the Comparable interface.
        Collections.sort(cats);
    }
}
