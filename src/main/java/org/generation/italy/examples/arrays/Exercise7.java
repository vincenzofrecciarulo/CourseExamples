package org.generation.italy.examples.arrays;

public class Exercise7 {

    static void main() {
        int[] numbers = new int [50];
        Exercise2.populateArray(numbers);

        int maxIndex = 0;
        int maxNumber = 1;
        for (int i=0; i<numbers.length; i++) {
            if (manyDuplicates(numbers, i) > maxNumber) {
                maxIndex = i;
                maxNumber = manyDuplicates(numbers, i);
            }
        }

        System.out.println("Moda dell'array: " + numbers[maxIndex] + "\nRipetizioni: " + maxNumber + "\n\n");
        for (int i : numbers) {
            System.out.print(i+",");
        }
    }

    public static int manyDuplicates(int[] array, int start) {
        int  counter= 1;
        for (int i = start+1; i < array.length; i++) {

            if (array[i]==array[start]) {
                counter++;
            }
        }
        return counter;
    }




}
