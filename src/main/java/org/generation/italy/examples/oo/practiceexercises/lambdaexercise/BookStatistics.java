package org.generation.italy.examples.oo.practiceexercises.lambdaexercise;

public class BookStatistics {
        private int totalBooks;
        private double totalPrice;
        private int totalPages;

        public BookStatistics(int totalBooks, double totalPrice, int totalPages) {
                this.totalBooks = totalBooks;
                this.totalPrice = totalPrice;
                this.totalPages = totalPages;
        }

        public int getTotalBooks(int book) {
                return totalBooks+=book;
        }

        public double getTotalPrice(double price) {
                return totalPrice+=price;
        }

        public int getTotalPages(int pages) {
                return totalPages+pages;
        }
}
