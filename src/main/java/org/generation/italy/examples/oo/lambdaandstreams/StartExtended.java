package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StartExtended {
    //strandardizziamo le stringhe, contiamo quante lettere contengono le parole, le concateniamo in una singola stringa
    // ed infine le restituiamo in una sola stringa

    //Scrivere uno Stream che utilizza le lambda degli esercizi 5-7, esso deve:
    //1) filtrare i valori tenendo solo i pari
    //2) sommarli al contatore statico
    //3) elevarli al quadrato
    //4) restituire il risultato in una lista
    //Successivamente il programma deve mostrare il risultato


    static void main() {
//        List<String> words = Arrays.asList(" Pippo ", " Paperino", "Pluto "); //asList metodo statico della classe Arrays
//        LambdaLibraryExtended.charCounter.accept(words.get(0));
//        System.out.println(LambdaLibraryExtended.getCount());
//        System.out.println(LambdaLibraryExtended.standardize.apply(words.get(0)));
//        System.out.println(LambdaLibraryExtended.concat.apply(words.get(0), words.get(1)));
//        Optional<String> result = words.stream()
//                .map(LambdaLibraryExtended.standardize)
//                .peek(LambdaLibraryExtended.charCounter)
//                .reduce(LambdaLibraryExtended.concat);
//        System.out.println(" ");
//        System.out.println(result);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> result2 = numbers.stream()
                .filter(LambdaLibraryExtended.isEven)
                .peek(LambdaLibraryExtended.addToSum)
                .reduce(LambdaLibraryExtended.returnSquared);
        System.out.println(" ");
        System.out.println(result2);





    }
}
