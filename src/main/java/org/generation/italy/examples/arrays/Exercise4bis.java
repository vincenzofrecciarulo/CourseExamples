package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise4bis {

    static void main() {
        double[] array = new double[10];
        populateArray(array);
        IO.println(Arrays.toString(array));
        IO.println("Media senza min e max: " + trimmedAverage(array));
    }

    static void populateArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 100;
        }
    }

    static double trimmedAverage(double[] array) {
        double sum = 0;
        double min = array[0];
        double max = array[0];

        for (double x : array) {
            sum += x;
            if (x < min) min = x;
            if (x > max) max = x;
        }

        return (sum - min - max) / (array.length - 2);
    }
}