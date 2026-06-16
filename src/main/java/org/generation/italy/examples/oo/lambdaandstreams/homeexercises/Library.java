package org.generation.italy.examples.oo.lambdaandstreams.homeexercises;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    List<Book> books;

    public Library() {
        this.books = List.of(
                new Book("The Hobbit", "Tolkien", "Fantasy", 1937, 14.90, 310, 4.8, true),
                new Book("Dune", "Herbert", "Science Fiction", 1965, 18.50, 540, 4.7, false),
                new Book("Clean Code", "Martin", "Programming", 2008, 39.90, 464, 4.5, true),
                new Book("1984", "Orwell", "Dystopian", 1949, 12.50, 328, 4.6, true),
                new Book("The Pragmatic Programmer", "Hunt", "Programming", 1999, 42.00, 352, 4.7, true),
                new Book("Foundation", "Asimov", "Science Fiction", 1951, 15.00, 255, 4.4, false),
                new Book("Harry Potter", "Rowling", "Fantasy", 1997, 20.00, 410, 4.9, true),
                new Book("Effective Java", "Bloch", "Programming", 2018, 48.00, 416, 4.8, true)
        );
    }

    //ritorna una lista di tutti i titoli dei libri List<String> getTitles(List<Book> books)

    public List<String> getTitles(){
        return books.stream().map(Book::getTitle)
                    .toList();
    }

    //ritorna i titoli di tutti i libri che costano meno di 20

    public List<String> getBooksUnder20golds(){
        return books.stream().filter(book -> book.getPrice() < 20)
                             .map(book -> book.getTitle() + " - " + book.getPrice())
                             .toList();

    }

    //ritorna il numero di libri che hanno come genere "Programming"

    public int getProgrammingBooks(){
        return (int)books.stream().filter(book -> book.getGenre().equals("Programming"))
                                  .count();
    }

    //ritorna tutti i libri ordinati pre prezzo ascencente

    public List<Book> getPriceOrderedBooks(){
        return books.stream().sorted(Comparator.comparingDouble(Book::getPrice))
                             .toList();
    }

    //ritorna tutti i titoli dei libri ordinati per data di pubblicazione (prima i piu recenti)

    public List<String> getDateOrderedBooks(){
        return books.stream().sorted(Comparator.comparing(Book::getPublicationYear))
                             .map(book -> book.getTitle() + " - " + book.getPublicationYear())
                             .toList();
    }

    //ritorna il libro piu costoso

    public Book getHighestPriceBook(){
        return books.stream().max(Comparator.comparingDouble(Book::getPrice))
                             .orElse(null);
    }

    //ritorna true se tutti i libri hanno un rating superiore a 4

    public boolean isRatingGood(){
        return books.stream().allMatch(book -> book.getRating() > 4);
    }

    //ritorna true se almeno un libro ha almeno 500 pagine

    public boolean atLeastOneIsBig(){
        return books.stream().anyMatch(book -> book.getPages() >= 500);
    }

    //ritorna l'autore del primo libro per cui è disponibile un ebook

    public String authorWithEbook(){
        return books.stream().filter(Book::isEbookAvailable)
                             .findFirst()
                             .map(Book::getAuthor)
                             .orElse(null);
    }

    //ritorna il numero totale di pagine di tutti i lbri di programmazione

    public int totPagesNumberOfAllProgrammingBooks(){
        return books.stream().filter(book -> book.getGenre().equalsIgnoreCase("Programming"))
                             .mapToInt(Book::getPages)
                             .sum();
    }

    //ritorna il massimo rating mai ricevuto tra i libri di un genere che viene dato in input

    public double maxRatingPerGenre(String genre){
        return books.stream().filter(book -> book.getGenre().equalsIgnoreCase(genre))
                             .mapToDouble(Book::getRating)
                             .max()
                             .orElse(0);

    }

    //ritorna una stringa composta da tutti i titoli dei libri separati da una virgola

    public String getTitlesInString(){
        return books.stream().map(Book::getTitle)
                             .collect(Collectors.joining(", "));
    }

    //ritorna il titolo piu lungo di tutti i libri calcolandolo tramite una reduce

    public String longestTitleBook() {
        return books.stream()
                    .map(Book::getTitle)
                    .reduce((title1, title2) -> title1.length() >= title2.length() ? title1 : title2)
                    .orElse("null");
    }

    //ritorna una mappa in cui la chiave è il genere e il valore è la lista di tutti i libri in quel genere

    public Map<String, List<Book>> getBooksByGenre(){
        return books.stream()
                    .collect(Collectors.groupingBy(Book::getGenre));
    }

    //ritorna una mappa in cui la chiave è il genere e il valore è il libro piu costoso in quel genere

    public Map<String, Book> getHighestPriceBookByGenre(){
        return books.stream()
                    .collect(Collectors.toMap(Book::getGenre,
                            book -> book, (book1, book2) -> book1.getPrice() >= book2.getPrice() ? book1 : book2
                ));
    }

    //


}
