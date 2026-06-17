package org.generation.italy.examples.oo.practiceexercises.streamandlambdaexercise.asinc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Start {
    static void main() {

        PersonReporter pr= new PersonReporter();

        pr.filteredByFemale().forEach(System.out::println);





    }
}
