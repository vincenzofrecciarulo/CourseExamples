package org.generation.italy.examples.oo.lambaexercise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Start {

   //Scrivere uno Stream che utilizza le lambda dei primi tre
    // esercizi per standardizzare le parole sfruttando la lambda
    // dell’esercizio 2, poi conti le lettere effettive con la
    // lambda dell’esercizio 1 e infine restituisca la concatenazione
    // utilizzando la lambda dell’esercizio 3

    static void main() {
        List<String> names = Arrays.asList("Marco", " Luca", " Lucarinho ");

        Optional<String> result = names.stream()
                .map(LambdaLibrary.usageTrim)
                .peek(LambdaLibrary.usageCounter)
                .reduce(LambdaLibrary.usageConcat);

        System.out.println(result);

      /*  Scrivere uno Stream che utilizza le lambda degli esercizi 5-7, esso deve:
        1) filtrare i valori tenendo solo i pari
        2) sommarli al contatore statico
        3) elevarli al quadrato
        4) restituire il risultato in una lista
        Successivamente il programma deve mostrare il risultato*/

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> result1 = nums.stream()
                .filter(LambdaLibrary.isEven)
                .peek(LambdaLibrary.addToSum)
                .map(LambdaLibrary.q)
                .toList();

        System.out.println(result1);

        //Ex9
        //Dato un ArrayList di String della forma
        // “NomeProdotto - PrezzoDouble” (es. “Portatile - 999.99),
        // scrivere uno Stream che:
        //Trasforma le String in oggetti di tipo Product
        // (che contengono una String productName e un double Price)
        //Salva il totale dei prezzi in una variabile
        //Restituisce una List<Product> contenente tutti gli oggetti
        // di tipo Prodotto ottenuti

        List<String> products = Arrays.asList("Portatile - 999.99", "Telefono - 199.98");
        double[] total = {0};  // array per poter modificare dentro lambda

        List<Product> productList = products.stream()
                .map(s -> s.split(" - "))                              // 1) splitta in [nome, prezzo]
                .filter(arr -> arr.length == 2)                        // 2) scarta righe malformate
                .map(arr -> new Product(arr[0], Double.parseDouble(arr[1])))  // 3) crea oggetto Product
                .peek(p -> total[0] += p.getPrice())                   // 4) accumula il totale
                .collect(Collectors.toList());                         // 5) raccogli in lista

        System.out.println(productList);
        System.out.println("Totale: " + total[0]);

    }
}
