package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.function.*;

public class LambdaLibrary {
    public static int getCount() {
        return count;
    }

    private static int count;
    static Consumer<String> charCounter =(String a) ->{
        count +=a.length();
    };
    static Function<String, String> standardize = (a) ->{
        a=a.trim();
        a=a.toLowerCase();
        return a;
    };



    public static Integer number = 8;
    static BinaryOperator<String> concatenateWords = (String a, String b) -> a+ " " +b;

    static  Predicate<Integer> isEven = (Integer a) -> a%2==0;
    static Consumer<Integer> addToSum = (Integer a) ->  number+= a;
    static Function<Integer, Integer> square= (Integer a) -> a*a;
}
