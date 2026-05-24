package org.generation.italy.examples.arrays.casa.riccardo;

// Scrivi una funzione che riceve in input due stringhe e un carattere
// e ritorna true se la prima stringa contiene quel carattere un numero di volte superiore alla seconda

public class Exercise3 {
    public static void main(String[] args){

    }

    public static boolean checkCharacter (String firstStr, String secondStr, char c){
        int countFirstStr = 0, countSecondStr = 0;

        for(int i=0; i<firstStr.length; i++){
            if(c==firstStr[i]){
                countFirstStr++;
            }
        }

        for(int i=0; i<secondStr.length; i++){
            if(c==secondStr[i]){
                countSecondStr++;
            }
        }

        if(countFirstStr>countSecondStr)
    }
}
