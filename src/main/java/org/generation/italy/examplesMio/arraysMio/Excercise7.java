package org.generation.italy.examplesMio.arraysMio;

// una funzione dato un array di interi  torna il numero ripetuto più volte. voglio solo un occorrenza se 2 numeri si ripetono più volte.

import java.util.Arrays;

public class Excercise7 {
    static void main() {
        int[] arr = new int[10];

        int[] countArr = new int[11];
        int maxCount = arr[0];
        int maxNumber = 0;
        String result = "";

        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 10) + 1;

            countArr[arr[i]]++;

        }
        for(int i = 0; i < arr.length; i++){
            if(countArr[i] > maxCount){
                maxCount = countArr[i];
                maxNumber = i;
            }
        }
        for(int i = 0; i < countArr.length; i++){
            if(countArr[i] == maxCount){
                result = result + i + " ";
            }

        }
        IO.println(Arrays.toString(arr));
        IO.println(result);


    }
}
