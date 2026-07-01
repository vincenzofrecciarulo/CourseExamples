package org.generation.italy.examples.oo.lambdaandstreams.exercisepartthree;

public class MovieStatistics {
  private   int totalMovies;
  private   double totalBoxOffice;
  private   int totalMinutes;

    public MovieStatistics(int totalMovies, double totalBoxOffice, int totalMinutes) {
        this.totalMovies = totalMovies;
        this.totalBoxOffice = totalBoxOffice;
        this.totalMinutes = totalMinutes;
    }

    public int getTotalMovies() {
        return totalMovies;
    }

    public double getTotalBoxOffice() {
        return totalBoxOffice;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }
}

