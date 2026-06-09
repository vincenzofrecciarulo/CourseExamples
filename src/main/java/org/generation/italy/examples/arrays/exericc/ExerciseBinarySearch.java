package org.generation.italy.examples.arrays.exericc;

public class ExerciseBinarySearch {
    static void main() {
        int target = Integer.parseInt(IO.readln("Che valore devo cercare nella seguente lista:\n" +
                "1, 3, 7, 9, 13, 15, 20, 25, 30, 40, 56, 98, 100, 150, 300" +
                "\nTi dirò in che posizione è il tuo numero." +
                "\nQuindi il numero che hai è: "));
        int[] nums = {1, 3, 7, 9, 13, 15, 20, 25, 30, 40, 56, 98, 100, 150, 300};
        System.out.println("Perfetto! Il tuo numero si trova alla posizione: "+indexOf(nums, target));
    }

    public static int indexOf(int[] numbers, int target){
        int start = 0;
        int end = numbers.length - 1;

        while(start <= end){
            int middle = (start + end) / 2;

            if (numbers[middle] == target){
                return middle;

            } else if (numbers[middle] < target){
                start = middle +1;

            } else {
                end = middle -1;
            }
        }
        return -1; // should return the index if found, -1 if not found.
    }
}
