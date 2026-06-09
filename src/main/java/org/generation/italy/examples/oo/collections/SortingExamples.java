package org.generation.italy.examples.oo.collections;

import java.util.Collections;
import java.util.List;

public class SortingExamples {
    public static void sortList(List<Integer> numbers){
        //metodo statico per ordinamento presente in collections
        //avviene tramite due oggetti che implementano l'interfaccia comparabile con ilmetodo compareIo()
        Collections.sort(numbers);
    }

    public static void sortListOfStrings(List<String> strings){
        Collections.sort(numbers);
    }
}
