package org.generation.italy.examples.oo.lambdaandstreams.exercises2;

import java.util.List;

public class Main {
    void main() {
        List<Book> books = List.of(
                new Book("The Hobbit", "Tolkien", "Fantasy", 1937, 14.90, 310, 4.8, true),
                new Book("Dune", "Herbert", "Science Fiction", 1965, 18.50, 540, 4.7, false),
                new Book("Clean Code", "Martin", "Programming", 2008, 39.90, 464, 4.5, true),
                new Book("1984", "Orwell", "Dystopian", 1949, 12.50, 328, 4.6, true),
                new Book("The Pragmatic Programmer", "Hunt", "Programming", 1999, 42.00, 352, 4.7, true),
                new Book("Foundation", "Asimov", "Science Fiction", 1951, 15.00, 255, 4.4, false),
                new Book("Harry Potter", "Rowling", "Fantasy", 1997, 20.00, 410, 4.9, true),
                new Book("Effective Java", "Bloch", "Programming", 2018, 48.00, 416, 4.8, true)
        );

        IO.println("All titles: " + BookService.getTitles(books));
        IO.println("All titles under 20 dollars: " + BookService.getTitlesUnder20(books));
        IO.println("Number of titles on Programming: " + BookService.getNumberByGenre(books, "programming"));
        IO.println("All books by ascending price: " + BookService.getByAscendingPrice(books));
        IO.println("All books by descending publication year (most recent first): " + BookService.getTitlesByDescendingPublicationYear(books));
        IO.println("Most expensive book: " + BookService.getMostExpensive(books));
        IO.println("Do all books have a minimum rating of 4: " + BookService.allMinimumRating(books, 4));
        IO.println("Do any of the books have at least 500 pages: " + BookService.anyMinimumPages(books, 500));
        IO.println("Author of the first book available as an ebook: " + BookService.getFirstAvailableEbookAuthor(books));
    }
}
