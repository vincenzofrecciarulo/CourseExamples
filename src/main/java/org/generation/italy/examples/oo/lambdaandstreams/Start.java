package org.generation.italy.examples.oo.lambdaandstreams;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;




public class Start {
    static void main() {

        Integer a =10;
    List<String> words = Arrays.asList(" Pippo","Paperino","Pluto");
   // LambdaLibrary.charCounter(words.get(0));
    LambdaLibrary.charCounter.accept(words.get(0));
    System.out.println(LambdaLibrary.getCount());
    System.out.println(LambdaLibrary.standardize.apply(words.get(0)));
    System.out.println(LambdaLibrary.concatenateWords.apply(words.get(0), words.get(1)));
    Optional <String> result = words.stream()
            .map(LambdaLibrary.standardize)
            .peek(LambdaLibrary.charCounter)
            .reduce(LambdaLibrary.concatenateWords);
        System.out.println(result);
        System.out.println(LambdaLibrary.isEven.test(a));
        LambdaLibrary.addToSum.accept(a);
        System.out.println(LambdaLibrary.number);
        System.out.println(LambdaLibrary.square.apply(a));
        List<Integer> exNumbers = Arrays.asList(1,27,48,61,73,128);
        List<Integer> resultSquare = exNumbers.stream()
                .filter(LambdaLibrary.isEven)
                .peek(LambdaLibrary.addToSum)
                .map(LambdaLibrary.square)
                .toList();
        System.out.println(resultSquare);
    }
}
