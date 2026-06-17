package org.generation.italy.examples.oo.homeexercise.exerciselambdaandstream;

import java.util.Comparator;
import java.util.List;


//rirtorna il libro piu costoso
//ritorna true se tutti i libri hanno un rating superiore a 4
//ritorna true se almeno un libro ha almeno 500 pagine
//ritorna l autore del primo libro per cui e disponibile un ebook
//ritorna il numero totale di pagine di tutti i lbri di programmazione
//ritorna il massimo rating mai ricevuto tra i libri di un genere che viene dato in input
//ritorna una stringa composta da tutti i titoli dei libri separati da una virgola
//ritorna il titolo piu lungo di tutti i libri calcolandolo tramite una reduce
//ritorna una mappa in cui la chiave e. il genere e il valore la lista di tutti i libri in quel genere
//ritorna un amappa in cui la chiave e il genere e il valore e' il libro piu costoso in quel genere

public class ReportBook {
    private List<Book> books;

    public ReportBook(List<Book> books) {
        this.books = books;
    }

    //ritorna una lista di tutti i titoli dei libri List<String> getTitles(List<Book> books)
    public List<String> getTitles(List<Book> books){
        return books.stream()
                .map(Book :: getTitle)
                .toList();
    }
    //ritorna i titoli di tutti i libri che costano meno di 20
    public List<String> getBookTitleUnder20 (List<Book> books){
        return books.stream()
                .filter(b -> b.getPrice()<20)
                .map(Book::getTitle)
                .toList();
    }
    //ritorna il numero di libri che hanno come genere "Programming"
    public long getBookOfGenrePorgramming (List<Book> books){
        return books.stream()
                .filter( b ->b.getGenre().equals("Programming"))
                .count();
    }

    //ritorna in una lista tutti i libri ordinati per prezzo ascendente
    public List<Book> ascendingOrderByPrice(List<Book> books){
        return books.stream()
                .sorted(Comparator.comparingDouble(b -> b.getPrice()))
                .toList();
    }

    //ritorna tutti i titoli dei libri ordinati per data di pubblicazione (prima i piu recenti)

}
