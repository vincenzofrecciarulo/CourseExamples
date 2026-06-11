package org.generation.italy.examples.oo.lambdaandstreams;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Start {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                " Pippo ",  // spaces are random cause we will trim() em later in our exercise
                " Paperino ",
                " Pluto ",
                " Giovanardi ",
                " Salvini ",
                " Ernesto ",
                " Pappatacio "
        );

        List<Integer> integers = Arrays.asList(
                2, 4, 6, 8, 1, 5, 7, 9
        );

        List<String> strings = Arrays.asList(
                "Prodotto1 - 29431",
                "Prodotto2 - 213",
                "Prodotto3 - 3412",
                "Prodotto4 - 121",
                "Prodotto5 - 29481"
        );
        // this is how we call lambda expressions MANUALLY, if we didn't make an explicit method for it
        // we will never do it like this tho
        // first example
        LambdaLibrary.charCounter.accept(words.get(0));
        System.out.println(LambdaLibrary.getCount());

        // second example
        System.out.println(
                LambdaLibrary.standardize.apply(words.get(0))
        );

        // third example
        System.out.println(
                LambdaLibrary.concatWithSpace.apply(words.get(0), words.get(1))
        );

        // the "correct" way to work with lambdas is by using Streams, which implement them
        // here we try: formatting the strings, counting the letters and concatenating everything in a single string
        // we apply our lambdas we made for this. we put it in a String variable cause it'll return a String
        // we can see it as a way of
       Optional<String> stream = words.stream() // Optional accepts Strings but also nulls. it's a sort of safety measure for Strings
               .map(LambdaLibrary.standardize)  // map uses a Function
               .peek(LambdaLibrary.charCounter) // peek uses a Consumer
               .reduce(LambdaLibrary.concatWithSpace); // reduce uses a BiFunction

        List<Integer> intStream = integers.stream()
                .filter(LambdaLibrary.isEven)
                .peek(LambdaLibrary.addToSum)
                .map(LambdaLibrary.square)
                .toList();

        List<Product> productStream = strings.stream()
                .map(LambdaLibrary.toProduct)
                .peek(LambdaLibrary.addToPricesTotal)
                .toList();

        System.out.println(intStream + " Internal sum: " + LambdaLibrary.getSum());

        System.out.println(productStream);
    }
}
