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

        public BookStatistics() {
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

