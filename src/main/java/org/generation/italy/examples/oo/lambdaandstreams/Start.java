package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

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

    //devo scrivere uno Stream che deve filtrare i valori tenendo solo i numeri pari, sommarli al contatore statico,
    //elevarli al quadrato e restituire il risultato in una lista
        List<Integer> numbers = Arrays.asList(2, 5, 8, 11, 12, 15, 16, 20);
//        System.out.println(LambdaLibrary.isEven);
//        System.out.println(LambdaLibrary.addToSum);
//        System.out.println(LambdaLibrary.square);
        List<Integer> finalNumber = numbers.stream()
                .filter(LambdaLibrary.isEven)
                .peek(LambdaLibrary.addToSum)
                .map(LambdaLibrary.square)
                .toList();
        System.out.println("Il risultato: " + finalNumber);
        System.out.println("Somma dei pari: " + LambdaLibrary.sum);

        List<Product> products = new ArrayList<>();
        Product p1 = new Product("dentifricio", 1.99);
        Product p2 = new Product("spazzolino", 1.50);
        Product p3 = new Product("rossetto", 2.99);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        
    }
}
