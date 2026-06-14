package org.generation.italy.examples.oo.excerciseslambda;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class BookExercises {

    public static List<String> getTitles(List<Book> books) {
        return books.stream()
                .map(Book::title)
                .toList();
    }

    public static List<String> getTitlesCheaperThan20(List<Book> books) {
        return books.stream()
                .filter(b -> b.price() < 20)
                .map(Book::title)
                .toList();
    }

    public static long countProgrammingBooks(List<Book> books) {
        return books.stream()
                .filter(b -> b.genre().equals("Programming"))
                .count();
    }

    public static List<Book> sortedByPriceAscending(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::price))
                .toList();
    }

    public static List<String> titlesSortedByYearDescending(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::publicationYear).reversed())
                .map(Book::title)
                .toList();
    }

    public static Optional<Book> getMostExpensive(List<Book> books) {
        return books.stream()
                .max(Comparator.comparingDouble(Book::price));
    }

    public static boolean allRatingAbove4(List<Book> books) {
        return books.stream()
                .allMatch(b -> b.rating() > 4);
    }

    public static boolean anyBookOver500Pages(List<Book> books) {
        return books.stream()
                .anyMatch(b -> b.pages() >= 500);
    }

    public static Optional<String> firstEbookAuthor(List<Book> books) {
        return books.stream()
                .filter(Book::ebookAvailable)
                .map(Book::author)
                .findFirst();
    }

    public static int totalPagesProgramming(List<Book> books) {
        return books.stream()
                .filter(b -> b.genre().equals("Programming"))
                .mapToInt(Book::pages)
                .sum();
    }

    public static OptionalDouble maxRatingByGenre(List<Book> books, String genre) {
        return books.stream()
                .filter(b -> b.genre().equals(genre))
                .mapToDouble(Book::rating)
                .max();
    }

    // --- Nuovi metodi ---

    public static String joinTitles(List<Book> books) {
        return books.stream()
                .map(Book::title)
                .collect(Collectors.joining(", "));
    }

    public static Optional<String> longestTitle(List<Book> books) {
        return books.stream()
                .map(Book::title)
                .reduce((a, b) -> a.length() >= b.length() ? a : b);
    }

    public static Map<String, List<Book>> booksByGenre(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::genre));
    }

    public static Map<String, Optional<Book>> mostExpensiveByGenre(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(
                        Book::genre,
                        Collectors.maxBy(Comparator.comparingDouble(Book::price))
                ));
    }

    public static BookStatistics computeStatistics(List<Book> books) {
        return books.stream()
                .reduce(
                        new BookStatistics(0, 0.0, 0),
                        (stats, book) -> new BookStatistics(
                                stats.totalBooks + 1,
                                stats.totalPrice + book.price(),
                                stats.totalPages + book.pages()
                        ),
                        (s1, s2) -> new BookStatistics(
                                s1.totalBooks + s2.totalBooks,
                                s1.totalPrice + s2.totalPrice,
                                s1.totalPages + s2.totalPages
                        )
                );
    }

    // ordina per prezzo desc, salta il primo (più costoso), prende i 3 successivi
    public static List<String> top3TitlesExcludingMostExpensive(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::price).reversed())
                .skip(1)
                .limit(3)
                .map(Book::title)
                .toList();
    }

    public static List<Book> sortedByGenreThenRatingThenTitle(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparing(Book::genre)
                        .thenComparing(Comparator.comparingDouble(Book::rating).reversed())
                        .thenComparing(Book::title))
                .toList();
    }

    public static List<String> authorsWithMultipleBooks(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::author, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }
}