package org.generation.italy.examples.oo.excerciseslambda;

import java.util.List;

public class BookMain {

    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("The Hobbit", "Tolkien", "Fantasy", 1937, 14.90, 310, 4.8, true),
                new Book("Dune", "Herbert", "Science Fiction", 1965, 18.50, 540, 4.7, false),
                new Book("Clean Code", "Martin", "Programming", 2008, 39.90, 464, 4.5, true),
                new Book("1984", "Orwell", "Dystopian", 1949, 12.50, 328, 4.6, true),
                new Book("The Pragmatic Programmer", "Hunt", "Programming", 1999, 42.00, 352, 4.7, true),
                new Book("Foundation", "Asimov", "Science Fiction", 1951, 15.00, 255, 4.4, false),
                new Book("Harry Potter", "Rowling", "Fantasy", 1997, 20.00, 410, 4.9, true),
                new Book("Effective Java", "Bloch", "Programming", 2018, 48.00, 416, 4.8, true)
        );

        System.out.println("Tutti i titoli:");
        System.out.println(BookExercises.getTitles(books));

        System.out.println("\nTitoli che costano meno di 20€:");
        System.out.println(BookExercises.getTitlesCheaperThan20(books));

        System.out.println("\nNumero di libri di programmazione:");
        System.out.println(BookExercises.countProgrammingBooks(books));

        System.out.println("\nLibri ordinati per prezzo crescente:");
        BookExercises.sortedByPriceAscending(books)
                .forEach(b -> System.out.printf("  %s - %.2f€%n", b.title(), b.price()));

        System.out.println("\nTitoli ordinati per anno (più recenti prima):");
        System.out.println(BookExercises.titlesSortedByYearDescending(books));

        System.out.println("\nLibro più costoso:");
        BookExercises.getMostExpensive(books)
                .ifPresent(b -> System.out.printf("  %s - %.2f€%n", b.title(), b.price()));

        System.out.println("\nTutti i libri hanno rating > 4:");
        System.out.println(BookExercises.allRatingAbove4(books));

        System.out.println("\nAlmeno un libro ha 500+ pagine:");
        System.out.println(BookExercises.anyBookOver500Pages(books));

        System.out.println("\nAutore del primo libro disponibile come ebook:");
        BookExercises.firstEbookAuthor(books).ifPresent(System.out::println);

        System.out.println("\nTotale pagine libri di programmazione:");
        System.out.println(BookExercises.totalPagesProgramming(books));

        System.out.println("\nRating massimo tra i libri Fantasy:");
        BookExercises.maxRatingByGenre(books, "Fantasy")
                .ifPresent(r -> System.out.println("  " + r));

        System.out.println("\nTitoli separati da virgola:");
        System.out.println(BookExercises.joinTitles(books));

        System.out.println("\nTitolo più lungo (via reduce):");
        BookExercises.longestTitle(books).ifPresent(System.out::println);

        System.out.println("\nLibri raggruppati per genere:");
        BookExercises.booksByGenre(books)
                .forEach((genre, list) -> System.out.println("  " + genre + ": " + list.stream().map(Book::title).toList()));

        System.out.println("\nLibro più costoso per genere:");
        BookExercises.mostExpensiveByGenre(books)
                .forEach((genre, opt) -> opt.ifPresent(b ->
                        System.out.printf("  %s: %s (%.2f€)%n", genre, b.title(), b.price())));

        System.out.println("\nStatistiche (via reduce):");
        System.out.println(BookExercises.computeStatistics(books));

        System.out.println("\nTop 3 titoli più costosi (escluso il più costoso):");
        System.out.println(BookExercises.top3TitlesExcludingMostExpensive(books));

        System.out.println("\nLibri ordinati per genere, rating desc, titolo:");
        BookExercises.sortedByGenreThenRatingThenTitle(books)
                .forEach(b -> System.out.printf("  %-20s %-15s %.1f%n", b.title(), b.genre(), b.rating()));

        System.out.println("\nAutori con più di un libro:");
        List<String> multiAuthors = BookExercises.authorsWithMultipleBooks(books);
        System.out.println(multiAuthors.isEmpty() ? "  (nessuno nella lista attuale)" : multiAuthors);
    }
}