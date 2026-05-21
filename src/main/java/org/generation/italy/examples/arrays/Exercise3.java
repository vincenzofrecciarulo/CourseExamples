package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise3 {
    /*
    * FARE UNA FUNZIONE CHE RICEVE IN INPUT UN ARRAY E
    * LO INVERTE SENZA CREARE UN ALTRO ARRY D'APPOGGIO
    * */
    public static void main(String[] args) {
        int[] array={1,51,6,1,2,5,84,6,1};
        IO.println(Arrays.toString(array));
        invertArray(array);
        IO.println(Arrays.toString(array));

    }

    public static void invertArray(int[] array) {
        for(int i=0,j= array.length-1;i<j;i++,j--){
            swapArray(array,i,j);
        }
    }
    public static void swapArray(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

}
