package org.generation.italy.examples.riccardoExercises;

public class Exercise3 {
    static void main() {
        /*
         Scrivi una funziona che riceve in input due stringhe e un carattere, e ritorna true
         se la prima stringa contiene quel carattere un numero di volte superiore alla seconda*/
        String s1 = "caccia";
        String s2 = "cane";
        boolean hasMore = hasMoreChar(s1,s2,'c');
        System.out.println(hasMore);
    }
    public static boolean hasMoreChar (String s1, String s2, char letter){
        boolean hasMore= false;
        int countLetterS1 = 0;
        int countLetterS2 = 0;

        for (int i = 0; i<s1.length();i++){
            if(s1.charAt(i) == letter){
                countLetterS1++;
            }
        }

        for (int i = 0;i<s2.length();i++){
            if(s2.charAt(i) == letter){
                countLetterS2++;
            }
        }

        if(countLetterS1>countLetterS2){
            return true;
        }else{
            return false;
        }
    }
}
