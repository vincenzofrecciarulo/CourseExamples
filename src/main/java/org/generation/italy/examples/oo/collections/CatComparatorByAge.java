package org.generation.italy.examples.oo.collections;

import java.util.Comparator;

// we SHOULD write one of these for every kind of comparison we want to implement (cause Java is not a functional language)
// but Streams were introduced for this - to implement features typical of functional languages.
// LAMBDA EXPRESSIONS are syntactic sugar for SIMULATING passing functions to other functions.
// what it does under the hood is this we did manually here.
public class CatComparatorByAge implements Comparator<Cat> {

    @Override
    public int compare(Cat c1, Cat c2) {
        // I want them sorted by ascending age. so: 1 if first is older than 2nd, -1 if it's younger
        if (c1.isOlderThan(c2)) {
            return 1;
        } if (c2.isOlderThan(c1)) {
            return -1;
        }
        return 0;
    }

}
