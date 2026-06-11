package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.function.*;

public class LambdaLibraryExtended {
        private static int count;
        private static int sum;

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

        //crea una lambda Predicate<Integer>isEven che restituisce true se l'Integer è pari o false se è dispari.

        static Predicate<Integer> isEven = a -> (a%2==0 ? true : false);

        //crea una lambda Consumer<Integer> addToSum che aggiunge il valore dell'Integer ad una variabile statica
        // di LambdaLibraryExtended

        static Consumer<Integer> addToSum = a -> sum += a;

        //crea una lambda Function<Integer, Integer> returnSquared che restituisce il quadrato dell'Integer.

        static Function<Integer, Integer> returnSquared = (a) -> a*a;




    }



