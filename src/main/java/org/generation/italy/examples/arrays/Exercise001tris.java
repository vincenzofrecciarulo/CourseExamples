package org.generation.italy.examples.arrays;

//rifatto l'esercizio 1 per allenarmi alla battituta e la dicitura
//e il ragionamento
//faccio lo stesso per gli altri


import java.util.Arrays;

public class Exercise001tris{
public static void main() {
    int[] numbers={0,1,2,3,4,5,6,7,8,9};
    for(int i=0,j=numbers.length-1;i<j;i++,j--){
        int temp=numbers[i];
        numbers[i]=numbers[j];
        numbers[j]=temp;
    }
    IO.println(Arrays.toString(numbers));
    }
}

