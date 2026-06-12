package org.generation.italy.examples.oo.lambdaandstreams.exercises2;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private double price;
    private int pages;
    private double rating;
    private boolean eBookAvailable;

    public Book(String title, String author, String genre, int publicationYear, double price, int pages, double rating, boolean eBookAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.price = price;
        this.pages = pages;
        this.rating = rating;
        this.eBookAvailable = eBookAvailable;
    }

    @Override
    public String toString() {  // toString with title only
        return title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public double getRating() {
        return rating;
    }

    public boolean isEbookAvailable() {
        return eBookAvailable;
    }
}
