package org.generation.italy.examples.oo.excerciseslambda.movie;

import java.util.List;

public class Movie {
    String title, director, genre;
    int releaseYear, durationMinutes;
    double rating, boxOfficeMillions;
    boolean streamingAvailable;

    public Movie(String title, String director, String genre, int releaseYear, int durationMinutes, double rating, double boxOfficeMillions, boolean streamingAvailable) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.durationMinutes = durationMinutes;
        this.rating = rating;
        this.boxOfficeMillions = boxOfficeMillions;
        this.streamingAvailable = streamingAvailable;
    }

    static List<Movie> movies = List.of(
            new Movie("Inception", "Nolan", "Sci-Fi", 2010, 148, 4.8, 836.8, true),
            new Movie("The Godfather", "Coppola", "Crime", 1972, 175, 4.9, 245.1, false),
            new Movie("Interstellar", "Nolan", "Sci-Fi", 2014, 169, 4.7, 701.7, true),
            new Movie("Pulp Fiction", "Tarantino", "Crime", 1994, 154, 4.6, 213.9, true),
            new Movie("The Dark Knight", "Nolan", "Action", 2008, 152, 4.9, 1004.6, true),
            new Movie("Parasite", "Bong", "Thriller", 2019, 132, 4.5, 258.8, false),
            new Movie("Django Unchained", "Tarantino", "Western", 2012, 165, 4.4, 425.4, true),
            new Movie("Oppenheimer", "Nolan", "Drama", 2023, 180, 4.6, 952.0, false)
    );

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public double getRating() {
        return rating;
    }

    public double getBoxOfficeMillions() {
        return boxOfficeMillions;
    }

    public boolean isStreamingAvailable() {
        return streamingAvailable;
    }

    public static List<Movie> getMovies() {
        return movies;
    }
}
