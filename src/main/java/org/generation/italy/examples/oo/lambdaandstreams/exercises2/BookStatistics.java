package org.generation.italy.examples.oo.lambdaandstreams.exercises2;

import java.util.List;

public class BookStatistics {
    private final int totalBooks;
    private final double totalPrice;
    private final int totalPages;

    public BookStatistics(int totalBooks, double totalPrice, int totalPages) {
        this.totalBooks = totalBooks;
        this.totalPrice = totalPrice;
        this.totalPages = totalPages;
    }

    public static BookStatistics getStats(List<Book> books) {
        return books.stream()
                .reduce(
                        new BookStatistics(0, 0, 0),
                        BookStatistics::accumulate,
                        BookStatistics::combine
                );
    }

    public BookStatistics accumulate(Book book) {
        return new BookStatistics(
                this.totalBooks + 1,
                this.totalPrice + book.getPrice(),
                this.totalPages + book.getPages()
        );
    }

    public BookStatistics combine(BookStatistics other) {
        return new BookStatistics(
                this.totalBooks + other.totalBooks,
                this.totalPrice + other.totalPrice,
                this.totalPages + other.totalPages
        );
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getTotalPages() {
        return totalPages;
    }

    @Override
    public String toString() {
        return "BookStatistics{" +
                "totalBooks=" + totalBooks +
                ", totalPrice=" + totalPrice +
                ", totalPages=" + totalPages +
                '}';
    }
}
