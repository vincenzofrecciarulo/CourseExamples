package org.generation.italy.examples.oo.lamdaexpressions;

import java.time.LocalDate;
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
        List<String> productList = Arrays.asList("Portatile - 99.99","Cuffie - 10.00");

        List<Product> products = productList.stream()
                .map(LambdaLibrary.convertToProduct)
                .toList();

        double total = products.stream().mapToDouble(Product::getPrice).sum();
        System.out.println(total);

        List<Transaction> transactionList = Arrays.asList(

              new Transaction(new Guest("Gennaro","Bullo", LocalDate.of(2016,12,9)),
                      120),
                new Transaction(new Guest("Roberto","Bolle", LocalDate.of(1998,10,4)),
                        420),
                new Transaction(new Guest("Marco","Carta", LocalDate.of(2005,5,2)),
                        520),
                new Transaction(new Guest("Gennaro","Bullo", LocalDate.of(2016,12,9)),
                        140)
        );



       Guest toFind = transactionList.getFirst().getGuest();
       int totalAmount = transactionList.stream()
                    .filter(t->t.getGuest().equals(toFind))
                    .mapToInt(t->{
                      if(LambdaLibrary.isMinor.test(toFind)){
                          return t.getAmount() -1;
                      }
                      return t.getAmount();
                    })
                    .sum();
        System.out.println(totalAmount);

       List<Transaction> filteredList = transactionList.stream().filter(t->!t.getGuest().equals(toFind)).toList();


    }

}
