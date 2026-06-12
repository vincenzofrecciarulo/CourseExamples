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

    // metodo che restituisce la somma di tutti gli stipendi dei Coder.

    public double vintageSeniorMaleAverageSalary(){
        double sum = 0;
        int count = 0;

        for (Coder c : coders){
            if(c.getGender() == 'm' && c.isSenior()){
                sum += c.getSalary();
                count++;
            }
        }
        return sum / count;
    }

  /*  public double seniorMaleAverageSalary(){
        return coders.stream()
                .filter((c) -> c.isMale() && c.isSenior())
                .mapToDouble(Coder::getSalary)
                .average().orElse(0.0);
    }

    public double seniorFemaleAverageSalary(){
        return coders.stream()
                .filter((c) -> !c.isMale() && c.isSenior())
                .mapToDouble(Coder::getSalary)
                .average().orElse(0.0);
    }*/

    public double seniorAverageSalary(boolean forMales){
        return coders.stream()
                .filter((c) -> forMales ? c.isMale() : !c.isMale() && c.isSenior())
                .mapToDouble(Coder::getSalary)
                .average().orElse(0.0);
    }

    public double seniorAverageSalaryLambda(Predicate<Coder> coderFilter){
        return coders.stream()
                .filter(coderFilter)
                .filter(Coder::isSenior)
                .mapToDouble(Coder::getSalary)
                .average().orElse(0.0);
    }

    public double seniorAverageSalaryLambdaForAge(int age){
        return seniorAverageSalaryLambda(c -> c.getAge() > age);
    }

    public boolean worldIsInOrder(){
        double minMale = coders.stream()
                .filter(Coder::isMale)
                .mapToDouble(Coder::getSalary)
                .min().orElse(0.0);

        if(minMale == 0){
            return true;
        }

        double maxFemale = coders.stream()
                .filter(Coder::isFemale)
                .mapToDouble(Coder::getSalary)
                .min().orElse(0.0);

        return minMale >= maxFemale;
    }

    // creare un metodo che ritorni un nome e cognome dei coder ordinati per salario

    public List<String> getNamesOrderedBySalaryDescend(){
        //return coders.stream().sorted((c1, c2) -> Double.compare(c2.getSalary() - c1.getSalary()))
        return coders.stream()
                .sorted(Comparator.comparingDouble(Coder::getSalary).reversed())
                .map(Coder::getFullName)
                .toList();
    }

    // metodo che ritorna il coder più giovane

 /*   public Optional<Coder> getYoungerCoder(){
        return coders.stream()
                .sorted(Comparator.comparingDouble(Coder::getAge))
                .findFirst();

    }  */

    public Optional<Coder> getYoungerCoder2(){
        return coders.stream()
                .min(Comparator.comparingInt(Coder::getAge));

    }

    // metodo che trova il primo sviluppatore assunto dopo una certa data che il metodo riceve in input

    public Optional<Coder> getFirstNameByDate(LocalDate date){
        return coders.stream()
                .filter(c -> c.getHiredate().isAfter(date))
                .min(Comparator.comparing(Coder::getHiredate));
    }

    // metodo che ritorna la lista di tutti i linguaggi conosciute dai miei coder senza ripetizioni

    public Set<String> getAllLanguages(){
        var s = coders.stream()
                .flatMap(c -> c.getLanguagesKnows().stream());
        return s.collect(Collectors.toSet());
    }

    public int javaCoders(){
       /* return (int) coders.stream()
                .filter(c -> g.getLanguagesKnows().contains("Java"))
                .count();*/
        return (int) coders.stream()
                .flatMap(c -> c.getLanguagesKnows().stream())
                .filter(s -> s.equals("Java"))
                .count();
    }

    public boolean knowsPhytonJava(){
        return coders.stream()
                .anyMatch(c -> c.knowsAll("java", "phyton"));
    }

    // metodo che raggruppi i programmatori per sesso
    public Map<Character, List<Coder>> groupBySex(){
        return coders.stream()
                .collect(Collectors.groupingBy(Coder::getGender));
    }

    // metodo che ritorna una mappa dei sessi e del numero di sviluppatori appartenenti a tale sesso
    public Map<Character, Long> countBySex(){
        return coders.stream()
                .collect(Collectors.groupingBy(Coder::getGender, Collectors.counting()));
    }

    // metodo con una sola iterazione mi crea un report che contiene il tot dei salari per maschi e femmine
    public SalaryReport calculateSalaryReport(){
       /* SalaryReport sr = new SalaryReport();
        for (Coder c : coders){
            if(c.isMale()){
                sr.addToMaleSalary(c.getSalary());
            } else{
                sr.addToFemaleSalary(c.getSalary());
            }
        }
        return sr;*/

        return coders.stream()
                .reduce(
                        new SalaryReport(),
                        (report, coder) -> {
                            if(coder.isMale()){
                                report.addToMaleSalary(coder.getSalary());
                            } else{
                                report.addToFemaleSalary(coder.getSalary());
                            }
                            return report;
                        }, null
                );
    }

}
