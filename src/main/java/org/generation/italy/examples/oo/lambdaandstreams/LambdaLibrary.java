package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.function.*;
import java.util.stream.Collector;

public class LambdaLibrary {
    // this consumer will count the numbers of characters in each String.
    // the variables we use inside a lambda expression need to be declared outside, if we need em outside.
    // this is because the variables we write in the lambda expression are scoped to the lambda expression context itself.
    private static int count;
    private static int sum;
    private static double pricesTotal;

    static Consumer<String> charCounter = (a) -> count += a.length();   // remember, the type is implicit.

//    static Function<String, String> standardize = (a) -> {   // we need parentheses if we want to execute multiple instructions
//        a = a.trim();
//        a.toLowerCase();
//        return a;
//    };

    // look above. this is the same. we don't need return cause if it's only one line,
    // return is implicit (if the method has a return type)
    // Function takes two types, one for the input and the other for the output
    static Function<String, String> standardize = a -> a.trim().toLowerCase();

    // BiFunction<T, S, B> is like Function, but it takes 2 input types instead of 1
    // we replace it with BinaryOperator<T>, which is equivalent.
    // reduces expects a BinaryOperator! we could do a BiFunction but we'd have to write another lambda in the call.
    // by making it return a BinaryOperator, we're good with our usual simple syntax
    static BinaryOperator<String> concatWithSpace = (a, b) -> a + " " + b;

    static Predicate<Integer> isEven = a -> a % 2 == 0;

    static Consumer<Integer> addToSum = a -> sum += a;

    static Function<Integer, Integer> square = a -> a*a;

    static Function<String, Product> toProduct = a -> {
        String[] array = a.split("-");
        array[0] = array[0].trim();
        array[1] = array[1].trim();
        return new Product(array[0], Integer.parseInt(array[1]));
    };

    static Consumer<Product> addToPricesTotal = a -> pricesTotal += a.getPrice();

    public static int getCount() {
        return count;
    }

    public static double getSum() {
        return sum;
    }
}

