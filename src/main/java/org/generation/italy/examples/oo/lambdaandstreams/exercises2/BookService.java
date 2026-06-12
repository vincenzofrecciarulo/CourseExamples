package org.generation.italy.examples.oo.lambdaandstreams.exercises2;

import java.util.Comparator;
import java.util.List;

public class BookService {
    // ritorna una lista di tutti i titoli dei libri List<String> getTitles(List<Book> books)
    public static List<String> getTitles(List<Book> books) {
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
}
