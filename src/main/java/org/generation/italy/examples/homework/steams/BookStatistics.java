package org.generation.italy.examples.homework.steams;


public class BookStatistics {
    private int totalBooks;
    private double totalPrice;
    private int totalPages;

    public void addToTotalBooks(int book){
        totalBooks++;
    }

    public void addToToralPrice(double price){
        totalPrice += price;
    }

    public void addToToralPages(int pages){
        totalPages += pages;
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

