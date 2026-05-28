// crare una funzione che riceve in input un array di interi che restituisca true se gli array
// non ha duplicati false se ha un numero almeno duplicato.

// [1, 2, 4, 3 ,4]


package org.generation.italy.examples.arrays.arrays;

public class Exercise5 {

    public static boolean nonHaDuplicati(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] == numbers[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] numbers = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        boolean risultato = nonHaDuplicati(numbers);

        System.out.println(risultato);
    }
}