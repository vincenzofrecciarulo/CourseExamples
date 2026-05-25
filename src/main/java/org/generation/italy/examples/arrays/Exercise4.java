package org.generation.italy.examples.arrays;
//Dato un array di 10 elementi, scrivere una funzione che popola l’array con double casuali di
//valore (0) - (100), invocarla sull’array e stamparne la media matematica
public class Exercise4 {
    static void main() {
        double array[] = new double[10];
    populateArrayD(array);
    double sum=0;
    int i;
    for( i=0;i<array.length;i++){
        sum=sum+array[i];
        }
    sum=sum / (i+1);
    System.out.println("The average value is: " + sum);
    }

    static void populateArrayD(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (double) (Math.random() * 100) + 1;
        }
    }
}

