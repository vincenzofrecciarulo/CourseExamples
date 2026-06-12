package org.generation.italy.examples.oo.lamdaexpressions;
/*
Creare una classe LambdaLibrary con al suo interno le seguenti lamba accessibili staticamente:
Ex1
una lambda Consumer<String> usageCounter che conta le lettere di una String e aumenta
un contatore statico privato
 all’interno di LambdaLibrary di quel numero

 Ex2
una lambda Function<String, String> che restituisce la String su cui è stata chiamata senza spazi
 bianchi prima e dopo (trim) e tutta in minuscolo

Ex3
Una lambda BiFunction<String, String, String> che restituisce la concatenazione delle due String
 con uno spazio in mezzo

Stream
Ex4
Scrivere uno Stream che utilizza le lambda dei primi tre esercizi per standardizzare
le parole sfruttando la lambda dell’esercizio 2, poi conti le lettere effettive con la lambda
dell’esercizio 1 e infine restituisca la concatenazione utilizzando la lambda dell’esercizio 3

Ex5
una lambda Predicate<Integer> isEven che restituisce true se l’Integer è pari o false se è dispari

Ex6
una lambda Consumer<Integer> addToSum che aggiunge il valore dell’Integer a una variabile statica
di LambdaLibrary

Ex7
Una lambda Function<Integer, Integer> che restituisce il quadrato dell’Integer

Stream
Ex8
Scrivere uno Stream che utilizza le lambda degli esercizi 5-7, esso deve:
1) filtrare i valori tenendo solo i pari
2) sommarli al contatore statico
3) elevarli al quadrato
4) restituire il risultato in una lista

Ex9
Dato un ArrayList di String della forma “NomeProdotto - PrezzoDouble” (es. “Portatile - 999.99”),
 scrivere uno Stream che:
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
Contenenti un Guest così definito:
public class Guest {
	String name, surname;
	LocalDate dateOfBirth;
	//eventuali altre variabili e/o funzioni a vostra discrezione
},

Scrivere uno Stream che:
Filtra tutte le transazioni di un determinato Guest (identificato dal terzetto name, surname, dateOfBirth)
Applica uno sconto di 1€ se attualmente il Guest è minorenne (es. 15€ viene scontato a 14€)
Restituisce la somma di tutti gli amount del Guest

Poi scrivere un secondo Stream che rimuove le transazioni di quel Guest ed eseguirli entrambi




 */

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import static java.lang.Double.parseDouble;

public class LambdaLibrary {
  private static int count;
  private static int sum;
  static Consumer<String> usageCounter = (a)-> count+=a.length();

    public static int getSum() {
        return sum;
    }

    public static int getCount() {
        return count;
    }

    static Function<String,String> format = (a)->a.trim().toLowerCase();
    static BinaryOperator<String> concatString = (a,b)-> a+ " "+b;
    static Predicate<Integer> isEven = (a)-> a % 2 ==0;
    static Consumer<Integer> addToSum = (a)-> sum += a;
    static Function<Integer,Integer> square = (a)-> a*a;
    static Function<String,Product> convertToProduct = (s->{
       String[] split = s.split("-");
       return  new Product(split[0],parseDouble(split[1]));
    });

}
