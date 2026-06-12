package org.generation.italy.examples.oo.lambdaandstreams.exercises;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportMaker {
    private List<Developer> developers;

    public ReportMaker(List<Developer> developers) {
        this.developers = developers;
    }

    // we write a method that returns the sum of all male senior developers' salaries
    // this is the old way, without Streams
//    public double oldTotSeniorMaleAverageSalary() {
//        double sum = 0;
//        int count = 0;
//        for (Developer d : developers) {
//            if (d.getGender().equalsIgnoreCase("m") && d.isSenior()) {
//                sum += d.getSalary();
//                count++;
//            }
//        }
//        return sum/count;
//    }
//
//    public double seniorMaleAverageSalary() {
//        return developers.stream()
//                .filter(d -> d.isMale() && d.isSenior())
//                .mapToDouble(Developer::getSalary)   // SUPER IMPORTANT SHORTCUT for when we do x -> x.method or x -> f(x)
//                .average()                                       // DoubleStream method
//                .orElse(0.0);
//    }

    public double seniorAverageSalary(boolean forMales) {
        return developers.stream()
                .filter(d -> forMales ? d.isMale() : !d.isMale() && d.isSenior())
                .mapToDouble(Developer::getSalary)   // SUPER IMPORTANT SHORTCUT for when we do x -> x.method or x -> f(x)
                .average()                                       // DoubleStream method
                .orElse(0.0);
    }

    // another really intere
    public double seniorAverageSalaryLambda(Predicate<Developer> developerFilter) {
        return developers.stream().filter(developerFilter).filter(Developer::isSenior)
                .mapToDouble(Developer::getSalary)
                .average()
                .orElse(0.0);
    }

    public double seniorAverageSalaryLambdaForAge(int ageThreshold) {
        return seniorAverageSalaryLambda(d -> d.getAge() > ageThreshold);
    }

    // this always returns true if there are 0 males or 0 females
    public boolean isMinimumMaleSalaryMoreThanMaximumFemaleSalary() {
        double minMaleSalary = developers.stream()
                .filter(Developer::isMale)
                .mapToDouble(Developer::getSalary)
                .min()
                .orElse(0.0);
        if (minMaleSalary == 0) return true;
        double maxFemaleSalary = developers.stream()
                .filter(d -> !d.isMale())
                .mapToDouble(Developer::getSalary)
                .max()
                .orElse(0.0);
        if (maxFemaleSalary == 0) return true;
        return minMaleSalary > maxFemaleSalary;
    }

    // returns all Developers names ordered by descending salary
    public List<String> getNamesOrderedByDescendingSalary() {
//        return developers.stream().sorted((d1, d2) -> Double.compare(d2.getSalary(), d1.getSalary()));
        return developers.stream()
                .sorted(Comparator.comparingDouble(Developer::getSalary).reversed())  // default order: ascending. we need the opposite, so we reverse
                .map(Developer::getFullName)          // we TRANSFORM the STREAM TYPE! From Developer to String
                .toList();

    }

    public Optional<Developer> getYoungestDeveloperAlternative() {
        return developers.stream()
                .sorted(Comparator.comparingInt(Developer::getAge))
                .findFirst();
    }

    // same as above
    public Optional<Developer> getYoungestDeveloper() {
        return developers.stream().min(Comparator.comparingInt(Developer::getAge));
    }

    // finds the first Developer hired after date
    public Optional<Developer> getDeveloperHiredAfter(LocalDate date) {
        return developers.stream()
                .filter(d -> d.getHiringDate().isAfter(date))
                .min(Comparator.comparing(Developer::getHiringDate));    // ascending order by default, so we get the 1st
    }

//    // a method that returns a list of all the languages known by all Developers, without duplicates
//    public List<String> getAllLanguages() {
//        return developers.stream()
//                .flatMap(d -> d.getKnownLanguages().stream())    // map would give A STREAM OF LISTS, with flatMap WE FLATTEN THEM. this needs to be STREAMED too, after
//                .distinct()
//                .toList();
//    }

    // same as above. Set is kinda better semantically, but we may need List too
    public Set<String> getAllLanguages() {
        return developers.stream()
                .flatMap(d -> d.getKnownLanguages().stream())    // map would give A STREAM OF LISTS, with flatMap WE FLATTEN THEM. this needs to be STREAMED too, after
                .collect(Collectors.toSet());                            // we make a Collection
    }

    // returns all Java Developers
//    public int howManyJavaCoders() {
//            return (int)developers.stream()
//                    .filter(d -> d.getKnownLanguages().contains("Java"))
//                    .count();
//    }

    // same as above, but using flatMap
    public int howManyJavaCoders() {
            return (int)developers.stream()
                    .flatMap(d -> d.getKnownLanguages().stream())  // converting to a stream of Strings (inside each Developer list of known languages)
                    .filter(s -> s.equals("Java"))
                    .count();
    }

//    public boolean atLeastOneJavaAndPythonDev() {
//        return developers.stream()
//                .filter(c -> c.getKnownLanguages().contains("Java")
//                && c.getKnownLanguages().contains("Python"))
//                .findAny()
//                .isPresent();
//    }

    // same as above, but more concise
    public boolean atLeastOneJavaAndPythonDev() {
        return developers.stream()
                .anyMatch(d -> d.knowsAll("Java", "Python"));
    }

    // returns Developers by gender, it should return a Map with gender as keys and Developers as values
    public Map<String, List<Developer>> groupByGender() {
        return developers.stream()
                .collect(Collectors.groupingBy(Developer::getGender));   // this automatically creates the Map. cool
    }

    // returns a Map with genders as keys, and the numbers of developers of that gender
    public Map<String, Long> countByGender() {
        return developers.stream()
                // there are groupingBy overloads. the one we use here takes the grouping element
                // like the one above, and ALSO an algorithm (we usually use Collectors methods) to apply on EACH GROUP
                .collect(Collectors.groupingBy(Developer::getGender, Collectors.counting()));
    }

    // creates, in a single operation, a SalaryReport object that contains total salaries for both males and females
//    public SalaryReport calculateSalaryReport() {
//        SalaryReport sr = new SalaryReport();
//        for (Developer d : developers) {
//            if (d.isMale()) {
//                sr.addToFemaleSalary(d.getSalary());
//            } else {
//                sr.addToFemaleSalary(d.getSalary());
//            }
//        }
//        return sr;
//    }

    // same as above, but with Streams
    public SalaryReport calculateSalaryReport() {
        return developers.stream()
                // there are 3 reduce() methods
                // this one takes 3 args, here it takes SalaryReport,
                // the Coder and the "refreshed" SalaryReport
                .reduce(
                        new SalaryReport(),
                        ((report, developer) -> {
                            if (developer.isMale()) {
                                report.addToMaleSalary(developer.getSalary());
                            } else {
                                report.addToFemaleSalary(developer.getSalary());
                            }
                            return report;
                        }), null
                );
    }
}
