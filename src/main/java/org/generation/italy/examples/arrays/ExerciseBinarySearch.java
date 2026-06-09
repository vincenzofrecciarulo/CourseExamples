package org.generation.italy.examples.arrays;

public class ExerciseBinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 9, 13, 15, 20, 25, 30, 40, 56, 98, 100, 150, 300};
    }

    public static int indexOf(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int current;

        while(start <= end) {
            current = start + (end - start) / 2;
            if (numbers[current] == target) {
                return current;
            } else if (numbers[current] < target) {
                start = current + 1;
            } else if (numbers[current] > target) {
                end = current - 1;
            }
        }

        return -1; // should return the index if found, -1 if not found
    }
}
