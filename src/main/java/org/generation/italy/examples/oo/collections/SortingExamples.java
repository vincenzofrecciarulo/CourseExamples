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

    public static void sortListOfCatsByAge(List<Cat> cats){
        CatComparatorByAge catComparatorByAge = new CatComparatorByAge();
        /*Cat c1 = null;
        Cat c2 = null;
        int result = catComparatorByAge.compare(c1,c2);*/

        //Metodo spostato direttamente sull'interfaccia List
        cats.sort(catComparatorByAge);
    }
}
