package org.generation.italy.examples.oo.lambdaandstreams.weekExcercise;

import java.util.List;

public class BookStatistic {
    private int totalBooks;
    private double totalPrice;
    private int totalPage;

    public BookStatistic(int totalBooks, double totalPrice, int totalPage) {
        this.totalBooks = totalBooks;
        this.totalPrice = totalPrice;
        this.totalPage = totalPage;
    }

    public BookStatistic() {
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getTotalPage() {
        return totalPage;
    }

    @Override
    public String toString() {
        return "BookStatistic{" +
                "totalBooks=" + totalBooks +
                ", totalPrice=" + totalPrice +
                ", totalPage=" + totalPage +
                '}';
    }
}
