package org.generation.italy.examples.homework.steams;

import java.util.List;
import java.util.Optional;
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
                new Book("Effective Java", "Bloch", "Programming", 2018, 48.00, 416, 4.8, true)
        );

        IO.println(getTitles(books));
        IO.println(getTitlesByPriceUnder20(books));
        IO.println(getTitlesAsString(books));

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
        return books.stream().sorted(Book::isMoreExpensiveThan).toList();
    }

    //    - ritorna tutti i titoli dei libri ordinati per data di pubblicazione (prima i più recenti)

    public static List<String> getTitlesOfBooksOrderedByPublicationDate(List<Book> books){
        return books.stream().sorted(Book::isOlderThan).map(Book::getTitle).toList();
    }

    //    - ritorna il libro più costoso

    public static Optional<Book> getMostExpensive(List<Book> books){
        return books.stream().max(Book::isMoreExpensiveThan);
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
        return books.stream().filter(Book::isEbookAvailable).map(Book::getAuthor).findFirst();
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

    // ritorna il titolo più lungo di tutti i libri calcolandolo tramite una reduce

    // ritorna una mappa in cui la chiave è il genere e il valore è la lista di tutti i libri in quel genere

    // ritorna una mappa in cui la chiave è il genere e il valore è il libro più costoso in quel genere

    /* avendo una classe
    public class BookStatistics {
        int totalBooks;
        double totalPrice;
        int totalPages;
    }

    // creare un metodo che calcola tutte queste statistiche con un solo reduce

    // ritorna la lista dei titoli dei tre libri più costosi, ma ignorando il più costoso

    // ritorna la lista di libri ordinati:
    // 1. genere alfabetico
    // 2. a parità di genere, rating decrescente
    // 3. a parità di rating, titolo alfabetico

    // con una sola istruzione di return:
    // ritorna la lista degli autori che hanno scritto più di un libro

    // correzione:
    // usare la classe BookStatistics invece del record
     */
}
