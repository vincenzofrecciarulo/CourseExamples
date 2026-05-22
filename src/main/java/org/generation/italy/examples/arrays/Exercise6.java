package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise6 {
    static void main() {
        String[] drunkPath = new String[11];
        Arrays.fill(drunkPath,"_");
        drunkPath[5]="⏏";
        int posDrunk = 5;
        int posDrunkpre;

        while (true) {
            printArray(drunkPath);

            int random = (int)(Math.random()*101);
            if (random >= 50) {
                posDrunkpre = posDrunk;
                posDrunk += 1;
            } else {
                posDrunkpre = posDrunk;
                posDrunk -= 1;
            }

            if (posDrunk < 0 || posDrunk >= drunkPath.length) {
                System.out.println("\nIl bro si è perso...... R.I.P.");
                System.exit(0);
            }
            swap(drunkPath, posDrunk, posDrunkpre);
        }
    }

    public static void swap (String[] string, int x, int y) {
        String temp = string[x];
        string[x] = string[y];
        string[y] = temp;
    }

    public static void printArray (String[] string) {
        for (int i = 0; i < string.length; i++) {
            System.out.print(string[i]);
        }
        System.out.println("");
    }

}
