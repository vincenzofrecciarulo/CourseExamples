package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise4tris {

    static void main() {
        double[] array = new double[10];
        populateArray(array);
        IO.println(Arrays.toString(array));
        IO.println("Media: " + average(array));
        printFarFromAverage(array, 10);
    }

    static void populateArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 100;
        }
    }

    static double average(double[] array) {
        double sum = 0;
        for (double x : array) {
            sum += x;
        }
        return sum / array.length;
    }

    static void printFarFromAverage(double[] array, double threshold) {
        double avg = average(array);

        for (double x : array) {
            if (Math.abs(x - avg) > threshold) {
                IO.println(x);
            }
        }
    }
}