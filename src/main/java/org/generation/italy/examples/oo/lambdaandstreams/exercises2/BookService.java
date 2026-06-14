package org.generation.italy.examples.oo.lambdaandstreams.exercises2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookService {
    // ritorna una lista di tutti i titoli dei libri List<String> getTitles(List<Book> books)
    public static List<String> getAllTitles(List<Book> books) {
        return books.stream()
                .map(Book::getTitle)
                .toList();
    }

    // ritorna i titoli di tutti i libri che costano meno di 20
    public static List<String> getTitlesUnder20(List<Book> books) {
        return books.stream()
                .filter(b -> b.getPrice() < 20)
                .map(Book::getTitle)
                .toList();
    }

    // ritorna il numero di libri che hanno come genere "Programming"
    public static int getNumberByGenre(List<Book> books, String genre) {
        return (int)books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .count();
    }

    // ritorna tutti i libri ordinati pre prezzo ascendente
    public static List<Book> getByAscendingPrice(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .toList();
    }

    // ritorna tutti i titoli dei libri ordinati per data di pubblicazione (prima i piu recenti)
    public static List<String> getTitlesByDescendingPublicationYear(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getPublicationYear).reversed())
                .map(Book::getTitle)
                .toList();
    }

    // ritorna il libro più costoso
    public static Book getMostExpensive(List<Book> books) {
        return books.stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);
    }

    // ritorna true se tutti i libri hanno un rating superiore a 4
    public static boolean allMinimumRating(List<Book> books, double rating) {
        return books.stream()
                .allMatch(b -> b.getRating() >= rating);
    }

    // ritorna true se almeno un libro ha almeno 500 pagine
    public static boolean anyMinimumPages(List<Book> books, int pages) {
        return books.stream()
                .anyMatch(b -> b.getPages() >= 500);
    }

    // ritorna l'autore del primo libro per cui è disponibile un ebook
    public static String getFirstAvailableEbookAuthor(List<Book> books) {
        return books.stream()
                .filter(Book::isEbookAvailable)
                .map(Book::getAuthor)
                .toList()
                .getFirst();
    }

    // ritorna il numero totale di pagine di tutti i lbri di programmazione
    public static int getNumberOfPagesByGenre(List<Book> books, String genre) {
        return books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .mapToInt(Book::getPages)
                .sum();
    }

    // ritorna il massimo rating mai ricevuto tra i libri di un genere che viene dato in input
    public static double getMaxRatingByGenre(List<Book> books, String genre) {
        return books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .mapToDouble(Book::getRating)
                .max()
                .orElse(0);
    }

    // ritorna una stringa composta da tutti i titoli dei libri separati da una virgola
    public static String getAllTitlesSeparatedByComma(List<Book> books) {
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(", "));
    }

    // ritorna il titolo più lungo di tutti i libri calcolandolo tramite una reduce
    public static String getLongestTitle(List<Book> books) {
        return books.stream()
                .map(Book::getTitle)
                // in caso di pareggio, prendiamo l'ultimo
                .reduce((t1, t2) -> t1.length() >= t2.length() ? t1 : t2)
                .orElse("");
    }

    // ritorna una mappa in cui la chiave è il genere e il valore la lista di tutti i libri in quel genere
    public static Map<String, List<Book>> getMapAllBooksByGenre(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre)); // crea una Map in cui i valori sono List<T> di default
    }

    // ritorna un mappa in cui la chiave è il genere e il valore il libro piu costoso in quel genere
    public static Map<String, Book> getMapPriciestBookByGenre(List<Book> books) {
        return books.stream()
                .collect(Collectors.toMap(
                        Book::getGenre,       // genere come key
                        Function.identity(), // un singolo oggetto per key
                        // con questa merge function gestiamo i conflitti. ogni libro con lo stesso genere verrà sostituito o meno in base questa condizione
                        (b1, b2) -> b1.getPrice() >= b2.getPrice() ? b1 : b2
                ));
    }

    // ritorna la lista dei titoli dei tre libri piu costosi, ma ignorando il piu costoso
    public static List<Book> getSecondAndThirdPriciestBooks(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice).reversed())
                .skip(1)
                .limit(2)
                .toList();
    }
}
