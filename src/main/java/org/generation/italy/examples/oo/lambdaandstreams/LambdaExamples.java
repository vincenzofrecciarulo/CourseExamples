package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.Comparator;

public class LambdaExamples {
    static void main() {

/*        Comparator<String> longerStringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
*/
        Comparator<String> longerStringComparator = (a, b) -> (a.length() - b.length());
        String s1 = "Ciccio";
        String s2 = "Pasticcio";
        int result = longerStringComparator.compare(s1,s2);
        IO.println(result > 0 ? s1 + " is the longest String"
                : result == 0 ? s1 + " is as long as "+ s2
                : s2 + " is the longest String");
    }
}
