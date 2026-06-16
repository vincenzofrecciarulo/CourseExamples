package org.generation.italy.examples.oo.lambdaandstreams.homeexercises;

public class BookStatistics {
    int totalBooks;
    double totalPrice;
    int totalPages;

    public BookStatistics(int totalBooks, double totalPrice, int totalPages) {
        this.totalBooks = totalBooks;
        this.totalPrice = totalPrice;
        this.totalPages = totalPages;
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
}
