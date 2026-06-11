package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLibrary {
    private static int count;
    private static int sum;

    // Ex1
    static Consumer<String> charCounter = (a) -> count += a.length();

    // Ex2
    static Function<String, String> standardize = a -> a.trim().toLowerCase();

    // Ex3
    static BinaryOperator<String> concat = (a, b) -> a + " " + b;

    // Ex5
    static Predicate<Integer> isEven = n -> n % 2 == 0;

    // Ex6
    static Consumer<Integer> addToSum = n -> sum += n;

    // Ex7
    static Function<Integer, Integer> square = n -> n * n;

    public static int getCount() { return count; }
    public static int getSum()   { return sum; }
}
