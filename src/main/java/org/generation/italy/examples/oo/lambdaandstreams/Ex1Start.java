package org.generation.italy.examples.oo.lambdaandstreams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ex1Start {
    static void main() {
        List<String> names = Arrays.asList(" Belveth ", " Kayn ", " briar ");
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 8);

        List<String> products = Arrays.asList("Portatile - 199.99 ", "Iphone 17Pro Max - 1300.00");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(new Guest("Luca", "Divino", LocalDate.of(2025, 01, 20)), 129),
                new Transaction(new Guest("Luca", "Divino", LocalDate.of(2025, 01, 20)), 15),
                new Transaction(new Guest("Francesca", "Villa", LocalDate.of(1996, 02, 25)), 15)
        );

        Optional<String> result = names.stream()
                .map(Ex1LambdaLibrary.usageTrim)
                .peek(Ex1LambdaLibrary.usageCounter)
                .reduce(Ex1LambdaLibrary.usageConcat::apply);

        System.out.println(" ");
        System.out.println(result);


      /*  Scrivere uno Stream che utilizza le lambda degli esercizi 5-7, esso deve:
        1) filtrare i valori tenendo solo i pari
        2) sommarli al contatore statico
        3) elevarli al quadrato
        4) restituire il risultato in una lista

        Successivamente il programma deve mostrare il risultato*/
        List<Integer> resultInteger = numbers.stream()
                .filter(Ex1LambdaLibrary.isEven)
                .map(Ex1LambdaLibrary.doubleSquared)
                .peek(Ex1LambdaLibrary.addToSum)
                .toList();

        System.out.println(" ");
        System.out.println(resultInteger);

        // EX3
        List<Product> productList = products.stream()
                .map((a) -> {
                    String[] parts = a.split(" - ");
                    return new Product(parts[0], Double.parseDouble(parts[1]));
                })
                .toList();

        double tot = productList.stream()
                .mapToDouble(p -> p.getPrice())
                .sum();

        System.out.println(productList);

        /* Scrivere uno Stream che:
        1. Filtra tutte le transazioni di un determinato Guest (identificato dal terzetto name, surname, dateOfBirth)
        2. Applica uno sconto di 1€ se attualmente il Guest è minorenne (es. 15€ viene scontato a 14€)
        3. Restituisce la somma di tutti gli amount del Guest */


        TransactionAction transactionAction = new TransactionService();
        List<Transaction> x = transactionAction.getGuest(new Guest("Luca", "Divino", LocalDate.of(2025, 01, 20)), transactionList);

        System.out.println(x);
        System.out.println(transactionAction.sum(x));

    }
}
