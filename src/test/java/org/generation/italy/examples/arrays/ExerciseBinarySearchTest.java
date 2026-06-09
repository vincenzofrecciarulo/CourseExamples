package org.generation.italy.examples.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseBinarySearchTest {

    @ParameterizedTest(name = "binarySearch({0}, {1}) -> {2}")
    @MethodSource("provideArraysForSearch")
    void parameterizedBinarySearch(int[] nums, int target, int expected) {
        assertEquals(expected, ExerciseBinarySearch.binarySearch(nums, target));
    }

    static Stream<Arguments> provideArraysForSearch() {
        // large even-numbered array
        int size = 1000;
        int[] large = IntStream.range(0, size).map(i -> i * 2).toArray();

        return Stream.of(
                Arguments.of(new int[] {}, 5, -1), // empty
                Arguments.of(new int[] {7}, 7, 0), // single found
                Arguments.of(new int[] {7}, 3, -1), // single not found
                Arguments.of(new int[] {1,3,5,7,9,11,13}, 1, 0), // start
                Arguments.of(new int[] {1,3,5,7,9,11,13}, 7, 3), // middle
                Arguments.of(new int[] {1,3,5,7,9,11,13}, 13, 6), // end
                Arguments.of(new int[] {2,4,6,8,10}, 5, -1), // between
                Arguments.of(new int[] {2,4,6,8,10}, 1, -1), // before first
                Arguments.of(new int[] {2,4,6,8,10}, 11, -1), // after last
                Arguments.of(new int[] {-10, -5, -2, 0, 3}, -2, 2), // negatives
                Arguments.of(large, -1, -1), // large not found low
                Arguments.of(large, size * 2 + 1, -1), // large not found high
                Arguments.of(large, 500, 250) // large found
        );
    }

    @Test
    void testDuplicates() {
        int[] nums = {1,2,2,2,3,4};
        int pos = ExerciseBinarySearch.binarySearch(nums, 2);
        assertTrue(pos >= 1 && pos <= 3, "Expected an index of one of the duplicate entries");
        assertEquals(2, nums[pos]);
    }
}

