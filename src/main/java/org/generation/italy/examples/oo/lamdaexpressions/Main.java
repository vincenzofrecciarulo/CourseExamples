package org.generation.italy.examples.oo.lamdaexpressions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static void main() {
        List<String> parole =Arrays.asList("Pippo","pluto"," Paperinik ");
        LambdaLibrary.usageCounter.accept(parole.get(0));
        IO.println(LambdaLibrary.getCount());
        String formatted = LambdaLibrary.format.apply(parole.get(2));
        System.out.println(formatted);
        String dueParole = LambdaLibrary.concatString.apply(parole.get(0),parole.get(1));
        System.out.println(dueParole);
        Optional<String> result= parole.stream()
                .map(LambdaLibrary.format)
                .peek(LambdaLibrary.usageCounter)
                .reduce(LambdaLibrary.concatString);
        System.out.println(result);
        Integer numero1 = 2;
        boolean isEven = LambdaLibrary.isEven.test(numero1);
        System.out.println(isEven);
        Integer toAdd = 20;
        LambdaLibrary.addToSum.accept(toAdd);
        IO.println(LambdaLibrary.getSum());
        Integer toSquare = 3;
        IO.println(LambdaLibrary.square.apply(toSquare));
        List<Integer> numeri = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> risultato = numeri.stream()
                .filter(LambdaLibrary.isEven)
                .peek(LambdaLibrary.addToSum)
                .map(LambdaLibrary.square)
                .collect(Collectors.toList());

        for (Integer i : risultato){
            IO.println(i);
        }
        Map<String,Double> products = new HashMap<>();
        products.put("Portadile",999.99);
        products.put("Cuffie",10.0);




    }

}
