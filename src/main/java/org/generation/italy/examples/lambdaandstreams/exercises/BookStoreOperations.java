package org.generation.italy.examples.lambdaandstreams.exercises;

import com.sun.source.doctree.EscapeTree;
import org.generation.italy.examples.lambdaandstreams.LambdaLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookStoreOperations {
    /*
fare una serie di funzioni che:
ritorna tutti i titoli dei libri ordinati per data di pubblicazione (prima i piu recenti)
rirtorna il libro piu costoso
ritorna true se tutti i libri hanno un rating superiore a 4
ritorna true se almeno un libro ha almeno 500 pagine
ritorna l autore del primo libro per cui e disponibile un ebook
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
    ritorna tutti i libri ordinati pre prezzo ascencente
     */


}
