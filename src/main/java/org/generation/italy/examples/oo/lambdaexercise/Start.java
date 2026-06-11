package org.generation.italy.examples.oo.lambdaexercise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Start {

    static void main() {
    /*
    Scrivere uno Stream che utilizza le lambda dei primi tre esercizi
    per standardizzare le parole sfruttando la lambda dell’esercizio 2,
    poi conti le lettere effettive con la lambda dell’esercizio 1
    e infine restituisca la concatenazione utilizzando la lambda dell’esercizio 3
     */
        List<String> gods =Arrays.asList("Diocane ", " DioPorco ", " porcaMadonna ");

        Optional<String> result = gods.stream()
                .map(LambdaLibrary.usageTrim)
                .peek(LambdaLibrary.usageCounter)
                .reduce(LambdaLibrary.usageConcat);

        IO.println(result);


    /*
    Scrivere uno Stream che utilizza le lambda degli esercizi 5-7, esso deve:
    1) filtrare i valori tenendo solo i pari
    2) sommarli al contatore statico
    3) elevarli al quadrato
    4) restituire il risultato in una lista
    Successivamente il programma deve mostrare il risultato
     */

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);

        List<Integer> evenNums = nums.stream()
                .filter(LambdaLibrary.isEven)
                .map(LambdaLibrary.squared)
                .peek(LambdaLibrary.addToSum)
                .toList();

        IO.println(evenNums);


    /*
    Dato un ArrayList di String della forma “NomeProdotto - PrezzoDouble” (es. “Portatile - 999.99), scrivere uno Stream che:
    Trasforma le String in oggetti di tipo Product (che contengono una String productName e un double Price)
    1- fai lo split e trim " - "
    2- Trasforma le String in oggetti di tipo Product (che contengono una String productName e un double Price)
    Salva il totale dei prezzi in una variabile
    Restituisce una List<Product> contenente tutti gli oggetti di tipo Prodotto ottenuti
     */

        List<String> products =Arrays.asList("Portatile - 999.99", "Telefono - 599.99", "Tablet - 349.99");

        List<Product> productsList = products.stream()
                .map((s) -> {
                    String[] parse = s.split(" - ");
                    return  new Product(parse[0], Double.parseDouble(parse[1]));
                }).toList();

        double total = productsList.stream().mapToDouble(Product::getPrice).sum();

        IO.println(productsList);
        IO.println(total);

        /*
    Dato un ArrayList di Transaction così definite:
    Scrivere uno Stream che:
    Filtra tutte le transazioni di un determinato Guest (identificato dal terzetto name, surname, dateOfBirth)
    Applica uno sconto di 1€ se attualmente il Guest è minorenne (es. 15€ viene scontato a 14€)
    Restituisce la somma di tutti gli amount del Guest
    Poi scrivere un secondo Stream che rimuove le transazioni di quel Guest ed eseguirli entrambi
         */
    }
}
