package org.generation.italy.examples.oo.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExamples {
    public static void sortList(List<Integer> numbers){
        Collections.sort(numbers);
    }

    public static void sortListOfStrings(List<String> strings) {
        Collections.sort(strings);
    }

    public static void sortListOfCats(List<Cat> cats) {
        Collections.sort(cats);
    }

    public static void sortListOfCatsByAge(List<Cat> cats){
        CatComparatorByAge catComparatorByAge = new CatComparatorByAge();
        cats.sort(catComparatorByAge);
    }
}
