package org.generation.italy.examples.oo.librarymanagement;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private double price;
    private int pages;
    private double rating;
    private boolean ebookAvailable;

    public Book(String title, String author, String genre, int publicationYear, double price, int pages, double rating,
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

    //metodi custom
    public boolean isUnderPrice(double price){
        return  this.price < price;
    }

    public boolean getGenreByString(String string) {
        return genre.equals(string);
    }

    public boolean isUnderRating(double rating){
        return this.rating < rating;
    }

    public boolean hasMoreThanPages(int pages){
        return this.pages >= pages;
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
