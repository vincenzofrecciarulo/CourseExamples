package org.generation.italy.examples.arrays;

public class ExerciseBinarySearch {
    static void main() {
        int[] nums = { 1, 3, 5, 6, 12, 16, 21 };
        int pos = binarySearch(nums, 12);
        System.out.println(pos);
    }

    public static int binarySearch(int[] nums, int target) {
        for(int start = 0, end = nums.length-1; start <= end; ) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
