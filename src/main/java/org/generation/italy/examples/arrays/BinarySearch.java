package org.generation.italy.examples.arrays;

public class BinarySearch {

    static void main() {
        int[] nums = {12,45,65,78,89,90,123,124,456};
        int index =  indexOf(nums,456);
        System.out.println(index);
    }
    public static int indexOf(int[] num,int val){
        int start = 0;
        int end = num.length -1;
        int middle = num.length/2;

        while (start <= end){
            if(num[middle]== val){
                return middle;
            }
            if (val<num[middle]){
                end = middle -1;

            }else if(val>num[middle]){
                start = middle +1;
            }

            middle = (start + end)/2;

        }

       return -1;


    }


}


