package org.generation.italy.examples.oo.lambdaandstreams.exercises;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportMaker {
    private List<Coder> coders;

    public ReportMaker(List<Coder> coders) {
        this.coders = coders;
    }
    // crea un metodo che restituiscela somma di tutti gli stipendi dei Coder nella lista coders.

    public double totSalary() {
        double sum = 0;
        for (Coder c : coders) {
            sum += c.getSalary();
        }
        return sum;
    }

    public double vintageSeniorMaleAverageSalary() {
        double sum = 0;
        int seniorcounter = 0;
        for (Coder c : coders) {
            if (c.getGender() == 'm' && c.isSenior()) {
                sum += c.getSalary();
                seniorcounter++;
            }
        }
        return sum / seniorcounter;
    }

    //ora famolo fancy con gli stream
    public double seniorMaleAverageSalary() {
        return coders.stream().filter(c -> c.isMale() && c.isSenior())
                              .mapToDouble(Coder::getSalary)
                              .average().orElse(0.0);
    }

    public double seniorFemaleAverageSalary() {
        return coders.stream().filter(c -> !c.isMale() && c.isSenior())
                              .mapToDouble(Coder::getSalary)
                              .average().orElse(0.0);
    }

    //adesso per entrambi i sessi
    public double seniorAverageSalary(boolean forMales) {
        return coders.stream().filter(c -> forMales? c.isMale() : !c.isMale() && c.isSenior())
                              .mapToDouble(Coder::getSalary)
                              .average().orElse(0.0);
    }

    //ora generale?
    public double seniorAverageSalaryLambda(Predicate<Coder> coderFilter){
        return coders.stream().filter(coderFilter)
                              .filter(Coder::isSenior)
                              .mapToDouble(Coder::getSalary)
                              .average().orElse(0.0);
    }

    //aiuto
    public double seniorAverageSalaryLambdaForAge (int age){
        return seniorAverageSalaryLambda(c -> c.getAge() > age);
    }

    //...
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

        return minMale > maxFemale;
    }

    //crea un metodo che ritorna nome e cognome di tutti i coder ordinati per salario discendente
    public List<String> getNamesOrderedBySalaryDescended(){
       // return coders.stream().sorted((c1, c2) -> Double.compare(c2.getSalary(), c1.getSalary())) // versione basic
        return coders.stream().sorted(Comparator.comparingDouble(Coder::getSalary).reversed())
                              .map(Coder::getFullName)
                              .toList();
    }

    //crea una funzione che ritorna il coder più giovane
    public Optional<Coder> getYoungerCoder(){
        return coders.stream().sorted(Comparator.comparingInt(Coder::getAge))
                              .findFirst();
    }

    //altro metodo uguale a quello sopra ma con esecuzione diversa
    public Optional<Coder> getYoungerCoder2(){
        return coders.stream().min(Comparator.comparingInt(Coder::getAge));
    }

    //crea un metodo che trova il primo coder assunto a paritre da una determinata data inserita in input
    public Optional<Coder> getFirstCodefrom(LocalDate date){
        return coders.stream().filter(c -> c.getHiredate().isAfter(date))
                              .min(Comparator.comparing(Coder::getHiredate));
    }

    //crea un metodo che ritorna la lista di tutti i linguaggi conosciuta dai miei coder, senza ripetizioni
    public Set<String> getAllLanguages(){
        var s= coders.stream().flatMap(c -> c.getKnownLanguages().stream()); //flatmap per stream di stringhe
     // return s.distinct().toList(); //restituisce la lista senza ripetizioni
        return s.collect(Collectors.toSet()); //oppure colleziono tutto su un set che non accetta dupplicati
    }

    //crea un metodo che ritorna il numero di Java Coder in azienda
    public int howManyJavaCoders(){
//      return (int)coders.stream().filter(c -> c.getKnownLanguages().contains("Java"))  // versione senza flatmap
//                                 .count();
        return (int)coders.stream().flatMap(c -> c.getKnownLanguages().stream())
                              .filter(s -> s.equals("java"))
                              .count();
    }

    //e se volessi sapere se abbiamo almeno un Coder di sia Java che Phyton?
    public boolean someoneKnowsJavaPython(){
//      return coders.stream().filter(c -> c.getKnownLanguages().contains("java") && c.getKnownLanguages().contains("python"))
//                            .findAny().isPresent();     //versione basic
        return coders.stream().anyMatch(c -> c.knowsAllLanguages("java", "python"));
    }

    // crea una funzione che raggruppi i Coder per sesso, ovvero una mappa che ritorna chiave e valore con nome e sesso
    public Map<Character, List<Coder>> groupBySex(){
        return coders.stream().collect(Collectors.groupingBy(Coder::getGender)); //groupingBy raggruppa gli elementi dello stream in una mappa seconda una certa chiave
    }

    // crea un metodo che ritorna una mappa dei sessi e del numero di Coder che hanno quel sesso
    public Map<Character, Long> countBySex(){
        return coders.stream().collect(Collectors.groupingBy(Coder::getGender, Collectors.counting()));
    }

    // crea un metodo che in una sola operazione mi crea un oggetto report che contiene il toale di salari per maschi e per femmine
    public SalaryReport calculateSalaryReport(){
//        SalaryReport sr = new SalaryReport();
//        for (Coder c : coders){
//            if (c.isMale()){
//                sr.addToMaleSalary(c.getSalary());
//            }
//            if (!c.isMale()){
//                sr.addToFemaleSalary(c.getSalary());
//            }
//        }
//        return sr;
        // ora rifamolo con gli stream ma complesso
        return coders.stream().reduce(
                new SalaryReport(),
                (report, coder) -> {
                    if (coder.isMale()){
                        report.addToMaleSalary(coder.getSalary());
                    } else {
                        report.addToFemaleSalary(coder.getSalary());
                    }
                    return report;
                }, null
        );
    }
}
