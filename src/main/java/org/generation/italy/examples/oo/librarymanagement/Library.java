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

    // 16 - creare un metodo che calcola tutte queste statistiche con un solo reduce
    public Record getStatsRecord(){
        // totale pagine, totale libri, totale prezzi
        return books.stream()
                // metodo terminale che ci da la possibilità di fare queste somme, prendiamo quello con 3 parametri
                .reduce(
                        new BookStatistics(0,0,0), // <- creiamo un modello base di partenza
                        ((bookStatistics, book) -> {
                            // facendo riferimento al record base creiamo delle nuove variabili
                            int count = bookStatistics.totalBooks() + 1;
                            int totalPages = bookStatistics.totalPages() + book.getPages();
                            double totalPrice = bookStatistics.totalPrice() + book.getPrice();
                            // essendo un record non possiamo direttamente modificarlo e ne istanziamo uno nuovo
                            return new BookStatistics(count,totalPrice,totalPages);
                        }), null
                );
    }

    // 17 - ritorna la lista dei titoli dei tre libri piu costosi, ma ignorando il piu costoso
    public List<String> iTreLibriPiuCostosiSenzaIlPiuCostoso(){
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice).reversed())
                .skip(1)
                .limit(3)
                .map(Book::getTitle)
                .toList();

    }

    // 18 - ritorna la lista di libri ordinati prima per genere alfabetico, a parita' di genere per rating discendente,
    // a parita di rating per titolo alfabetico
    public List<Book> orderedBooks(){
        return books.stream()
                .sorted(Comparator.comparing(Book::getGenre)
                .thenComparing(Book::getRating)
                        .thenComparing(Book::getTitle))
                .toList();
    }

    // - 19 con una sola istruzione di return...  ritorna la lista degli autori che hanno scritto piu di un libro
    public List<String> autoriConPiuLibri(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting())) // <- creiamo una map<String,Long>
                .entrySet(). // <- qui prendiamo un set solo <String, Long>
                stream() // <- qui apriamo un altro strem di quella lista
                .filter(e -> e.getValue() > 1) // <- filtriamo sull'entry che ha il valore maggiore di uno
                .map(Map.Entry::getKey) // <- trasformiamo lo stream in stringhe grazie un interfaccia Map.Entry
                .toList(); // trasformiamo in una lista
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
