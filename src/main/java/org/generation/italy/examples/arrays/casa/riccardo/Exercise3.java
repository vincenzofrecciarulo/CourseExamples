package org.generation.italy.examples.arrays.casa.riccardo;

// Scrivi una funzione che riceve in input due stringhe e un carattere
// e ritorna true se la prima stringa contiene quel carattere un numero di volte superiore alla seconda

public class Exercise3 {
    public static void main(String[] args){
        String firstWord = IO.readln("Inserisci la prima parola: ");
        String[] firstArrayStr = firstWord.split("");

        String secondWord = IO.readln("Inserisci la seconda parola: ");
        String[] secondArrayStr = secondWord.split("");

        char character = IO.readln("Inserisci un carattere: ").charAt(0);

        if (checkCharacter(firstArrayStr, secondArrayStr, character)){
            System.out.println("La prima stringa contiene il carattere " + character + " più volte della seconda stringa.");
        } else{
            System.out.println("La prima stringa NON contiene il carattere " + character + " più volte della seconda stringa.");
        }

    }

    public static boolean checkCharacter (String[] firstStr, String[] secondStr, char c){
        int countFirstStr = 0, countSecondStr = 0;

        String charTarget = String.valueOf(c);

        for(int i=0; i<firstStr.length; i++){
            if(firstStr[i].equalsIgnoreCase(charTarget)){
                countFirstStr++;
            }
        }

        for(int i=0; i<secondStr.length; i++){
            if(secondStr[i].equalsIgnoreCase(charTarget)){
                countSecondStr++;
            }
        }

        return countFirstStr > countSecondStr;
    }
}
