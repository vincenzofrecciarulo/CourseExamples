package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.function.*;

public class LambdaLibrary {
    private static int count;
    private static int sum;
//    una lambda Function<String, String> che restituisce la String
//    su cui è stata chiamata senza spazi bianchi prima e dopo (trim) e tutta in minuscolo
    static Function<String, String> standardize = a -> a.trim().toLowerCase();
    //una lambda Consumer<String> usageCounter che conta le lettere di una String
    //e aumenta un contatore statico privato all’interno di LambdaLibrary di quel numero
    static Consumer<String> usageCounter = (a) -> count += a.length();

//      METODO 2: return a.trim().toLowerCase()
//      METODO 3:
//      a = a.trim();
//      a = a.toLowerCase();
//      return a;
//    };
    //Es3: Una lambda BiFunction<String, String, String>
    // che restituisce la concatenazione delle due String con uno spazio in mezzo
    static BinaryOperator<String> concat = (a, b) -> a + " " + b;
    /*Ex5
     una lambda Predicate<Integer> isEven che restituisce true se l’Integer è
     pari o false se è dispari*/
    static Predicate<Integer> isEven = i -> i % 2 == 0;
    /*
    * Ex6 una lambda Consumer<Integer> addToSum che aggiunge
    *  il valore dell’Integer a una variabile statica di LambdaLibrary
    * */
    static Consumer<Integer> addToSum= integer -> sum+=integer;
    /*
    Ex7
    Una lambda Function<Integer, Integer> che restituisce il quadrato dell’Integer
    */
    static Function<Integer,Integer> powerOfTwo= integer -> integer*integer;
    public static void updateSum(int i) {sum+=i;}
    public static int getCount()         {return count;}
}
