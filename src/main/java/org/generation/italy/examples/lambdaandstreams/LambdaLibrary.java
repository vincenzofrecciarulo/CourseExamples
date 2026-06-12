package org.generation.italy.examples.lambdaandstreams;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLibrary {
    private static int count;
    private static int sum;
    static Consumer<String> usageCounter = (a) -> count += a.length();

    static Function<String, String> trimming = (a) -> {
        String b = a.trim();
        b = b.toLowerCase();
        return b;
    };

    static BinaryOperator<String> concat = (a,b) -> a + " " + b;

    static Predicate<Integer> isEven = (a) -> {
        if (a%2==0){
            return true;
        }
        return false;
    };

    //una lambda Consumer<Integer> addToSum che aggiunge il valore dell’Integer a una variabile statica di LambdaLibrary
    static Consumer<Integer> addToSum = (a) -> sum += a;

    //Una lambda Function<Integer, Integer> che restituisce il quadrato dell’Integer
    static BinaryOperator<Integer> doSum = (a1,a2) -> a1+a2;

    public static int getCount(){
        return count;
    }

    public static int getSum() {
        return sum;
    }
}