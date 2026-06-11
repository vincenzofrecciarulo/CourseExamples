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
    }

    // Ex8
    static void streamExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = numbers.stream()
                .filter(LambdaLibrary.isEven)
                .peek(LambdaLibrary.addToSum)
                .map(LambdaLibrary.square)
                .collect(Collectors.toList());

        System.out.println("Quadrati dei numeri pari: " + result);
        System.out.println("Somma dei numeri pari: " + LambdaLibrary.getSum());
    }

    public static void main(String[] args) {
        transactionStreamExample();
    }

    // Ex10
    static void transactionStreamExample() {
        Guest mario    = new Guest("Mario",    "Rossi",   java.time.LocalDate.of(1990,  1, 15));
        Guest giovanna = new Guest("Giovanna", "Bianchi", java.time.LocalDate.of(2012,  6, 20)); // minorenne
        Guest luigi    = new Guest("Luigi",    "Verdi",   java.time.LocalDate.of(1985,  3,  8));

        ArrayList<Transaction> transactions = new ArrayList<>(Arrays.asList(
            new Transaction(mario,    120),
            new Transaction(giovanna,  80),
            new Transaction(luigi,    200),
            new Transaction(mario,     50),
            new Transaction(giovanna,  30),
            new Transaction(mario,     90)
        ));

        Guest target = mario;

        // Stream 1: somma degli amount del target, con sconto di 1 se minorenne
        int total = transactions.stream()
                .filter(LambdaLibrary.filterByGuest.apply(target))
                .mapToInt(LambdaLibrary.applyMinorDiscount)
                .sum();

        System.out.println("Totale transazioni di " + target + ": " + total + "€");

        // Stream 2: rimuove le transazioni del target
        List<Transaction> remaining = transactions.stream()
                .filter(LambdaLibrary.filterByGuest.apply(target).negate())
                .collect(Collectors.toList());

        System.out.println("Transazioni rimanenti: " + remaining);
    }

    // Ex9
    static void productStreamExample() {
        List<String> data = Arrays.asList(
            "Portatile - 999.99",
            "Mouse - 29.99",
            "Tastiera - 49.99",
            "Monitor - 349.99"
        );

        List<Product> products = data.stream()
                .map(LambdaLibrary.parseProduct)
                .peek(LambdaLibrary.addPrice)
                .collect(Collectors.toList());

        System.out.println("Prodotti: " + products);
        System.out.println("Totale: " + LambdaLibrary.getTotalPrice());
    }
}

