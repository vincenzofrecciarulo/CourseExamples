package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.Comparator;

public class LambdaExamples {
    static void main() {
//        Comparator<String> longerStringComparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        };

        //dimostrazione della sintassi LAMBDA
        Comparator<String> longerStringComparator = (a, b) -> a.length() - b.length();
        String s1 = "Ciao";
        String s2 = "Pippo";
        int result = longerStringComparator.compare(s1, s2);
        IO.println(result > 0 ? s1+" è la stringa più lunga."
                : result == 0 ? s1+" è uguale a "+s2
                  : s2+ " è la stringa più lunga");
    }
}