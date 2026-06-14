package org.generation.italy.examples.lambdaandstreams.exercises;

import com.sun.source.doctree.EscapeTree;
import org.generation.italy.examples.lambdaandstreams.LambdaLibrary;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookStoreOperations {
    /*
fare una serie di funzioni che:
ritorna il numero totale di pagine di tutti i lbri di programmazione
ritorna il massimo rating mai ricevuto tra i libri di un genere che viene dato in input
 */
    /*
    ritorna una lista di tutti i titoli dei libri List<String> getTitles(List<Book> books)
     */

    public static List<String> getTitles(List<Book> books) {
        return books.stream().map(Book::getTitle).filter(Objects::nonNull).collect(Collectors.toList());
    }

    /*
    ritorna i titoli di tutti i libri che costano meno di 20
     */
    public static List<String> getBelowMaxPrice(List<Book> books, double maxPrice){
        return books.stream().filter(book -> book.getPrice()<maxPrice).map(Book::getTitle).collect(Collectors.toList());
    }

    /*
    ritorna il numero di libri che hanno come genere "Programming"
     */

    public static int numeroDiLibriDiUnGenre(List<Book> books, String genre){
        return (int) books.stream().filter(book -> book.getGenre().equals(genre)).count();
    }

    /*
    ritorna tutti i libri ordinati pre prezzo ascendente
     */
    public static List<String> putInAscendinOrder(List<Book> books){
        return books.stream().sorted(Comparator.comparingDouble(Book::getPrice)).map(Book::getTitle).collect(Collectors.toList());
    }

    /*
    ritorna tutti i titoli dei libri ordinati per data di pubblicazione (prima i piu recenti)
     */

    public static List<String> publicationOrder(List<Book> books){
        return books.stream().sorted(Comparator.comparingInt(Book::getPublicationYear).reversed()).map(Book::getTitle).collect(Collectors.toList());
    }

    /*
    ritorna true se tutti i libri hanno un rating superiore a 4
     */

    public static boolean voteAbove(List<Book> books, int vote){
        return books.stream().allMatch(book -> book.getRating()>vote);
    }

    /*
    ritorna il libro piu costoso
     */

    public static Optional<Book> mostExpensive(List<Book> books){
        return books.stream().max(Comparator.comparingDouble(Book::getPrice);
    }

    /*
    ritorna true se almeno un libro ha almeno 500 pagine
     */

    public static boolean atLeastOneAbovePrice(List<Book> books, double price){
        return books.stream().anyMatch(book -> book.getPrice()>price);
    }

    /*
    ritorna l autore del primo libro per cui e disponibile un ebook
     */
    public static Optional<String> firstAuthorWithEBook(List<Book> books){
        return books.stream().filter(Book::isEbookAvailable).map(Book::getAuthor).findFirst();
    }


}
