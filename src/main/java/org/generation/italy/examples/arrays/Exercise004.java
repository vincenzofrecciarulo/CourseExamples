package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*dato un array di 10 elementi, scrivere una funzione che
popola l'array con double casuali di valore da 0 a 100
invocarla sull'array e stamparne la media matematica
 */
public class Exercise004 {
    public static void main(){
        double[] numbers= new double[10];
        populateDouble(numbers);
        double sum=0.0;
        double avr=0.0;
        for(int i=0;i<numbers.length;i++){
            sum+=numbers[i];
        }
        avr=sum/numbers.length;
        IO.println(Arrays.toString(numbers));
        IO.println(avr);

    }

    static void populateDouble(double[] numbers) {
        for(int  i=0;i<numbers.length;i++){
            numbers[i]=Math.random()*100;
        }
    }
}
