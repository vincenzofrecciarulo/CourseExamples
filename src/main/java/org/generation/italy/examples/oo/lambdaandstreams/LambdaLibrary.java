package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaLibrary {
    public static BinaryOperator<String> usageConcat;
    private static int count;
    static Consumer<String> charCounter = (a) -> count += a.length();

    static Function<String, String> standardize = a -> a.trim().toLowerCase();

    static BiFunction<String, String, String> concat = (a,b) -> a + " "+b ;

    public static int getCount() {
        return count;
    }
}