package org.generation.italy.examples.arrays;

import com.generation.library.Console;

public class ExerciseBinary {
    static void main() {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        IO.println("Che numero devi trovare?");
        int target = Console.readInt();
        System.out.println(indexOf(nums, target));
    }

    public static int indexOf (int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;


        while (start <= end) {
            int found = (start + end) / 2;

            if (target == numbers[found]) return found;

            if (target < numbers[found]) {
                end = found - 1;
            } else {
                start = found + 1;
            }
        } return -1;
    }
}
