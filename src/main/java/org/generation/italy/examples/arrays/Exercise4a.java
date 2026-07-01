package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise4a {
    /*Dato un array di 10 elementi, scrivere una funzione che popola 
    l’array con double casuali di valore (0) - (100), 
    invocarla sull’array e stamparne la media matematica*/
    public static void main(){
        double[] doubles=new double[10];
        populateDoubles(doubles);
        System.out.println("L'ARRAY GENERATO E': ");
        System.out.println(Arrays.toString(doubles));
        double avg= getAvgDoubles(doubles);
        System.out.println("LA MEDIA MATEMATICA E': "+avg);
        /*Rifarlo ma calcolando la media senza il
        valore massimo e il valore minimo */
        avg= avgWithoutExtremes(doubles);
        System.out.println("LA MEDIA MATEMATICA SENZA IL VALORE MASSIMO E MINIMO E': "+avg);
        //Popolare l’array e stamparne solo gli elementi che distano più di 10 dalla media di tutto l’array
        avg=getAvgDoubles(doubles);
        int dist=10;
        printFurtherthan(doubles,avg,dist);

    }

    private static void printFurtherthan(double[] doubles, double avg, int dist) {
        System.out.println("GLI ELEMENTI CHE DISTANO PIU' DI "+dist+" SONO: ");
        for (int i = 0; i < doubles.length; i++) {
            if(doubles[i]<avg-dist || doubles[i]>avg+dist)
                System.out.print(doubles[i]+", ");

        }
    }

    public static double avgWithoutExtremes(double[] doubles) {
        double max=doubles[0];
        double min=doubles[0];
        double sum=0;
        int i;
        for (i = 1; i < doubles.length; i++) {
            max= max<doubles[i]? doubles[i] : max;
            min= min>doubles[i]? doubles[i] : min;

        }
        int counterExtremes=0;
        for (i = 0; i < doubles.length; i++) {
            if(doubles[i]!=max && doubles[i]!=min)
                sum+=doubles[i];
            else
                counterExtremes++;
        }
        return (counterExtremes==doubles.length)? 0 : sum/(i-counterExtremes);
    }

    public static double getAvgDoubles(double[] doubles) {
        double sum = 0;
        int i;
        for (i = 0; i < doubles.length; i++) {
            sum += doubles[i];

        }
        return (sum / i);

    }

    private static void populateDoubles(double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i]=(Math.random()*(101));
        }
    }
}
