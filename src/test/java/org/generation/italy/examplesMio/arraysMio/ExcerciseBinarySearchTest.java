package org.generation.italy.examplesMio.arraysMio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExcerciseBinarySearchTest {

    @Test
    void indexOff() {
        int[] nums = {1,2,3,45,67,78,87,99,200,1923};
        int result = ExcerciseBinarySearch.indexOf(nums, 45);
        assertEquals(3, result);
    }
}