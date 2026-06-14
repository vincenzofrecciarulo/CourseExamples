package org.generation.italy.examples.oo.excerciseslambda;

public class BookStatistics {
    int totalBooks;
    double totalPrice;
    int totalPages;

    public BookStatistics(int totalBooks, double totalPrice, int totalPages) {
        this.totalBooks = totalBooks;
        this.totalPrice = totalPrice;
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "BookStatistics{totalBooks=" + totalBooks +
                ", totalPrice=" + totalPrice +
                ", totalPages=" + totalPages + "}";
    }
}
