package org.generation.italy.examples.oo.lambdaexercises;

import java.net.SocketOption;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
/*Creare una classe LambdaLibrary con al suo interno le seguenti lamba accessibili staticamente:
Ex1
una lambda Consumer<String> usageCounter che conta le lettere di una String e aumenta un contatore statico privato
all’interno di LambdaLibrary di quel numero
Ex2
una lambda Function<String, String> che restituisce la String su cui è stata chiamata senza spazi bianchi prima e dopo
(trim) e tutta in minuscolo
Ex3
Una lambda BinaryOperator<String> che restituisce la concatenazione delle due String con uno spazio in mezzo
Stream
Ex4
Scrivere uno Stream che utilizza le lambda dei primi tre esercizi per standardizzare le parole sfruttando la lambda
dell’esercizio 2, poi conti le lettere effet
tive con la lambda dell’esercizio 1 e infine restituisca la concatenazione utilizzando la lambda dell’esercizio 3
*/

/*Ampliare la classe LambdaLibrary aggiungendo al suo interno le seguenti lamba accessibili staticamente:
Ex5
una lambda Predicate<Integer> isEven che restituisce true se l’Integer è pari o false se è dispari

Ex6
una lambda Consumer<Integer> addToSum che aggiunge il valore dell’Integer a una variabile statica di LambdaLibrary

Ex7
Una lambda Function<Integer, Integer> che restituisce il quadrato dell’Integer


Stream
Ex8
Scrivere uno Stream che utilizza le lambda degli esercizi 5-7, esso deve:
1) filtrare i valori tenendo solo i pari
2) sommarli al contatore statico
3) elevarli al quadrato
4) restituire il risultato in una lista

Successivamente il programma deve mostrare il risultato




Ex9
Dato un ArrayList di String della forma “NomeProdotto - PrezzoDouble” (es. “Portatile - 999.99), scrivere uno Stream che:
Trasforma le String in oggetti di tipo Product (che contengono una String productName e un double Price)
Salva il totale dei prezzi in una variabile
Restituisce una List<Product> contenente tutti gli oggetti di tipo Prodotto ottenuti




Ex10
Dato un ArrayList di Transaction così definite:
public class Transaction {
	Guest g;
	Int amount; //prezzo pagato nella transazione
	//eventuali altre variabili e/o funzioni a vostra discrezione
}
Contententi un Guest così definito:
public class Guest {
	String name, surname;
	LocalDate dateOfBirth;
	//eventuali altre variabili e/o funzioni a vostra discrezione
},

Scrivere uno Stream che:
Filtra tutte le transazioni di un determinato Guest (identificato dal terzetto name, surname, dateOfBirth)
Applica uno sconto di 1 se attualmente il Guest è minorenne
Restituisce la somma di tutti gli amount del Guest

Poi scrivere un secondo Stream che rimuove le transazioni di quel Guest ed eseguirli entrambi
*/


public class Start {
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
        System.out.println(LambdaLibrary.square.apply(numbers.get(2)));
        //Stream
        //Ex8
        //Scrivere uno Stream che utilizza le lambda degli esercizi 5-7, esso deve:
        //1) filtrare i valori tenendo solo i pari
        //2) sommarli al contatore statico
        //3) elevarli al quadrato
        //4) restituire il risultato in una lista
        //
        //Successivamente il programma deve mostrare il risultato
        List<Integer> result1 = numbers.stream().filter(LambdaLibrary.isEven).peek(LambdaLibrary.addToSum)
                .map(LambdaLibrary.square)
                .toList();
        IO.println(result1);

    }
}
