package org.generation.italy.examples.lambdaandstreams;

import org.generation.italy.examples.lambdaandstreams.LambdaLibrary;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LambdaExercise {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("      Pippp", "Paperino    ", " Pluto  ");
        List<Integer> numbers = Arrays.asList(1, 17, 3, 24);
        LambdaLibrary.usageCounter.accept(words.get(0));
        System.out.println(LambdaLibrary.getCount());
        System.out.println(LambdaLibrary.trimming.apply(words.get(0)));
        System.out.println(LambdaLibrary.concat.apply(words.get(0), words.get(1)));
        Optional<String> result = words.stream().map(LambdaLibrary.trimming).peek(LambdaLibrary.usageCounter).reduce(LambdaLibrary.concat);
        System.out.print(" ");
        System.out.println(result);
        System.out.println(LambdaLibrary.isEven.test(numbers.get(3)));
        //LambdaLibrary.addToSum.accept(numbers.get(0));
        //LambdaLibrary.addToSum.accept(numbers.get(1));
        System.out.println(LambdaLibrary.getSum());
        System.out.println(LambdaLibrary.doSum.apply(numbers.get(2), numbers.get(2)));
        //Stream
        //Ex8
        //Scrivere uno Stream che utilizza le lambda degli esercizi 5-7, esso deve:
        //1) filtrare i valori tenendo solo i pari
        //2) sommarli al contatore statico
        //3) elevarli al quadrato
        //4) restituire il risultato in una lista
        //
        //Successivamente il programma deve mostrare il risultato
        Optional<Integer> result1 = numbers.stream().filter(LambdaLibrary.isEven).peek(LambdaLibrary.addToSum)
                .map(x -> x*x)
                .reduce(LambdaLibrary.doSum);
        result1.ifPresent(IO::println);

    }
}
