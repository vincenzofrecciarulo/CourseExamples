package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Start {
    static void main() {
        //factory, metodo che wrappa il costruttore
        List<String> words = Arrays.asList(" Pippo " , " Paperino ", " Pluto ");
        //LambdaLibrary.charCounter(words.get(0));
        LambdaLibrary.charCounter.accept(words.get(0));
        System.out.println(LambdaLibrary.getCount());
        System.out.println(LambdaLibrary.standardize.apply(words.get(0)));
        System.out.println(LambdaLibrary.concat.apply(words.get(0), words.get(1)));


        // 1. standardizziamo le stringhe con la seconda lambda
        // 2. Contiamo le lettere effettive
        // 3. Restituire la concatenazione delle stringhe
        // 4. Restituiamo in un singolo valore (result String)
        Optional<String> result = words.stream()
                .map(LambdaLibrary.standardize)
                .peek(LambdaLibrary.charCounter)
                .reduce(LambdaLibrary.concat::apply);
        System.out.println(" ");
        System.out.println(result);
    }
}
