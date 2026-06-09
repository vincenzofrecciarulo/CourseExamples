package org.generation.italy.examples.oo.collections;

import java.util.Comparator;

public class CatComparatorByAge implements Comparator<Cat> {
    @Override
    public int compare(Cat g1, Cat g2) {
        if(g1.isOlderThan(g2)){
            return 1;
        }

        if(g2.isOlderThan(g1)){
            return -1;
        }

        return 0;
    }
}
