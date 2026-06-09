package org.generation.italy.examples.arrays;

public class EserciziBinarySearch {

    public static int indexOf(int[] numbers, int target){
        int start = 0;
        int end = numbers.length - 1;
        while(start <= end){
            int middle = (start + end) / 2;
            if(target > numbers[middle]){
                start = middle + 1;
            }else if(target < numbers[middle]){
                end = middle - 1;
            }else{
                return middle;
            }
        }

        return -1;
    }
}
