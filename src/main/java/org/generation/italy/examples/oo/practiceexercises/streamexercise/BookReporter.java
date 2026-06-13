package org.generation.italy.examples.oo.practiceexercises.streamexercise;

import java.util.*;
import java.util.stream.Collectors;


public class BookReporter {

    List<Book> books = List.of(
            new Book("The Hobbit", "Tolkien", "Fantasy"
                    , 1937, 14.90, 310, 4.8, true),
            new Book("Dune", "Herbert", "Science Fiction"
                    , 1965, 18.50, 540, 4.7, false),
            new Book("Clean Code", "Martin", "Programming"
                    , 2008, 39.90, 464, 4.5, true),
            new Book("1984", "Orwell", "Dystopian"
                    , 1949, 12.50, 328, 4.6, true),
            new Book("The Pragmatic Programmer", "Hunt", "Programming"
                    , 1999, 42.00, 352, 4.7, true),
            new Book("Foundation", "Asimov", "Science Fiction"
                    , 1951, 15.00, 255, 4.4, false),
            new Book("Harry Potter", "Rowling", "Fantasy"
                    , 1997, 20.00, 410, 4.9, true),
            new Book("Effective Java", "Bloch", "Programming"
                    , 2018, 48.00, 416, 4.8, true)
    );

    //Ex 1: ritorna unalista di tutti i titoli dei libri List<String> getTitles(List<Book> books)
    public List<String> getTitle() {
        return books.stream().map(Book::getTitle).toList();
    }

    //Ex 2:ritorna i titoli di tutti i libri che costano meno di 20
    public List<String> getBookUnderTwentyDollar() {
        return books.stream().filter(book -> book.getPrice() < 20)
                .map(Book::getTitle)
                .toList();
    }

    //Ex 3:ritorna il numero di libri che hanno come genere "Programming"
    public Integer getProgrammingsBookNumber() {
        return (int) books.stream().filter(book -> book.getGenre().
                equalsIgnoreCase("Programming")).count();
    }

    //Ex 4:ritorna tutti i libri ordinati pre prezzo ascendente
    public List<Book> getOrderedByPriceAscendent() {
        return books.stream().sorted(Comparator.comparing(Book::getPrice)).toList();
    }

    //Ex 5:ritorna tutti i titoli dei libri ordinati per data di pubblicazione (prima i piu recenti)
    public List<String> getBooksOrderedByTheLatest() {
        return books.stream().sorted(Comparator.comparing(Book::getPublicationYear).reversed())
                .map(Book::getTitle)
                .toList();
    }

    //Ex 6:ritorna il libro piu costoso
    public Optional<Book> getTheMostExpensive() {
        return books.stream().max(Comparator.comparing(Book::getPrice));
    }

    //Ex 7:ritorna true se tutti i libri hanno un rating superiore a 4
    public boolean getRatingOverFour() {
        return books.stream().allMatch(b -> b.getRating() > 4);
        //return books.stream().allMatch(Book::isOverFourRating);
    }

    //EX 8:ritorna true se almeno un libro ha almeno 500 pagine
    public boolean isThereA500PagesBook() {
        return books.stream().anyMatch(b -> b.getPages() >= 500);
    }

    //EX 9:ritorna l autore del primo libro per cui e disponibile un ebook
    public Optional<String> getFirstEbooksAuthorNameAveilable() {
        return books.stream().filter(Book::isEbookAvailable)
                .findFirst()
                .map(Book::getAuthor);
    }

    //EX 10:ritorna il numero totale di pagine di tutti i libri di programmazione
    public int getTotalBooksPages() {
        return books.stream().filter(b -> b.getGenre().equalsIgnoreCase("Programming"))
                .mapToInt(Book::getPages)
                .sum();
    }

    //EX 11:ritorna il massimo rating mai ricevuto tra i libri di un genere che viene dato in input
    public OptionalDouble getMaxRatingBetweenGender(String genre) {
        return books.stream().filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .mapToDouble(Book::getRating)
                .max();
    }

    //EX 12 ritorna una stringa composta da tutti i titoli dei libri separati da una virgola
    public String getAllTitle() {
        return books.stream().map(Book::getTitle)
                .collect(Collectors.joining(","));
    }

    //EX 13 ritorna il titolo piu lungo di tutti i libri calcolandolo tramite una reduce
    public Optional<String> getLongestTitle() {
        return books.stream().map(Book::getTitle)
                .reduce((a, b) -> a.length() > b.length() ? a : b);
    }

    //EX 14 ritorna una mappa in cui la chiave e. il genere e il valore la lista
    // di tutti i libri in quel genere
    public Map<String, List<Book>> groupByGender() {
        return books.stream().collect(Collectors.groupingBy(Book::getGenre));
    }

    //EX 15 ritorna un amappa in cui la chaive è il genere e il valore e' il libro piu
    // costoso in quel genere
    public Map<String, Optional<Book>> getTheMostExpensiveGroupedByGender() {
        return books.stream().collect(Collectors.groupingBy(Book::getGenre, Collectors.maxBy
                (Comparator.comparing(Book::getPrice).reversed())));
    }

    //EX 16:ritorna la lista dei titoli dei tre libri piu costosi, ma ignorando il piu costoso
    public List<String> getTheThreeMostexpensiveByTitle() {
        return books.stream().sorted(Comparator.comparing(Book::getPrice).reversed())
                .map(Book::getTitle)
                .skip(1)
                .limit(3)
                .toList();

    }

    //EX 17:ritorna l alista di libri ordinati prima per genere alfabetico,  a parita' di
    // genere per rating discendente, a parita di rating per titolo alfabetico
    public List<Book> getListOrderedByLetterAndDiscendentrating() {
        return books.stream().sorted(Comparator.comparing(Book::getGenre)
                        .thenComparing(Book::getRating).reversed()
                        .thenComparing(Book::getTitle))
                        .toList();
    }

    //EX 18:creare un metodo che calcola tutte queste statistiche con un solo reduce
    public BookStatistics getStats() {
        return books.stream().reduce(new BookStatistics(),
                (BookStatistics stats, Book book) -> new BookStatistics(
                        stats.getTotalBooks() + 1,
                        stats.getTotalPrice() + book.getPrice(),
                        stats.getTotalPages() + book.getPages()),
                (stats1, stats2) -> new BookStatistics(
                        stats1.getTotalBooks() + stats2.getTotalBooks(),
                        stats1.getTotalPrice() + stats2.getTotalPrice(),
                        stats1.getTotalPages() + stats2.getTotalPages()));
    }
    //EX 19 ritorna l alista di libri ordinati prima per genere alfabetico,
    // a parita' di genere per rating discendente, a parita di rating per titolo alfabetico
    public List<Book> getBooksByLecterAndGenreWithRatingDiscendingAndByLecter(){
        return books.stream().sorted(Comparator.comparing(Book::getGenre)
                .thenComparing(Comparator.comparing(Book::getRating).reversed())
                .thenComparing(Book::getTitle))
                .toList();
    }
    //EX 20 con una sola istruzione di return...
    // ritorna la lista degli autori che hanno scritto piu di un libro
    public List<String>getListOfWriterThatWroteMoreThanOneBook(){
        return books.stream().collect(Collectors.groupingBy(Book::getAuthor))
                        .entrySet().stream().filter(stringListEntry -> stringListEntry
                        .getValue().size()>1)
                        .map(Map.Entry::getKey).toList();
    }
    //Ritorna la media dei prezzi di tutti i libri
    public OptionalDouble getTheAverage(){
        return books.stream().mapToDouble(Book::getPrice).average();
    }
//    Ritorna la lista dei generi senza duplicati, in ordine alfabetico
    public List<String>getGenderWithoutDuplicate(){
        return books.stream().sorted(Comparator.comparing(Book::getGenre))
                .map(Book::getGenre)
                .distinct().toList();
    }
//Ritorna una mappa con chiave l'autore e valore il totale delle pagine scritte da quell'autore
    public Map<String,Integer>getPagesWrotedByTheAuthors(){
        return books.stream().collect(Collectors.groupingBy(Book::getAuthor
                ,Collectors.summingInt(Book::getPages)));

    }
//    Ritorna il genere con più libri
    public String getTheGenreModes(){
        return books.stream().collect(Collectors.groupingBy(Book::getGenre))
                .entrySet().stream().max(Comparator
                        .comparingInt(entry->entry.getValue()
                                .size())).orElseThrow().getKey();

    }








}
