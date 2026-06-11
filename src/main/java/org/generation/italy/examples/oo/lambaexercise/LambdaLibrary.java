package org.generation.italy.examples.oo.lambaexercise;

import java.util.function.*;

public class LambdaLibrary {

    //una lambda Consumer<String> usageCounter che conta le lettere
    // di una String e aumenta un contatore statico privato all’interno
    // di LambdaLibrary di quel numero
        private static int counter;
        private static int sum;

       static Consumer<String> usageCounter = (s) -> counter += s.length();

    //  una lambda Function<String, String> che restituisce la String
    //  su cui è stata chiamata senza spazi bianchi prima e dopo (trim)
    //  e tutta in minuscolo
       static Function<String, String> usageTrim = (s) ->s.trim().toLowerCase();

    // Una lambda BiFunction<String, String, String> che restituisce
    // la concatenazione delle due String con uno spazio in mezzo

       static BinaryOperator<String> usageConcat = (s, s2) -> s + " " + s2;

    //una lambda Predicate<Integer> isEven che restituisce true
    // se l’Integer è pari o false se è dispari

        static Predicate<Integer> isEven = (i) -> i % 2 == 0;

    //una lambda Consumer<Integer> addToSum che aggiunge il
    // valore dell’Integer a una variabile statica di LambdaLibrary

    static Consumer<Integer> addToSum = (i) -> sum += i;

    //Una lambda Function<Integer, Integer> che restituisce
    // il quadrato dell’Integer

        static Function<Integer, Integer> q= (i) -> i*i;


}
