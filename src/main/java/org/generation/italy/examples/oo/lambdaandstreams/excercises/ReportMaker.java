package org.generation.italy.examples.oo.lambdaandstreams.excercises;

import java.util.List;
import java.util.function.Predicate;

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
}
