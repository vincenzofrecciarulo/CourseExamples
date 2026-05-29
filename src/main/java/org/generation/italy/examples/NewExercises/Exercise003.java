package org.generation.italy.examples.NewExercises;

public class Exercise003 {
    public static boolean compare(String Parola1, String Parola2, char Carattere) {

        int count1= 0;
        int count2= 0;

        for (int i=0; i < Parola1.length(); i++) {
            if (Parola1.charAt(i) == Carattere) {
                count1++;
            }
        }

        for (int i=0; i < Parola2.length(); i++) {
            if (Parola2.charAt(i) == Carattere) {
                count2++;
            }
        }
        return count1 > count2;
    }
}
