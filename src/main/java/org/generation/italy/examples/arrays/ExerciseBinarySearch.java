package org.generation.italy.examples.arrays;

public class ExerciseBinarySearch {
    static void main() {
        int[] nums = {1, 7, 12, 25, 26, 30, 31, 34, 40, 60, 62, 75, 100, 150};
        IO.println(indexOf(nums, 62));
    }
    public static int indexOf(int[] numbers, int target){
        int start = 0;
        int end = numbers.length - 1;
        int temp;

        while(start <= end){
            temp = ((start + end) / 2);
            if(target == numbers[temp]){
                return temp;
            }
            if(target < numbers[temp]){
                end = temp - 1;
            }else {
                start = temp + 1;
            }
        }
        return -1;
        //mi ritorna l'index se lo ha trovato, -1 se non lo ha trovato
    }
}
