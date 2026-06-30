package org.generation.italy.examples.oo.excerciseslambda.movie;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MovieExcercises {

    public List<String> getMovieTitles(List<Movie> movies) {
        return movies.stream()
                .map(Movie::getTitle)
                .toList();
    }
    public List<Movie> getLongMovies(List<Movie> movies) {
        return movies.stream()
                .filter(movie -> movie.getDurationMinutes() > 160)
                .toList();
    }
    public long countByGenre(List<Movie> movies, String genre) {
        return movies.stream()
                .filter(movie -> movie.getGenre().equals(genre))
                .count();
    }
    public List<Movie> sortedByRatingDescending(List<Movie> movies) {
        return movies.stream()
                .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
                .toList();
    }
    public List<String> titlesByYear(List<Movie> movies){
        return movies.stream()
                .sorted(Comparator.comparingInt(Movie::getReleaseYear))
                .map(Movie::getTitle)
                .toList();
    }
    public Optional<Movie> getHighestBoxOffice(List<Movie> movies) {
        return movies.stream()
                .max(Comparator.comparingDouble(Movie::getBoxOfficeMillions));

    }
    public boolean allRatedAbove (List<Movie> movies, double treshold){
        return movies.stream()
                .allMatch(c->c.getRating()>treshold);
    }
    public boolean anyLongerThan(List<Movie> movies, int minutes){
        return movies.stream()
                .anyMatch(c->c.getDurationMinutes()>minutes);
    }
    public Optional<String> firstStreamingDirector(List<Movie> movies) {
        return movies.stream()
                .filter(Movie::isStreamingAvailable)
                .map(Movie::getDirector)
                .findFirst();
    }
}
