package org.generation.italy.examples.arrays.arrays;

public class Exercise8 {
    public static void main(String[] args){
        int a = 5;
        int risultato = fattoriale(a);
        System.out.println("Il fattoriale è: " + risultato);

    }

    public static int fattoriale(int a) {
        int fattoriale = 1;

        for (int i=a; i>= 1; i--) {
            fattoriale = fattoriale * i;
        }
        return fattoriale;
    }
}
