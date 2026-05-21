package org.generation.italy.examples.arrays;
//Dato un array di 10 elementi, scrivere una funzione che lo popola con double casuali di valore 0-100
//Invocarla sull'array e stamparne la media matematica
//Poi rifarlo, ma senza calcolare il valore max e minimo
//Poi stampare solo gli elementi che distano più di 10 dalla media di tutto l'array.

public class Exercise5 {
    public static void main() {
        double[] numbers = new double[10];
        populateArray(numbers);
        IO.println("La media dei valori nell'array è pari a: " + averageArray(numbers));
        IO.println("\nLa media ristretta (senza i due valori estremi) è pari a: " + averageArrayTight(numbers));
        IO.println("\nDi seguito, tutti i valori: \n");
        for (double i : numbers) {
            IO.println(i);
        }
        IO.println("\nDi seguito, tutti i valori lontani almeno dieci cifre dalla mediana: \n");
        for (int i = 0; i < numbers.length; i++) {
            if ((numbers[i] > (averageArray(numbers) + 10)) || (numbers[i] < (averageArray(numbers) - 10))) {
                IO.println(numbers[i]);
            }
        }
    }

    public static void populateArray(double[] array) {
        double x;
        for (int i=0; i<array.length; i++) {
            x = Math.random()*101;
            if (x > 100) {          // Scalare * 100 ci fa arrivare a 99,9999999, ci perdiamo il 100
                x = 100;            // Così arriviamo a 100,999999999 e lo schiacciamo a 100
            }                       // * 100 con offset + 1 al contrario perdiamo lo 0 ( sarebbe valido se 1-100, non 0-100)
            array[i] = x;
        }
    }

    public static double averageArray(double[] array) {
        double sum = 0;
        for (double i : array) {
            sum += i;
        }
        return sum/array.length;
    }

    public static double findMax(double[] array) {
        double max = array[0];
        for (int i=1; i<array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static double findMin(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

        public static double averageArrayTight(double[] array) {
            double sum = 0;
            for (double i : array) {
                if (i < findMin(array) || i > findMin(array))
                sum += i;
            }
            return sum/array.length-2;
        }
}
