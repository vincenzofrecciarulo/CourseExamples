package org.generation.italy.examples.homework;

public class Exercise3 {

    /*
    3)Scrivi una funziona che riceve in input due stringhe e un carattere,
    e ritorna true se la prima stringa contiene quel carattere un numero di volte superiore alla seconda
     */

    static boolean isCharFoundMoreOnFirstString(String firstString, String secondString, char c){
        int recurrenceOnFirstString = 0;
        int recurrenceOnSecondString = 0;

        for(int i = 0; i < firstString.length(); i++){
            if(firstString.charAt(i) == c){
                recurrenceOnFirstString++;
            }
        }

        for(int i = 0; i < secondString.length(); i++){
            if(secondString.charAt(i) == c){
                recurrenceOnSecondString++;
            }
        }

        return recurrenceOnFirstString > recurrenceOnSecondString;
    }
}
