package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaLibrary {
    static private int count;
    static Consumer<String> charCounter = (a) -> count += a.length();
    // due tipi generici: parametro (input), Corpo (output) -> ha bisogno di return!
/*    static Function<String, String> standardize = (a) -> {
        //togliere gli spazi (trim())
        a = a.trim().toLowerCase();
        return a;
    };  */
    static Function<String, String> standardize = (a) -> a.trim().toLowerCase();
    // Restituire la concatenazione delle stringhe ma con uno spazio in mezzo
    static BiFunction<String, String, String> concat = (a, b) -> a + " " + b;









    public static int getCount() {
        return count;
    }





}
