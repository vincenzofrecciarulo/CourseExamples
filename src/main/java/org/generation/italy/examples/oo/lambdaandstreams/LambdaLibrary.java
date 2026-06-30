package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

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
}
