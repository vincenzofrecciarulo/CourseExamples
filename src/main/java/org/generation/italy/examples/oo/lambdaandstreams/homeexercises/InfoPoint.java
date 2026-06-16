package org.generation.italy.examples.oo.lambdaandstreams.homeexercises;

import java.util.List;

public class InfoPoint {
    public static void main(String[] args) {
        Library library = new Library();


        System.out.println("\n--- Titoli ---");
        library.getTitles().forEach(System.out::println);

        System.out.println("\n--- Sotto 20€ ---");
        library.getBooksUnder20golds().forEach(System.out::println);

        System.out.println("\n--- Programming books ---");
        System.out.println(library.getProgrammingBooks());

        System.out.println("\n--- Per prezzo ---");
        library.getPriceOrderedBooks().forEach(System.out::println);

        System.out.println("\n--- Per data ---");
        library.getDateOrderedBooks().forEach(System.out::println);

        System.out.println("\n--- Libro più costoso ---");
        System.out.println(library.getHighestPriceBook());

        System.out.println("\n--- Rating alto per tutti ---");
        System.out.println(library.isRatingGood());

        System.out.println("\n--- Almeno uno grande ---");
        System.out.println(library.atLeastOneIsBig());

        System.out.println("\n--- Primo autore con Ebook ---");
        System.out.println(library.authorWithEbook());

        System.out.println("\n--- Pagine totali dei libri di programmazione ---");
        System.out.println(library.totPagesNumberOfAllProgrammingBooks());

        System.out.println("\n--- Rating massimo per genere da te scelto ---");
        String choosenGenre = IO.readln("Dammi un genere: ");
        System.out.println(library.maxRatingPerGenre(choosenGenre));

        System.out.println("\n--- Libri in una sola stringa ---");
        System.out.println(library.getTitlesInString());

        System.out.println("\n--- Libro col titolo più lungo ---");
        System.out.println(library.longestTitleBook());

        System.out.println("\n--- Lista di libri per genere ---");
        library.getBooksByGenre().forEach((genre, bookList) -> {
            System.out.println(genre + ":");
            bookList.forEach(System.out::println);
        });

        System.out.println("\n--- Libro più costoso per genere ---");
        library.getHighestPriceBookByGenre().forEach((g, book) -> {
            System.out.println(g + " → " + book);
        });
    }
}
