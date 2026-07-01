package org.generation.italy.examples.oo.lambdaandstreams.exercisepartthree;

public class Movie {
  private   String title, director, genre;
  private   int releaseYear, durationMinutes;
  private   double rating, boxOfficeMillions;
  private   boolean streamingAvailable;

    public Movie(String title, String director, String genre, int releaseYear, int durationMinutes,
                 double rating, double boxOfficeMillions, boolean streamingAvailable) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.durationMinutes = durationMinutes;
        this.rating = rating;
        this.boxOfficeMillions = boxOfficeMillions;
        this.streamingAvailable = streamingAvailable;
    }

    public String getTitle() {
        return title;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public double getBoxOfficeMillions() {
        return boxOfficeMillions;
    }

    public String getDirector() {
        return director;
    }

    public boolean isStreamingAvailable() {
        return streamingAvailable;
    }
}
