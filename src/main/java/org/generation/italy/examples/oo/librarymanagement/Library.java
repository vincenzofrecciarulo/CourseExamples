package org.generation.italy.examples.oo.librarymanagement;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Library {
    List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    // metodi x esercitazioni lambda


    // 1 - ritorna un lista di tutti i titoli dei libri List<String> getTitles(List<Book> books)
    public List<String> getTitles(List<Book> books) {
        return books.stream() // <- apro lo stream cosi da lavorare sui dati al suo interno
                .map(Book::getTitle) // <- tramite la funzione secondaria lo faccio diventare uno Stream<String>
                .toList(); // <- lo faccio diventare una lista cosi da avere il tipo di ritorno giusto
    }

    // 2 - ritorna i titoli di tutti i libri che costano meno di 20 (in realtà ho fatto in base a qualsiasi prezzo)
    public List<String> getTitlesUnderPrice(double price){
        return books.stream() // <- apro lo stream per iniziare il lavoro sui dati
                .filter(b -> b.isUnderPrice(price)) // <- faccio prima un filtro in base al prezzo in input
                .map(Book::getTitle) // <- filtrati solo i book con quel prezzo li trasformo in stringhe
                .toList(); // <- metto tutto in una lista
    }

    // 3 - ritorna il numero di libri che hanno come genere "Programming" (si potrebbe fare con una stringa generale)
    public long getProgrammingBooksNumber(String genre){
        return  books.stream() // apro il flusso per lavorare con i dati
                .filter(b -> b.getGenreByString(genre)) // filtra i libri in base alla stringa in input
                .count(); // funzione di chiusura che conta tutti i libri che hanno passato il filtro
    }

    // 4 - ritorna tutti i libri ordinati per prezzo ascendente
    public List<Book> getBooksByAscendingPrice(){
        return books.stream() // apro il flusso dei dati su cui lavorare
                // siccome lavoria con dei double ci affidiamo ad un metodo della classe Comparator, per non perdere decimali
                .sorted(Comparator.comparingDouble(Book::getPrice)) // tramite il metodo sorted faccio la comparazione
                .toList(); // ritorno tutto come lista
    }

    // 5 - ritorna tutti i titoli dei libri ordinati per data di pubblicazione (prima i piu recenti)
    public List<Book> getBooksByAscendingDate(){
        return books.stream() // apro il flusso
                .sorted(Comparator.comparing(Book::getPublicationYear).reversed()) // ordino per data
                .toList(); // rimetto tutto in una lista
    }

    // 6 - ritorna il libro piu costoso
    public Optional<Book> getMostExpensiveBook(){
        // tramite un comparator in questo caso controllo i prezzi mi ritorna il massimo
        return books.stream().max(Comparator.comparingDouble(Book::getPrice));
    }

    // 7 - ritorna true se tutti i libri hanno un rating superiore a 4 (modificato)
    public boolean isAllOverRating(double rating){
        return books.stream().noneMatch(b-> b.isUnderRating(rating)); // se ce almeno un libro sotto il rating ritorna false
    }

    // 8 - ritorna true se almeno un libro ha almeno 500 pagine (modificato)
    public boolean hasAnyBookMoreThanPages(int pages){
        return books.stream().anyMatch(b -> b.hasMoreThanPages(pages)); // se almeno un libro ha 500 pagine ritorna true
    }

    // 9 - ritorna l autore del primo libro per cui e disponibile un ebook
    public Optional<String> getAuthorByEbook(){
        return books.stream()
                .filter(Book::isEbookAvailable)
                .map(Book::getAuthor)
                .findFirst();
    }

    // 10 - ritorna il numero totale di pagine di tutti i libri di programmazione
    public int getTotalNumberPagesByGenre(String string){
        return books.stream()
                .filter(b -> b.getGenreByString(string))
                .mapToInt(Book::getPages)
                .sum();
    }

    // 11 - ritorna il massimo rating mai ricevuto tra i libri di un genere che viene dato in input
    public OptionalDouble getMaxRatingBookByGenre(String string){
        return books.stream()
                .filter(b -> b.getGenreByString(string))
                .mapToDouble(Book::getRating)
                .max();
    }

    // 12 - ritorna una stringa composta da tutti i titoli dei libri separati da una virgola
    public String getAllTitlesInString(){
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(", "));
    }

    // 13 - ritorna il titolo piu lungo di tutti i libri calcolandolo tramite una reduce
    public Optional<String> getTitleByMaxLength(){
        return books.stream()
                .map(Book::getTitle)
                .reduce(((s, s2) -> s.length() > s2.length() ? s: s2));
    }

    // 14 - ritorna una mappa in cui la chiave e il genere e il valore la lista di tutti i libri in quel genere
    public Map<String, List<Book>> getBooksListByGenre(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.toList()));
    }

    // 15 - ritorna una mappa in cui la chiave e il genere e il valore e' il libro piu costoso in quel genere
    public Map<String ,Optional<Book>> getMostExpensiveBookByGenre(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.maxBy(Comparator.comparingDouble(Book::getPrice))));
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }

    public List<Book> getBooks() {
        return books;
    }
}
