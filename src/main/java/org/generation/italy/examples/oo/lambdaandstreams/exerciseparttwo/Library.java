package org.generation.italy.examples.oo.lambdaandstreams.exerciseparttwo;

import org.generation.italy.examples.oo.lambdaandstreams.excercises.SalaryReport;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Library {

    private List<Book> books = new ArrayList<>();





    //ritorna un alista di tutti i titoli dei libri List<String> getTitles(List<Book> books)
    public List<String> getTitleList(){
        return books.stream().map(Book::getTitle).toList();
    }
    //ritorna i titoli di tutti i libri che costano meno di 20
    public List<String> getTitalesOfBookMinusAmount (double amount){
        return books.stream().filter(b->b.getPrice()<amount).map(Book::getTitle).toList();
    }

    //ritorna il numero di libri che hanno come genere "Programming"
    public int getNumberOfProgrammingBooks (){
        return (int) books.stream().
                filter(b->b.getGenre().equals("Programming")).count();

    }
    //ritorna tutti i libri ordinati pre prezzo ascencente
    public List<Book> orderByLowerPrice(){
        return books.stream().sorted(Comparator.comparingDouble(Book::getPrice)).toList();
    }
    //ritorna tutti i titoli dei libri ordinati per data di pubblicazione (prima i piu recenti)
    public List<String> getTitleBooksFromYoungest (){
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getPublicationYear).reversed())
                .map(Book::getTitle)
                .toList();
    }
    //rirtorna il libro piu costoso
    public Optional<Book> getMostExpensiveBook(){
        Book book;
        return books.stream().max(Comparator.comparingDouble(Book::getPrice));
    }
    // ritorna true se tutti i libri hanno un rating superiore a 4
    public boolean areAllRatingSuperior4 (){
        return   books.stream().allMatch(b->b.getRating()>4);
        //allMatch,anyMatch,noneMatch sono tutti operatori terminali
    }
    //ritorna true se almeno un libro ha almeno 500 pagine
    public boolean existBookWith500Pages (){
        return   books.stream().anyMatch(b->b.getPages()>=500);
    }
    //ritorna l autore del primo libro per cui e disponibile un ebook
    public Optional<String> getFirstEbookAuthor(){
        return books.stream().filter(Book::isEbookAvailable).map(Book::getAuthor).findFirst();
    }
    //ritorna il numero totale di pagine di tutti i lbri di programmazione
    public int calculateSumPagesOfProgrammingBooksPages(){
        return books.stream().filter(b->b.getGenre().equals("Programming"))
                .mapToInt(Book::getPages)
                .sum();
    }
    //ritorna il massimo rating mai ricevuto tra i libri di un genere che viene dato in input
    public double findMaxRatingBookOfaGenre(String genre){
        return books.stream()
                .filter(b->b.getGenre().equals(genre))
                .mapToDouble(Book::getRating)
                .max()
                .orElse(0);
    }
    //ritorna una stringa composta da tutti i titoli dei libri separati da una virgola
    public Optional<String> listAllTitles (){
        return books.stream().map(Book::getTitle).reduce((s1, s2)->s2 +","+s1).orElse("").describeConstable();
    }
    //ritorna il titolo piu lungo di tutti i libri calcolandolo tramite una reduce
    public Optional<String> findLongestTitle(){
        return books.stream().map(Book::getTitle)
                .reduce((t1,t2)->t1.length()>t2.length()?t1:t2).orElse("").describeConstable();
    }
    //ritorna una mappa in cui la chiave e. il genere e il valore la lista di tutti i libri in quel genere
    public Map<String,List<Book>> mapBooksByGenre(String genre){
        return books.stream().collect(Collectors.groupingBy(Book::getGenre));
    }

    //ritorna un amappa in cui la chaive e il genere e il valore e' il libro piu costoso in quel genere
    public Map<String,Optional<Book>> getMostExpensiveBookByGenre(){
        return books.stream().
                collect(Collectors.groupingBy(Book::getGenre,Collectors
                        .maxBy(Comparator.comparingDouble(Book::getPrice))));

    }

    //ritorna con un solo reduce BookStatistics
    public BookStatistics getBookStatistics() {
        return books.stream().reduce(new BookStatistics(0,0,0),
                (s,b)->{
                 int totalBooks= s.getTotalBooks() +1;
                 double totalPrice = s.getTotalPrice() +b.getPrice();
                 int totalPages = s.getTotalPages() + b.getPages();
                 return new BookStatistics(totalBooks,totalPrice,totalPages);

        },null
     );
    }
    // ritorna la lista dei titoli dei tre libri piu costosi, ma ignorando il piu costoso
    public List<String> getMostExpensiveBooksExeptMostExpensive(){
        return books.stream().sorted(Comparator.comparingDouble(Book::getPrice).reversed())
                .skip(1).limit(3).map(Book::getTitle).toList();
    }
/*
ritorna l alista di libri ordinati prima per genere alfabetico,
 a parita' di genere per rating discendente, a parita di rating per titolo alfabetico
 */
   public List<Book>  sortByGender (){
    return books.stream().sorted(Comparator.comparing(Book::getGenre)
            .thenComparing(Book::getRating).thenComparing(Book::getTitle)).toList();
   }

   //con una sola istruzione di return...  ritorna la lista degli autori che hanno scritto piu di un libro
  public Optional<String> getAuthorsThatWroteMultipleBooks (){
       return books.stream().collect(Collectors.groupingBy(Book::getAuthor));
  }

 }