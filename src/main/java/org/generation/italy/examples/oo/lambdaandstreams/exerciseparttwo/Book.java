package org.generation.italy.examples.oo.lambdaandstreams.exerciseparttwo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Book {
    private String title;
    private String author;
    private  String genre;
    private int publicationYear;
    private double price;
    private int pages;
    private double rating;
    private boolean ebookAvailable;


    public String getGenre() {
        return genre;
    }

    public Book(String title, String author, String genre, int publicationYear, double price, int pages, double rating, boolean ebookAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.price = price;
        this.pages = pages;
        this.rating = rating;
        this.ebookAvailable = ebookAvailable;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public boolean isEbookAvailable() {
        return ebookAvailable;
    }

    public String getAuthor() {
        return author;
    }

    public double comparePrices(double amount){
         return price - amount;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                ", pages=" + pages +
                ", rating=" + rating +
                ", ebookAvailable=" + ebookAvailable +
                '}';
    }
}

