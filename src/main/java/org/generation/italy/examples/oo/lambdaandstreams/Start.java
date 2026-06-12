package org.generation.italy.examples.oo.lambdaandstreams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.generation.italy.examples.oo.lambdaandstreams.LambdaLibrary.*;

public class Start {
    static void main() {
//        List<String> words = Arrays.asList("pippo", "paperino", "pluto");
//        LambdaLibrary.charCounter.accept(words.get(0));
//        System.out.println(LambdaLibrary.getCount());
//        System.out.println(LambdaLibrary.standardize.apply(words.get(0)));
//        System.out.println(LambdaLibrary.concat.apply(words.get(0), words.get(1)));
//
//        Optional<String> result = words.stream()
//                .map(LambdaLibrary.standardize)
//                .peek(LambdaLibrary.charCounter)
//                .reduce((s1, s2) -> LambdaLibrary.concat.apply(s1, s2));
//        System.out.println(" ");
//        System.out.println(result);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20);
        List<Integer> result = numbers.stream()
                .filter(isEven)
                .peek(addToSum)
                .map(quadrato)
                .toList();

        System.out.println("Lista risultante: " + result);
        System.out.println("Somma nel contatore: " + getCount());

        List<String> input = List.of(
                "Portatile - 999.99",
                "Mouse - 29.99",
                "Tastiera - 59.99"
        );

        double[] totalPrice = {0.0};

        List<Product> products = input.stream()
                .map(s -> s.split(" - "))                   // 1. split su " - "
                .map(parts -> new Product(
                        parts[0].trim(),
                        Double.parseDouble(parts[1].trim())))           // 2. crea oggetto Product
                .peek(p -> totalPrice[0] += p.getPrice())       // 3. accumula il totale
                .toList();                                              // 4. raccoglie in List

        System.out.println("Totale: " + totalPrice[0]);
        System.out.println("Prodotti: " + products);


    }
}
