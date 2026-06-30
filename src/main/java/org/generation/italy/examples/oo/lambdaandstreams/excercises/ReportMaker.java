package org.generation.italy.examples.oo.lambdaandstreams.excercises;

import java.time.LocalDate;
import java.util.*;
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
    //crea un metodo che ritorna nome e cognome di tutti i coder, ordinati per il salario
    public List<String> getNamesOrderedBySalaryDescendig(){
       // return coders.stream().sorted((c1, c2) -> Double.compare(c2.getSalary(), c1.getSalary()))
        return coders.stream().sorted(Comparator.comparingDouble(Coder::getSalary).reversed())
                              .map(Coder::getFullName)
                              .toList();
    }
    //crea una funzione che ritorna il coder più giovane
    public Optional<Coder> getYoungerCoder(){
        return coders.stream().sorted(Comparator.comparingInt(Coder::getAge))
                              .findFirst();
    }
    public Optional<Coder> getYoungerCoder2(){
        return coders.stream().min(Comparator.comparingInt(Coder::getAge));
    }
    //crea un metodo che trova il primo coder assunto dopo una certa data, che il metodo riceve in input
    public Optional<Coder> getFirstCoderFrom(LocalDate date){
        return coders.stream().filter(c->c.getHiredate().isAfter(date))
                              .min(Comparator.comparing(Coder::getHiredate));
    }
    //creo un metodo che ritorna la lista di tutti i libguaggi conosciuti dai coder, senza ripetizioni
    public Set<String> getAllLanguages(){
        var s = coders.stream().flatMap(c->c.getLanguagesKnown().stream());
        //return s.distinct().toList();
        return s.collect(Collectors.toSet());
    }
    public int howManyJavaCoders(){
//        return (int) coders.stream().filter(c->c.getLanguagesKnown().contains("java"))
//                              .count();
        return (int) coders.stream().flatMap(c->c.getLanguagesKnown().stream())
                              .filter(s-> s.equals("java"))
                              .count();
    }
    public boolean someoneKnowsJavaPython(){
//        return coders.stream().filter(c->c.getLanguagesKnown().contains("java") && c.getLanguagesKnown().contains("Python"))
//                              .findAny().isPresent();
        return coders.stream().anyMatch(c->c.knowsAll("java", "python"));
    }
    //creo una funzione che raggruppi gli studenti per genere
    public Map<Character, List<Coder>> groupBySex(){
        return coders.stream().collect(Collectors.groupingBy(Coder::getGender));
    }
    //creo un metodo che ritorna una mappa dei sessi e del numero di sviluppatori che hanno quel sesso;
    public Map<Character, Long> countBySex(){
        return coders.stream().collect(Collectors.groupingBy(Coder::getGender, Collectors.counting()));
    }
    //crea un metodo che in una sola iterazione mi crei un oggetto SalaryReport che contenga il totale dei salari
    // per maschi e per femmine
    public SalaryReport calcSalaryReport(){
//        SalaryReport sr = new SalaryReport();
//        for (Coder c : coders){
//            if (c.isMale()){
//                sr.addToMaleSalary(c.getSalary());
//            } else {
//                sr.addToFemaleSalary(c.getSalary());
//            }
//        }
//        return sr;
        return coders.stream().reduce(
                new SalaryReport(),
                (report, coder) -> {
                    if(coder.isMale()){
                        report.addToMaleSalary(coder.getSalary());
                    } else {
                        report.addToFemaleSalary(coder.getSalary());
                    }
                    return report;
                } ,null
        );

    }



}
