package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Start {
    //strandardizziamo le stringhe, contiamo quante lettere contengono le parole, le concateniamo in una singola stringa
    // ed infine le restituiamo in una sola stringa
    static void main() {
        List<String> words = Arrays.asList(" Pippo ", " Paperino", "Pluto "); //asList metodo statico della classe Arrays
        LambdaLibrary.charCounter.accept(words.get(0));
        System.out.println(LambdaLibrary.getCount());
        System.out.println(LambdaLibrary.standardize.apply(words.get(0)));
        System.out.println(LambdaLibrary.concat.apply(words.get(0), words.get(1)));
        Optional<String> result = words.stream()
                .map(LambdaLibrary.standardize)
                .peek(LambdaLibrary.charCounter)
                .reduce(LambdaLibrary.concat);
        System.out.println(" ");
        System.out.println(result);
    }
}
