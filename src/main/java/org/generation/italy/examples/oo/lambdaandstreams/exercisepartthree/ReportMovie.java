package org.generation.italy.examples.oo.lambdaandstreams.exercisepartthree;

import java.util.*;
import java.util.stream.Collectors;

public class ReportMovie {

  private  List<Movie> movieList = new ArrayList<>();

  public  List<String> getTitles(){
       return   movieList.stream().map(Movie::getTitle).toList();
    }

  public  List<Movie> getLongMovies(){
        return movieList.stream().filter(m->m.getDurationMinutes()>160).toList();
    }
  public long countByGenre( String genre) {
     return movieList.stream().filter(m->m.getGenre().equals(genre)).count();
}

   public List<Movie> sortedByRating(){
      return movieList.stream().sorted(Comparator.comparingDouble(Movie::getRating).reversed()).toList();
   }

   public Optional<Movie> getHighestGrossing(){
      return movieList.stream().max(Comparator.comparingDouble(Movie::getBoxOfficeMillions));
   }
  public boolean allRatedAbove( double threshold){
     return movieList.stream().allMatch(m->m.getRating()>threshold);
  }
 public boolean anyLongerThan( int minutes){
      return movieList.stream().anyMatch(m->m.getDurationMinutes()>minutes);
 }

 public Optional<String> firstStreamableDirector(){
      return movieList.stream().filter(Movie::isStreamingAvailable).map(Movie::getDirector).findFirst().orElse("").describeConstable();
 }

public int totalMinutesByGenre( String genre){
      return (int) movieList.stream()
              .filter(m->m.getGenre().equals(genre))
              .map(Movie::getDurationMinutes)
              .count();
}

public double maxBoxOfficeByGenre(String genre){
      return movieList.stream()
              .filter(m->m.getGenre().equals(genre))
              .mapToDouble(Movie::getBoxOfficeMillions)
              .max()
              .orElse(0);
}

 public String titlesJoined(){
     return movieList.stream()
             .map(Movie::getTitle)
             .reduce((s1,s2)->s1 +","+s2).orElse("");

 }

 public String longestTitle(){
      return movieList.stream()
              .map(Movie::getTitle)
              .reduce((t1,t2)->t1.length()>t2.length()?t1:t2).orElse("");
 }

public Map<String, List<Movie>> groupByGenre(){
      return movieList.stream()
              .collect(Collectors.groupingBy(Movie::getGenre));
}

  public Map<String, Optional<Movie>> mostProfitableByGenre(){
      return movieList.stream()
              .collect(Collectors.groupingBy(Movie::getGenre,Collectors
                      .maxBy(Comparator.comparingDouble(Movie::getBoxOfficeMillions))));
    }

    public MovieStatistics computeStats(){
        return movieList.stream()
                .reduce(new MovieStatistics(0,0,0),(s,m)->{
                    int totalMovies = s.getTotalMovies()+1;
                    double totalBoxOffice = s.getTotalBoxOffice() + m.getBoxOfficeMillions();
                    int totalMinutes = s.getTotalMinutes() + m.getDurationMinutes();
                    return  new MovieStatistics(totalMovies,totalBoxOffice,totalMinutes);
                },null);
    }
  public List<String> top3ExcludingBest(){
      return movieList.stream()
              .sorted(Comparator.comparingInt(Movie::getDurationMinutes).reversed())
              .skip(1)
              .limit(3)
              .map(Movie::getTitle)
              .toList();
  }
  public List<Movie> sortedMultiCriteria(){
     return  movieList.stream()
               .sorted(Comparator.comparing(Movie::getGenre)
                       .thenComparing(Comparator.comparingDouble(Movie::getRating).reversed())
                       .thenComparing(Comparator.comparing(Movie::getTitle)))
               .toList();
  }

  public List<String> directorsWithMultipleMovies(){
      return movieList.stream()
              .collect(Collectors.groupingBy(Movie::getDirector,Collectors.counting()))
              .entrySet().stream()
              .filter(k->k.getValue()>1)
              .map(Map.Entry::getKey)
              .toList();
  }

}
