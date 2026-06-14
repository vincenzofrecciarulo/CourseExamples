package org.generation.italy.examples.oo.lambdaandstreams.weekExcercise;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
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

    //12. Ritorna una stringa composta da tutti i titoli dei libri separati da una virgola
    public String booksTitles(){
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(", "));
    }

    //13. Ritorna il titolo più lungo di tutti i libri calcolato tramimite reduce
    public String longerTitle(){
        return books.stream()
                .map(Book::getTitle)
                .reduce((s, s2) -> {
                    if (s.length() > s2.length()) {
                        return s;
                    } else {
                        return s2;
                    }
                })
                .orElse("");
    }

    //14. Ritorna una mappa in cui la chiave è il genere e il valore la lista di tutti i libri di quel genere
    public Map<String, List<Book>> mapTitle(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
    }

    //15. Ritorna una mappa in cui la chiave è il genere e il valore è il libro più costoso in quel genere
    public Map<String, Book> expensiveBook(){
        return books.stream()
                .collect(Collectors.toMap(Book::getGenre, Function.identity(), BinaryOperator.maxBy(Comparator.comparingDouble(Book::getPrice))));
    }

    //16. Metodo che calcola tutte queste statistiche con un solo reduce
    public BookStatistic report(List<Book> bookList){
        return bookList.stream()
                .reduce(new BookStatistic(), (acc, book) -> new BookStatistic(
                        acc.getTotalBooks() + 1,
                        acc.getTotalPrice() + book.getPrice(),
                        acc.getTotalPage() + book.getPages()
                ), (b1, b2) -> new BookStatistic(
                        b1.getTotalBooks() + b2.getTotalBooks(),
                        b1.getTotalPrice() + b2.getTotalPrice(),
                        b1.getTotalPage() + b2.getTotalPage()
                ));
    }

    //17.Ritorna la lista dei titoli dei tre libri più costosi ignornado il più costoso
    public List<Book> expensiveBookLessFirst(){
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice).reversed())
                .skip(1)
                .limit(3)
                .toList();
    }

    //18.

    public List<Book> sortedBooks(){
        return books.stream()
                .sorted(
                        Comparator.comparing(Book::getGenre)
                                .thenComparing(Book::getRating, Comparator.reverseOrder())
                                .thenComparing(Book::getTitle)
                )
                .toList();
    }

    //19.

    public List<String> getAuthor(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }
}
