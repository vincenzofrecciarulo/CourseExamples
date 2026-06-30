package org.generation.italy.examples.oo.lambdaandstreams.excercises;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportMaker {
    private List<Coder> coders;

    public ReportMaker(List<Coder> coders) {
        this.coders = coders;
    }
    //crea un metodo che mi restituisce la media di tutti gli stipendi dei dipendenti senior e maschi nella lista coders

    public double vintageSeniorMaleAverageSalary() {
        double sum = 0;
        int count = 0;
        for (Coder c : coders) {
            if (c.isMale() && c.isSenior()) {
                sum += c.getSalary();
                count++;
            }
        }
        return sum / count;
    }
//    public double seniorMaleAverageSalary() {
//        return coders.stream().filter(c-> c.isMale() && c.isSenior())
//                .mapToDouble(Coder::getSalary).average().orElse(0.0);
//    }
//    public double seniorFemaleAverageSalary() {
//        return coders.stream().filter(c-> !c.isMale() && c.isSenior())
//                .mapToDouble(Coder::getSalary).average().orElse(0.0);
//    }
    public double seniorAverageSalary(boolean forMales) {
        return coders.stream().filter(c-> forMales? c.isMale() : !c.isMale() && c.isSenior())
                .mapToDouble(Coder::getSalary).average().orElse(0.0);
    }
    public double seniorAverageSalaryLambda (Predicate<Coder> coderFilter){
        return coders.stream().filter(coderFilter)
                              .filter(Coder::isSenior)
                              .mapToDouble(Coder::getSalary)
                              .average().orElse(0.0);
    }
    public double seniorAverageSalaryLambdaForAge (int age){
        return seniorAverageSalaryLambda(c->c.getAge()>age);
    }
    public boolean worldIsInOrder() {
        double minMale = coders.stream().filter(Coder::isMale)
                               .mapToDouble(Coder::getSalary)
                               .min().orElse(0.0);

        if (minMale == 0) {
            return true;
        }

        double maxFemale = coders.stream().filter(c -> !c.isMale())
                                 .mapToDouble(Coder::getSalary)
                                 .max().orElse(0.0);

        return minMale>=maxFemale;
    }
public List<String> getNameOrderedBySalaryDescending(){
        //return coders.stream().sorted((c1, c2)-> Double.compare(c2.getSalary(), c1.getSalary()))
    return coders.stream().sorted(Comparator.comparingDouble(Coder::getSalary).reversed())
                          .map(Coder::getFullName)
                          .toList();
}// crea funzione che ritorna il coder piu giovane
 public Optional<Coder> getYoungerCoder(){
        return coders.stream().sorted(Comparator.comparingInt(Coder::getAge))
                              .findFirst();
 }
 //crea un metodo che ti trova il primo assunto da una certa data in input
    public Optional<Coder>  getFirstCoderFrom(LocalDate date) {
        return coders.stream().filter(c->c.getHiredate().isAfter(date))
                              .min(Comparator.comparing(Coder::getHiredate));
    }
    // creo un metodo che ritorna la lista di tutti i linguaggi conosciuti dai coder, senza ripetizioni
    public Set<String> getAllLanguages(){
        var s= coders.stream().flatMap(c->c.getLanguagesKnown().stream());
        return s.collect(Collectors.toSet());



    }
    public int howManyDeveloperJava(){
        return (int)coders.stream().filter(c->c.getLanguagesKnown().contains("java"))
                              .count();
    }
    public boolean thersJavaAndaPhytonKnower(){
        return coders.stream().filter(c->c.getLanguagesKnown().contains("java") && c.getLanguagesKnown().contains("phyton"))
                .findAny();
    }
}