package org.generation.italy.examples.oo.lambdaandstreams;

import java.time.LocalDate;
import java.util.function.*;

public class Ex1LambdaLibrary {
    private static int count;
    private static int sum;
    private static int amountSum;

    static Consumer<String> usageCounter = (a) -> count += a.length();
    static Function<String, String> usageTrim = (a) -> a.trim().toLowerCase();
    static BiFunction<String, String, String> usageConcat = (a, b) -> a + " " + b;

    //static Predicate<Integer> isEven = (n) -> n % 2 == 0;
    // & -> and binario
    static Predicate<Integer> isEven = (n) -> (n & 1) == 0;
    /*
    1011
    1101
    ----
    1001
    */
    static Consumer<Integer> addToSum = (a) -> sum += a;
    static Function<Integer, Integer> doubleSquared = (a) -> a * a;

    // static BinaryOperator<Transaction> amountCount = (a, b) -> amountSum += a.getAmount();
}
