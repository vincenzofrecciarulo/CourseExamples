package org.generation.italy.examples.arrays;

import java.util.Arrays;

/* ES 1 dato un array di 10 elementi di qualunque tipo
inverti l'ordine degli elementi
 */
public class Exercise001 {
    public static void main() {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] temp = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            temp[numbers.length - 1 - i] = numbers[i];
        }
        IO.println(Arrays.toString(temp));
    }
}




