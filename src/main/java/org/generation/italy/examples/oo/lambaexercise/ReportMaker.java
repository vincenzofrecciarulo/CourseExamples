package org.generation.italy.examples.oo.lambaexercise;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportMaker {
    private List<Coder> coders;

    public ReportMaker(List<Coder> coders) {
        this.coders = coders;
    }

    public double getTotalSeniorMaleAverageSalary() {
        double sum = 0;
        int count = 0;
        for (Coder c : coders) {
            if (c.getGender() == 'm' && c.isSenior()) {
                sum += c.getSalary();
                count++;
            }
        }
        return sum/count;
    }

/*    public double seniorMaleAverageSalary() {
        return coders.stream().filter(c -> c.isMale() && c.isSenior())
                .mapToDouble(Coder::getSalary).average().orElse(0.0);
    }

    public double seniorFemaleAverageSalary() {
        return coders.stream().filter(c -> !c.isMale() && c.isSenior())
                .mapToDouble(Coder::getSalary).average().orElse(0.0);
    }
*/
    public double seniorAverageSalary(boolean forMales) {
        return coders.stream().filter(c -> forMales ? c.isMale() : !c.isMale() && c.isSenior())
                .mapToDouble(Coder::getSalary).average().orElse(0.0);
    }

    public double seniorAverageSalaryLambda (Predicate<Coder> coderFilter) {
        return coders.stream().filter(coderFilter)
                .filter(Coder::isSenior)
                .mapToDouble(Coder::getSalary)
                .average().orElse(0.0);
    }

    public double seniorAverageSalaryLambdaForAge(int age) {
        return seniorAverageSalaryLambda(c -> c.getAge()>age);
    }

    public boolean WorldIsInOrder() {
        double minMale = coders.stream().filter(Coder::isMale)
                .mapToDouble(Coder::getSalary)
                .min().orElse(0.0);
        if (minMale == 0) {
            return true;
        }

        double maxFemale = coders.stream().filter(c -> !c.isMale())
                .mapToDouble(Coder::getSalary)
                .max().orElse(0.0);
        return minMale>maxFemale;
    }

    //Crea una funzione che ritorna nome e cognome di tutti i coder ordinati
    // per il salario

    public List<String> getNamesBySalaryDescending() {
     //   return coders.stream().sorted((c1, c2) -> Double.compare(c2.getSalary(), c1.getSalary()));
          return coders.stream().sorted(Comparator.comparingDouble(Coder::getSalary).reversed())
                                .map (Coder::getFullName)
                                .toList();
    }

    //facciamo una funzione che ritorna il mio coder piu giovane.
    public Optional<Coder> getYoungerCoder() {
        return coders.stream().sorted(Comparator.comparingDouble(Coder::getAge))
                              .findFirst();
    }
    public Optional<Coder> getYoungerCoder1() {
        return coders.stream().min(Comparator.comparingInt(Coder::getAge));
    }

    //crea un metodo che trova il primo coder assunto dopo una certa data, che il
    // metodo riceve in input
    public Optional<Coder> getFirstCoderFrom(LocalDate date) {
        return coders.stream().filter(c -> c.getHiredate().isAfter(date))
                              .min(Comparator.comparing(Coder::getHiredate));
    }

    //crea un metodo che ritorna la lista di tutti i linguaggi conosciuti dai miei
    // coders, senza ripetizioni.
    public Set<String> getAllLanguages() {
        var s = coders.stream().flatMap(c -> c.getLanguagesKnown().stream());
        return s.collect(Collectors.toSet());
    }

    //quanti sviluppatori java abbiamo nella lista
    public int howManyJavaCoders() {
 //       return (int)coders.stream().filter(c -> c.getLanguagesKnown().contains("Java"))
 //                             .count();
    return (int)coders.stream().flatMap(c -> c.getLanguagesKnown().stream())
                                .filter(s -> s.equals("Java"))
                                .count();
    }

    //voglio sapere se abbiamo almeno un programmatore che conosce sia Java che Python
    public boolean someoneKnowsJavaAndPython() {
 //       return coders.stream().filter(c -> c.getLanguagesKnown().contains("java") &&
 //               c.getLanguagesKnown().contains("Python")).findAny().isPresent();
        return coders.stream().anyMatch(c -> c.knowsAll("Java", "Python"));
    }

    //crea una funzione che raggruppi gli studenti per genere
    public Map<Character, List<Coder>> groupBySex() {
        return coders.stream().collect(Collectors.groupingBy(Coder::getGender));
    }

    //metodo che ritorna una mappa di sessi e numero di sviluppatori che hanno quel sesso
    public Map<Character, Long> countBySex() {
        return coders.stream().collect(Collectors.groupingBy(Coder::getGender, Collectors.counting()));
    }

    //crea un metodo che con una sola iterazione mi crea un oggetto report che contiene il totale
    // dei salari per i maschi e per le femmine

    public SalaryReport calculateSalaryReport() {
  /*    SalaryReport sr = new SalaryReport();
        for (Coder c : coders) {
            if (c.isMale()) {
                sr.addToMaleSalary(c.getSalary());
            } else {
                sr.addToFemaleSalary(c.getSalary());
            }
        }
        return sr; */
        return coders.stream().reduce(
                new SalaryReport(),
                (report,coder) -> {
                    if (coder.isMale()) {
                        report.addToMaleSalary(coder.getSalary());
                    } else {
                        report.addToFemaleSalary(coder.getSalary());
                    }
                    return report;
                }, null
        );
    }

}

