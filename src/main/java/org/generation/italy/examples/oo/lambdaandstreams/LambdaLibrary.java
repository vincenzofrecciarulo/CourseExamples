package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLibrary {
    static int count;
    static Consumer<String> charCounter = (a) -> count += a.length();

    public static int getCount() {
        return count;
    }

    static Function<String, String> standardize = (a) -> {
        a = a.trim();
        a = a.toLowerCase();
        return a;
    };

    static BiFunction<String, String, String> concat = (a, b) -> a + "" + b;

    static Predicate<Integer> isEven = (a) -> {
        return (a % 2 == 0);
    };

    static Consumer<Integer> addToSum = a -> count += a;

    static Function<Integer, Integer> quadrato = a -> a * a;

    static Function<String, Product> toProduct = s -> {
        String[] parts = s.split(" - ");
        String name = parts[0];
        double price = Double.parseDouble(parts[1]);
        return new Product(name, price);
    };
}



