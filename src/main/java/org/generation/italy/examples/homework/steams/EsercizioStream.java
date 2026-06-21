package org.generation.italy.examples.homework.steams;

import java.util.*;
import java.util.stream.Collectors;

public class EsercizioStream {
    /*
    data una classe come

        public class Book(
            String title,
            String author,
            String genre,
            int publicationYear,
            double price,
            int pages,
            double rating,
            boolean ebookAvailable) {
        }

        e una lista di book :

        List<Book> books = List.of(
            new Book("The Hobbit", "Tolkien", "Fantasy", 1937, 14.90, 310, 4.8, true),
            new Book("Dune", "Herbert", "Science Fiction", 1965, 18.50, 540, 4.7, false),
            new Book("Clean Code", "Martin", "Programming", 2008, 39.90, 464, 4.5, true),
            new Book("1984", "Orwell", "Dystopian", 1949, 12.50, 328, 4.6, true),
            new Book("The Pragmatic Programmer", "Hunt", "Programming", 1999, 42.00, 352, 4.7, true),
            new Book("Foundation", "Asimov", "Science Fiction", 1951, 15.00, 255, 4.4, false),
            new Book("Harry Potter", "Rowling", "Fantasy", 1997, 20.00, 410, 4.9, true),
            new Book("Effective Java", "Bloch", "Programming", 2018, 48.00, 416, 4.8, true)
        );

    */



    void main(){
        List<Book> books = List.of(
                new Book("The Hobbit", "Tolkien", "Fantasy", 1937, 14.90, 310, 4.8, true),
                new Book("Dune", "Herbert", "Science Fiction", 1965, 18.50, 540, 4.7, false),
                new Book("Clean Code", "Martin", "Programming", 2008, 39.90, 464, 4.5, true),
                new Book("1984", "Orwell", "Dystopian", 1949, 12.50, 328, 4.6, true),
                new Book("The Pragmatic Programmer", "Hunt", "Programming", 1999, 42.00, 352, 4.7, true),
                new Book("Foundation", "Asimov", "Science Fiction", 1951, 15.00, 255, 4.4, false),
                new Book("Harry Potter", "Rowling", "Fantasy", 1997, 20.00, 410, 4.9, true),
                new Book("Effective Java", "Bloch", "Programming", 2018, 48.00, 416, 4.8, true),
                new Book("Effective Java 2", "Bloch", "Programming", 2019, 48.00, 416, 4.8, true)

        );

        IO.println(getTitles(books));
        IO.println(getTitlesByPriceUnder20(books));
        IO.println(getBooksOrderedAscending(books));
        IO.println(getTitlesAsString(books));
        IO.println(getTitlesAsStringV2(books));
        IO.println(getLongestTitle(books));
        IO.println(groupByGenre(books));
        IO.println(groupByGenreThenCount(books));
        IO.println(getBookStatistics(books));
        IO.println(getThreeMostExpensiveTitlesExceptFirst(books));
        IO.println(getAuthorsWithMultipleBooks(books));
        IO.println(order(books));
    }


    /*
        fare una serie di funzioni che:

        - ritorna un List<String> con i titoli di tutti i libri
          List<String> getTitles(List<Book> books)

    */

    public static List<String> getTitles(List<Book> books){
        return books.stream().map(Book::getTitle).toList();
    }

    //    - ritorna i titoli di tutti i libri che costano meno di 20

    public static List<String> getTitlesByPrice(List<Book> books, double price){
        return books.stream().filter(b -> b.getPrice() < price).map(Book::getTitle).toList();
    }

    public static List<String> getTitlesByPriceUnder20(List<Book> books){
        final double price = 20;
        return getTitlesByPrice(books, price);
    }

    //    - ritorna il numero di libri che hanno come genere "Programming"

    public static long countBooksByGenre(List<Book> books, String genre){
        return books.stream().filter(b -> b.getGenre().equals(genre)).count();
    }

    public static long countBooksOfProgrammingGenre(List<Book> books){
        final String genre = "Programming";
        return countBooksByGenre(books, genre);
    }

    //    - ritorna tutti i libri ordinati per prezzo ascendente

    public static List<Book> getBooksOrderedAscending(List<Book> books){
        return books.stream().sorted(Comparator.comparingDouble(Book::getPrice)).toList();
    }

    //    - ritorna tutti i titoli dei libri ordinati per data di pubblicazione (prima i più recenti)

    public static List<String> getTitlesOfBooksOrderedByPublicationDate(List<Book> books){
        return books.stream().sorted(Comparator.comparingInt(Book::getPublicationYear).reversed()).map(Book::getTitle).toList();
    }


    //    - ritorna il libro più costoso

    public static Optional<Book> getMostExpensive(List<Book> books){
        return books.stream().max(Comparator.comparingDouble(Book::getPrice));
    }

    //    - ritorna true se tutti i libri hanno un rating superiore a 4

    public static boolean checkBooksRating(List<Book> books, double rating){
        return books.stream().allMatch(b -> b.getRating() > rating);
    }

    public static boolean checkIfBooksRatingHigherThan4(List<Book> books){
        final int rating = 4;
        return checkBooksRating(books, rating);
    }

    //    - ritorna true se almeno un libro ha almeno 500 pagine

    public static boolean checkIfAtLeastOneBookByPages(List<Book> books, int pages){
        return books.stream().anyMatch(b -> b.getPages() >= pages);
    }

    public static boolean checkIfAtLeastOneBookHas400PagesOrMore(List<Book> books){
        final int pages = 400;
        return checkIfAtLeastOneBookByPages(books, pages);
    }

    //    - ritorna l'autore del primo libro per cui è disponibile un ebook

    public static Optional<String> getAnyEbookAuthor(List<Book> books){
        return books.stream().filter(Book::isEbookAvailable).findAny().map(Book::getAuthor);
    }

    //    - ritorna il numero totale di pagine di tutti i libri di programmazione

    public static int sumPagesOfProgrammingGenre(List<Book> books){
        final String genre = "Programming";
        return books.stream().filter(b -> b.getGenre().equals(genre)).mapToInt(Book::getPages).sum();
    }

    //    - ritorna il massimo rating mai ricevuto tra i libri di un genere che viene dato in input

    public static double maxRatingByGenre(List<Book> books, String genre){
        return books.stream().filter(b -> b.getGenre().equals(genre)).mapToDouble(Book::getRating).max().orElse(0.0);
    }

    // ritorna una stringa composta da tutti i titoli separati da una virgola

    public static String getTitlesAsString(List<Book> books){
        return books.stream().
                reduce(
                        new StringBuilder(),
                        (string, book) -> string.append(book.getTitle()).append(", "),
                        StringBuilder::append).toString();
    }

    public static String getTitlesAsStringV2(List<Book> books){
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(", "));
    }

    // ritorna il titolo più lungo di tutti i libri calcolandolo tramite una reduce

    public static String getLongestTitle(List<Book> books){
        return books.stream().map(Book::getTitle).reduce(
                "",
                (identity, s) -> {
                    if(s.length() > identity.length()){
                        return s;
                    }
                    return identity;
                },
                ((s, s2) -> {
                    if(s.length() > s2.length()){
                        return s;
                    }
                    return s2;
                })
        );
    }

    // ritorna una mappa in cui la chiave è il genere e il valore è la lista di tutti i libri in quel genere

    public static Map<String, List<Book>> groupByGenre(List<Book> books){
        return books.stream().collect(Collectors.groupingBy(Book::getGenre));
    }

    // ritorna una mappa in cui la chiave è il genere e il valore è il libro più costoso in quel genere

    public static Map<String, Optional<Book>> groupByGenreThenCount(List<Book> books){
        return books.stream().collect(Collectors
                .groupingBy(Book::getGenre, Collectors.maxBy(Comparator.comparing(Book::getPrice))));
    }

    /* avendo una classe
    public class BookStatistics {
        int totalBooks;
        double totalPrice;
        int totalPages;
    }

    // creare un metodo che calcola tutte queste statistiche con un solo reduce

    */

    public static BookStatistics getBookStatistics(List<Book> books){
        return books.stream().reduce(
                new BookStatistics(),
                (bookStatistics, book) -> {
                    bookStatistics.addToTotalBooks(1);
                    bookStatistics.addToToralPrice(book.getPrice());
                    bookStatistics.addToToralPages(book.getPages());
                    return bookStatistics;
                },
                (s1, s2) -> {
                    s1.addToTotalBooks(s2.getTotalBooks());
                    s1.addToToralPrice(s2.getTotalPrice());
                    s1.addToToralPages(s2.getTotalPages());
                    return s1;
                });
    }

    // ritorna la lista dei titoli dei tre libri più costosi, ma ignorando il più costoso

    public static List<String> getThreeMostExpensiveTitlesExceptFirst(List<Book> books){
        return books.stream().sorted(Comparator.comparingDouble(Book::getPrice)
                .reversed())
                .skip(1)
                .limit(3)
                .map(Book::getTitle)
                .toList();
    }

    // ritorna la lista di libri ordinati:
    // 1. genere alfabetico
    // 2. a parità di genere, rating decrescente
    // 3. a parità di rating, titolo alfabetico

    public static List<Book> order(List<Book> books){
        return books.stream()
                .sorted(
                        Comparator
                                .comparing(Book::getGenre)
                                .thenComparing(Comparator.comparing(Book::getRating).reversed())
                                .thenComparing(Book::getTitle)).toList();
    }

    // con una sola istruzione di return:
    // ritorna la lista degli autori che hanno scritto più di un libro

    public static Set<String> getAuthorsWithMultipleBooks(List<Book> books){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet().stream()
                .filter(e-> e.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
    // correzione:
    // usare la classe BookStatistics invece del record

}
