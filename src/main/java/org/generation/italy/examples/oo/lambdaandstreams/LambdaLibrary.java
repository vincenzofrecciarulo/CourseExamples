package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.function.*;

public class LambdaLibrary {
    private static int count;

    static Consumer<String> charCounter = (a) -> count += a.length();

    static Function<String, String> standardize = a -> a.trim().toLowerCase();
//      METODO 2: return a.trim().toLowerCase()
//      METODO 3:
//      a = a.trim();
//      a = a.toLowerCase();
//      return a;
//    };
    static BinaryOperator<String> concat = (a, b) -> a + " " + b;

    public static int getCount()         {return count;}

    static Predicate<Integer> isEven = (a) -> a % 2 == 0;

    static int sum;
    static Consumer<Integer> addToSum = (a) -> sum += a;

    static Function<Integer, Integer> square = (a) -> a * a;
}
