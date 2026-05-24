package org.generation.italy.examples.arrays.casa.riccardo;

// Scrivi una funzione che riceve in input due stringhe e un carattere
// e ritorna true se la prima stringa contiene quel carattere un numero di volte superiore alla seconda

// Ho dovuto utilizzare i comandi "split" e "charAt" anche se non li abbiamo visti a lezione
// però li ho utilizzati solo nel main e non nella funzione

public class Exercise3 {
    public static void main(String[] args){
        String firstWord = IO.readln("Inserisci la prima parola: ");
        String[] firstArrayStr = firstWord.split(""); // "split" converte una stringa in un vettore stringa. In questo caso divide la stringa su ogni carattere vuoto tra le lettere, ottenendo esattamente un elemento per ogni carattere

        String secondWord = IO.readln("Inserisci la seconda parola: ");
        String[] secondArrayStr = secondWord.split("");

        String characterStr = IO.readln("Inserisci un carattere: ")
        char character = characterStr.charAt(0); // "readln" restituisce sempre una stringa.
                                                 // Il comando "charAt" converte quella stringa in un carattere.
                                                 // In questo caso, "charAt(0)" restituisce la prima posizione della stringa convertita

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
