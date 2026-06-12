package org.generation.italy.examples.homework.steams;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private double price;
    private int pages;
    private double rating;
    private boolean ebookAvailable;

    public Book(
            String title,
            String author,
            String genre,
            int publicationYear,
            double price,
            int pages,
            double rating,
            boolean ebookAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.price = price;
        this.pages = pages;
        this.rating = rating;
        this.ebookAvailable = ebookAvailable;
    }


    public int isMoreExpensiveThan(Book other){
        return Double.compare(this.price, other.price);
    }

    public int isOlderThan(Book other){
        return other.publicationYear - this.publicationYear;
    }

    public int hasHigherRatingThan(Book other){
        return Double.compare(this.rating, other.rating);
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
        return ebookAvailable;
    }
}
