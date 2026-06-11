package org.generation.italy.examplesMio.arraysMio;

// indice in cui il numero target appare nell'array targe, se non c'è torna -1
// unit test per il funzionamento

import java.util.ArrayList;
import java.util.List;

public class ExcerciseBinarySearch {

    static void main() {
        int[] nums = {1, 3, 5, 7, 10, 22, 24, 39, 59};

        List<Integer> nums2 = List.of(1,2,3,4,5,6,7,8);

        System.out.println(indexOfList(nums2, 3));

    }

    public static int indexOfList(List<Integer> n, int target2){
        return n.indexOf(target2);
    }

    public static int indexOf(int[] numbers, int target){
        int start = 0;
        int end = numbers.length -1;

        while(start <= end){
            int center = (start + end) / 2;
            if(numbers[center] == target){
                return center;
            } else if(target < numbers[center]){
                end = center -1;
            } else{
                start = center + 1;
            }
        }
        return -1;


        // approccio lineare
        /*

        while(start < numbers.length){
            if(numbers[start] == target){
                return start;
            }
            start++;
        }
        return -1;

         */
    }

}
