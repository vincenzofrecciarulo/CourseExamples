package org.generation.italy.examples.oo.lambdaandstreams.weekExcercise;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookReportMaker {

    private List<Book> books;

    public BookReportMaker(List<Book> books){
        this.books = books;
    }

    // 1. ritorna una lista di tutti i titoli dei libri List<String> getTitles(List<Book> books)
    public List<String> titleBooks(){
        return books.stream()
                .map(Book::getTitle)
                .toList();
    }

    //2. Ritorna i titoli di tutti i libri che costano meno di 20
    public List<String>  booksTitleUnderTwenty(){
        return books.stream()
                .filter(c -> c.getPrice() < 20)
                .map(Book::getTitle)
                .toList();
    }

    //3. Ritorna il numero di libri che hanno come genere "Programming"
    public int codeBook(){
        return (int) books.stream()
                .filter(c -> c.getGenre().equals("Programming"))
                .count();
    }

    //4. Ritorna tutti i libri ordinati pre prezzo ascencente
    public List<String> titlePriceOrdered(){
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .map(Book::getTitle)
                .toList();
    }

    //5. Ritorna tutti i titoli dei libri ordinati per data di pubblicazione (prima i piu recenti)
    public List<String> titleBooksOrderedByDate(){
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getPublicationYear).reversed())
                .map(Book::getTitle)
                .toList();
    }

    //6. Rirtorna il libro piu costoso
    public Optional<Book> mostExpensive(){
        return books.stream()
                .max(Comparator.comparingDouble(Book::getPrice));

    }

    //7. Ritorna true se tutti i libri hanno un rating superiore a 4
    public boolean ratingUpToFour(){
        return books.stream()
                .allMatch(c -> c.getRating() > 4);
    }

    //8. Ritorna true se almeno un libro ha almeno 500 pagine
    public boolean pagesCount(){
        return books.stream()
                .anyMatch(c -> c.getPages() >= 500);
    }

    //9. Ritorna l autore del primo libro per cui e disponibile un ebook
    public Optional<String> authorEbook(){
        return books.stream()
                .filter(Book::isEbookAvailable)
                .map(Book::getAuthor)
                .findFirst();
    }

    //10. Ritorna il numero totale di pagine di tutti i libri di programmazione
    public int totPages(){
        return books.stream()
                .filter(c -> c.getGenre().equals("Programming"))
                .mapToInt(Book::getPages)
                .sum();
    }

    //11. Ritorna il massimo rating mai ricevuto tra i libri di un genere che viene dato in input
    public double maxRating(String genre){
        return books.stream()
                .filter(c -> c.getGenre().equals(genre))
                .mapToDouble(Book::getRating)
                .max().orElse(0.0);

    }
}
