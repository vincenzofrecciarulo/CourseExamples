package org.generation.italy.examples.oo.lambdaandstreams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Start {
    static List<String> stringProducts= new ArrayList<>();
    static double sumOfPrices;
    static Guest g3;
    static Guest g2;
    static Guest g1;
    static{
        stringProducts.add("telefono-299.99");
        stringProducts.add("laptop-999.99");
        stringProducts.add("cover-15.5");
        stringProducts.add("headset-34.99");
        g1 = new Guest("Mario", "Rossi", LocalDate.of(1990, 5, 15));
        g2 = new Guest("Luca", "Bianchi", LocalDate.of(2012, 8, 22)); // Minorenne
        g3 = new Guest("Anna", "Verdi", LocalDate.of(1985, 12, 30));

    };
        private static class Product{
            String name;
            double price;
            Product(String name,double price){this.name=name;this.price=price;}
        }
    //strandardizziamo le stringhe, contiamo quante lettere contengono le parole, le concateniamo in una singola stringa
    // ed infine le restituiamo in una sola stringa
    static void main() {
        List<String> words = Arrays.asList(" Pippo ", " Paperino", "Pluto "); //asList metodo statico della classe Arrays
        double totalPrices=0;
        /*Stream
       Ex4
       Scrivere uno Stream che utilizza le lambda dei primi tre esercizi per standardizzare
       le parole sfruttando la lambda dell’esercizio 2, poi conti le lettere effettive con la lambda
       dell’esercizio 1 e infine restituisca la concatenazione utilizzando la lambda dell’esercizio 3
        */
        Optional<String> result = words.stream()
                .map(LambdaLibrary.standardize)
                .peek(LambdaLibrary.usageCounter)
                .reduce(LambdaLibrary.concat);
        System.out.println(" ");
        System.out.println(result);
        /*Ex8
        Scrivere uno Stream che utilizza le lambda degli esercizi 5-7, esso deve:
        1) filtrare i valori tenendo solo i pari
        2) sommarli al contatore statico
        3) elevarli al quadrato
        4) restituire il risultato in una lista
        */
        List<Integer> nums= new ArrayList<>(Arrays.asList(1,2,3,4,5,56,65,34534));
        List<Integer> result2= nums.stream().
                filter(LambdaLibrary.isEven)
                .peek(LambdaLibrary.addToSum)
                .map(LambdaLibrary.powerOfTwo)
                .toList();
        for(Integer i:result2)  IO.println(i.intValue()+", ");
        List<Integer> result3= nums.stream()
                .filter(integer -> integer%2==0)
                .peek(integer->LambdaLibrary.updateSum(integer.intValue()))
                .map(integer -> integer*integer)
                .toList();
        result3.stream().forEach(integer -> IO.println(integer.intValue()));

        /*Dato un ArrayList di String della forma “NomeProdotto - PrezzoDouble”
        (es. “Portatile - 999.99), scrivere uno Stream che:
        Trasforma le String in oggetti di tipo Product
        (che contengono una String productName e un double Price)
        Salva il totale dei prezzi in una variabile
        Restituisce una List<Product> contenente tutti gli oggetti di tipo Prodotto ottenuti
        */
        List<Product> products= stringProducts.stream()
                .map(string ->{
                    String[] dati=string.split("-");
                    return new Product(dati[0].trim(),Double.parseDouble(dati[1].trim()));
                }).peek(product-> sumOfPrices+=product.price)
                .toList();
        /*
        Ex10
        Scrivere uno Stream che:
        Filtra tutte le transazioni di un determinato Guest (identificato dal terzetto name, surname, dateOfBirth)
        Applica uno sconto di 1 se attualmente il Guest è minorenne
        Restituisce la somma di tutti gli amount del Guest
         */
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(g1, 50));
        transactions.add(new Transaction(g2, 15)); // Transazione target (verrà scontata a 14)
        transactions.add(new Transaction(g3, 100));
        transactions.add(new Transaction(g2, 30)); // Seconda transazione target (verrà scontata a 29)
        transactions.add(new Transaction(g1, 25));
        Guest targetGuest = new Guest("Luca", "Bianchi",
                LocalDate.of(2012, 8, 22));

        Optional<Integer> sumOfTransactions= transactions.stream()
                .filter(transaction -> transaction.getGuest().equals(targetGuest))
                .map(transaction -> targetGuest.isUnderage()?
                                                transaction.getAmount()-1: transaction.getAmount())
                .reduce((a,b)->a+b);
        sumOfTransactions.ifPresent(s->IO.println(s));
    }
}
