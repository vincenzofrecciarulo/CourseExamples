package org.generation.italy.examples.oo.collections;

import java.util.Collections;
import java.util.List;

public class SortingExamples {
    public static void sortList(List<Integer> numbers){
        // metodo statico per ordinamento presente in Collections
        // avviene tramite due oggetti che implementano l'interfaccia Comparable con il metodo compareTo()
        Collections.sort(numbers);
    }


    public static void sortListOfStrings(List<String> strings) {
        Collections.sort(strings);
    }

    public static void sortListOfCats(List<Cat> cats) {
        // nelle classi custom non implementiamo di default l'interfaccia Comparable
        Collections.sort(cats);
    }
}
