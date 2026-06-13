package org.generation.italy.examples.exathome.riccardo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookReport {
    private List<Book> books;

    public BookReport(List<Book> books) {
        this.books = books;
    }

    // ritorna una lista di tutti i titoli dei libri List<String> getTitles(List<Book> books)
    public List<String> getTitles() {
        return books.stream()
                .map(Book::getTitle)
                .toList();
    }

    // ritorna i titoli di tutti i libri che costano meno di 20 euro
    public List<String> getCheapBookTitles() {
        return books.stream()
                .filter(b -> b.getPrice() < 20)
                .map(Book::getTitle)
                .toList(); // qui ritorniamo i libri in una lista così come abbiamo fatto per il primo metodo
    }

    // ritorna il numero di libri che hanno come genere "Programming"
    public long countGenreProgrammingBook() {
        return books.stream()
                .filter(b -> b.getGenre().equals("Programming"))
                .count();  // ".count()" ritorna un long, quindi il tipo del metodo è long
                           // N.B. avremmo potuto castare a int MA "non è una buona pratica"
    }

    // ritorna tutti i libri ordinati per prezzo ascencente
    public List<Book> ascendingOrderByPrice() {
        return books.stream()
                // partiamo col dire che .sorted ordina in "modo naturale"
                // in particolare per i numeri, .sorted applica un ordine ascendente
                // infine c'è da dire che il prezzo dei libri è un double
                .sorted(Comparator.comparingDouble(Book::getPrice))
                // Poi per ordinare i libri avremmo potuto scrivere anche :
                // .sorted((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()))
                .toList();
    }

    // ritorna tutti i titoli dei libri ordinati per data di pubblicazione (prima i piu recenti)
    public List<String> titlesByNewest() {
        return books.stream()
                // qui il problema è che .sorted ordiando in modo ascendente fa si che che
                // i primi libri siano quelli più vecchi e gli ultimi libri quelli più recenti
                // Quindi per risolvere questo problema ci basta applicare ".reversed"
                // Infine l'anno di pubblicazione di un libro è un intero
                .sorted(Comparator.comparingInt(Book::getPublicationYear).reversed())
                .map(Book::getTitle)
                .toList();
    }

    // rirtorna il libro piu costoso
    // qui abbiamo scelto "optional" perchè ".max()" può non trovare nulla come massimo se la lista è vuota
    // N.B. negli altri metodi precedenti non abbiamo utilizzato "optional" perchè ad esempio
    // in .map.toList(), se la lista è vuota, allora il risultato è una lista vuota...che non è un problema,
    // non è “assenza di valore" perchè è comunque una lista valida
    //
    // in .count(), se la lista è vuota, il risultato è uguale a 0, cioè è un numero valido
    public Optional<Book> mostExpensiveBook() {
        return books.stream()
                .max(Comparator.comparingDouble(Book::getPrice));
    }

    // ritorna true se tutti i libri hanno un rating superiore a 4
    public boolean allBookRatingAboveFour() {
        return books.stream()
                // qui utiliziamo ".allMatch" perchè chiede se:
                // "Tutti gli elementi rispettano questa condizione?”
                // e se tutti i libri sono > 4, allora ritorna true
                // se anche un solo libro non lo è, allora ritorna false
                .allMatch(b -> b.getRating() > 4);
    }

    // ritorna true se almeno un libro ha almeno 500 pagine
    public boolean hasBookWith500Pages() {
        return books.stream()
                // qui utiliziamo ".anyMatch" perchè chiede se:
                // "C'è almeno un elemento che rispetta questa condizione?”
                // e se se almeno un libro ha almeno 500 pagine, allora ritorna true
                // altrimenti ritorna false
                .anyMatch(b -> b.getPages() >= 500);
    }

    // ritorna l'autore del primo libro per cui è disponibile un ebook
    public Optional<String> firstEbookAuthor() {
        return books.stream()
                // qui filtriamo da tutti i libri solo quelli che hanno l'ebbok disponibile
                .filter(Book::isEbookAvailable)
                // dopo aver trovato i libri con l'ebook, ci spostiamo sul loro autore
                .map(Book::getAuthor)
                // infine ritorniamo il primo autore trovato
                .findFirst();
    }

    // ritorna il numero totale di pagine di tutti i lbri di programmazione
    public int totalProgrammingPages() {
        return books.stream()
                // quindi filtriamo da tutti i libri solo quelli che hanno come genere "Programming"
                .filter(b -> b.getGenre().equals("Programming"))
                // ci spostiamo sulle pagine di questi e le pagine ricordiamo che sono int
                // (quindi utiliziamo "mapToInt")
                .mapToInt(Book::getPages)
                // infine ""sommiamo" tutte le pagine per ottenere il numero totale di pagine di tutti i lbri filtrati
                .sum();
    }

    // ritorna il massimo rating mai ricevuto tra i libri di un genere che viene dato in input
    // quindi come input del metodo scriviamo "String genre"
    public double maxRatingByGenre(String genre) {
        return books.stream()
                .filter(b -> b.getGenre().equals(genre))
                .mapToDouble(Book::getRating)
                .max()
                .orElse(0); // questo è l'altro modo per scrivere l'"Optional"
                                  // e impostiamo che se la lista fosse vuota, allora il max ritorna come valore "zero"
    }

    // ritorna una stringa composta da tutti i titoli dei libri separati da una virgola
    public String allTitlesCommaSeparated() {
        return books.stream()
                .map(Book::getTitle)
                // ".reduce" è una funzione che prende tanti elementi e li “riduce” a uno solo
                // e poi prendiamo due stringhe e le uniamo con una virgola in mezzo ed uno spazio
                .reduce((t1, t2) -> t1 + ", " + t2)
                .orElse(""); // questo serve solo se la lista è vuota, ritorna una stringa vuota

                // avremmo potuto anche fare così (in un solo passaggio e non due):
                //.collect(Collectors.joining(", "));
                // quindi ora qui abbiamo raccolto (grazie a ".collect") tutti i titoli dei libri
                // infine estraiamo i titoli e li uniamo tutti in un a sola stringa separata da virgole e spazi
    }

    // ritorna il titolo più lungo di tutti i libri calcolandolo tramite una reduce
    public String longestTitle() {
        return books.stream()
                .map(Book::getTitle)
                .reduce("",
                        (t1, t2) -> t1.length() > t2.length() ? t1 : t2);
    }

    // ritorna una mappa in cui la chiave è il genere e il valore è la lista di tutti i libri in quel genere
    public Map<String, List<Book>> groupByGenre() {
        return books.stream()
                // avevamo detto che groupinBy sarebbe come fare .toMap
                .collect(Collectors.groupingBy(Book::getGenre));
    }

    // ritorna una mappa in cui la chiave è il genere e il valore e' il libro più costoso in quel genere
    public Map<String, Optional<Book>> mostExpensiveByGenre() {
        return books.stream()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.maxBy(Comparator.comparingDouble(Book::getPrice))
                ));
    }
}
