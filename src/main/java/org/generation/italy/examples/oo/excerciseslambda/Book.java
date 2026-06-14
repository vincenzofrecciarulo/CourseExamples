package org.generation.italy.examples.oo.excerciseslambda;

public record Book(
        String title,
        String author,
        String genre,
        int publicationYear,
        double price,
        int pages,
        double rating,
        boolean ebookAvailable) {
}